package com.LockMe;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager 
{
	/**
	 * This method return file name.
	 * @param folderpath
	 * @return List of String.
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		//create file object
			File Fl=new File (folderpath);
			
		//getting file array.
			File[] listOfFiles=Fl.listFiles();
			
			//declare list of array for name and sorting it by Collection.sort() method.
			List<String> fileNames =new ArrayList<String>();
			Collections.sort(fileNames); 
			
			for(File f:listOfFiles)
			fileNames.add(f.getName());
			//returnning the name if files
			return fileNames;
		}
	/**
	 * use for writing content to file and adding a new text file.
	 * @param folderpath
	 * @param fileNames
	 * @param content
	 * @return boolean
	 */
	public static boolean addToFolder(String folderpath, String fileName, List<String> content) 
	{
		try 
		{
		File fl=new File(folderpath, fileName);
				FileWriter fw =new FileWriter(fl);
				
				for(String s:content)
				{
					fw.write(s+"\n");
				}
				fw.close();
				return true;
		}
		catch(Exception Ex) 
		{
			return false;
		}
	}
	/**
	 * Use for deleting file drom specified forlder
	 * @param folderpath
	 * @param fileName
	 * @return Boolean
	 */
	public static boolean deleteFile(String folderpath, String fileName) 
	{
		//declaring object for taking file name and path
	File fd=new File(folderpath+"\\"+fileName);
	//handling Empty File Exception
	try 
	{
		if(fd.delete())
			return true;
		else
			return false;
	}
	catch (Exception Ex) 
	{
		return false;
	}
	}
	/**
	 * use this for searching the if specified file in folder
	 * @param folderpath
	 * @param fileName
	 * @return
	 */
	public static boolean searchFile(String folderpath, String fileName)
	{
		//declaring object same as deleteFile obj.
		File fs=new File(folderpath+"\\"+fileName);
		if(fs.exists())
			return true;
		else
			return false;
	}
}
