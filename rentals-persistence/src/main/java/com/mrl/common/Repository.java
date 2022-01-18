package com.mrl.common;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class Repository {

	
	private Map<String, String> fileLocations = new HashMap<>();
	private String fileLocationsPath = "./";
	
	public void setFileLocationsPath(String fileLocationsPath) {
		this.fileLocationsPath = fileLocationsPath;
		createFile(fileLocationsPath);
	}
	
	protected Repository () {
		createFile(fileLocationsPath);
	}
	
		
	/**
	 * If no repository file currently exists create it.
	 * 
	 * @param String path: Path to file
	 * @return boolean true if the repository file is accessible false if not
	 */
	protected boolean createFile(String path) {
		File file = new File(path);
		if(!file.exists())
			try {
				file.createNewFile();
			} 
      		catch (IOException e) {
      			return false;
      		}
		
        return true;
    }
	
	/*
	 * 
	 * @param path
	 * @return
	 */
	private boolean deleteFile(String path) {
		File file = new File(path);
		if(!file.isFile()) 
			return true;
		
		return file.delete();
	}
	
	/**
	* Gets all objects of type T from the repository at path
	* 
    * @return List<Driver>
	*/
	protected <T> List<T> getList(String path, Class<T> clazz) {
		
		String actualPath = fileLocations.get(path);
		if(actualPath == null)
			return new ArrayList<>();
		
		File file = new File(actualPath);
		
		if(!file.isFile()) 
			return new ArrayList<>();
		
		try (FileReader reader = new FileReader(actualPath)) {
			List<T> list = new Gson().fromJson(reader, new TypeToken<List<T>>() {}.getType());
			
			if(list == null)
				return new ArrayList<>();
			
			return list;
		} 
		catch (JsonIOException | JsonSyntaxException | IOException e) {
			return new ArrayList<>();
		}
	}
	
	/*
	* Gets all objects of type T from the repository at path
	* 
    * @return List<Driver>
	*/
	private Map<String, String> getFileLocations(String path) {
		File file = new File(path);
		if(!file.isFile())
			return new HashMap<>();
		
		try (FileReader reader = new FileReader(path)){
			Map<String, String> list = new Gson().fromJson(reader, new TypeToken<Map<String, String>>() {}.getType());
			if(list == null)
				return new HashMap<>();
			
			return list;
		} 
		catch (JsonIOException | JsonSyntaxException | IOException e) {
			return new HashMap<>();
		}
	}

	
	/**
	 * Saves object t of Class T to the repository specified by path
	 * 
	 * @param <T>
	 * @param path
	 * @param t
	 * @return
	 */
	protected <T> boolean save(String path, Class<T> clazz, T t) {
		
		
		Transaction transaction = openTransaction(path, clazz, t);
		return commitTransaction(path, clazz, t, transaction);
	}
	
	

	/*
	 * 
	 * @param <T>
	 * @param path
	 * @param clazz
	 * @param t
	 * @return
	 */
	private <T> Transaction openTransaction(String path, Class<T> clazz, T t) {
		Transaction transaction  = new Transaction();

		transaction.oldPath = fileLocations.get(path);
		transaction.newPath = path.replaceFirst("\\.json", (UUID.randomUUID() + ".json"));
		createFile(transaction.newPath);
		
		return transaction;
	}
	
	
	/*
	 * 
	 * @param <T>
	 * @param path
	 * @param clazz
	 * @param t
	 * @param transaction
	 * @return
	 */
	private <T> boolean commitTransaction(String path, Class<T> clazz, T t, Transaction transaction) {
		
		List<T> objects = getList(path, clazz);
		objects.add(t);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		boolean hasSaved = save(transaction.newPath, gson.toJson(objects));
			
		if(hasSaved && fileLocations.put(path, transaction.newPath) != null )
			deleteFile(transaction.oldPath);

		return true;
	}
	
	
	
	
	/*
	 * Saves the provided json to a file at the specified path
	 * 
	 * @param path
	 * @param json
	 * @return
	 */
	private boolean save(String path, String json) {
		try (FileWriter myWriter = new FileWriter(path)){
		    myWriter.write(json);
		    return true;
		} 
		catch (IOException e) {
		    return false;
		}
	}
	
	
	
	/*
	 * 
	 *
	 * @param <T>
	 */
	private class Transaction {
		String oldPath;
		String newPath;
	}
	
}
