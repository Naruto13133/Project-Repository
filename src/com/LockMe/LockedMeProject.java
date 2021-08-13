package com.LockMe;
	import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	public class LockedMeProject {
	static final String folderpath="C:\\text_files";
	public static void main(String[] args) 
	{
		//VARIABLE DECLYARATION 
		int contn=1;
		do
		{
			
			int i;
			i=LockedMeProject.UIMENU();
			
		
			switch(i) {
			case 1:
		    // PRINT FILL CONTENT
			LockedMeProject.fileGet();  
		    break;
			case 2:
		    // ADD FILES TO FOLDER
			  LockedMeProject.fileAdd();
		    break;
			case 3:
			    // SEARCH FILE IN FOLDER
				LockedMeProject.fileSearch();  
			    break;
			case 4:
			    // DELETE FILE IN FOLDER
				LockedMeProject.fileDelete();  
			    break;
			case 5:
			  //STOPPING EXICUTION 
			    System.exit(0);
				  
			    break;
			 
			default:
		    // FOR INVALID INPUT
			  System.out.println("INVALID INPUT:");
				
		}
	}while(contn>0);
		}
	
	//declaring methods for performing different operation
	public static int UIMENU()
	{
		int ch;
	//USER INTERFACE
	System.out.println("****************************************************");
	System.out.println("\t\tCompany lockers private limited\t\t");
	System.out.println("1.DISPLAY ALL FILES");
	System.out.println("2.ADD OR CREATE FILE");
	System.out.println("3.SEARCH A FILE");
	System.out.println("4.DELETE FILE");
	System.out.println("5.EXIT");
	System.out.println("****************************************************");
	System.out.println("ENTER YOUR CHOICE");
	Scanner sc=new Scanner(System.in);
	ch=Integer.parseInt(sc.nextLine());
	//sc.close();
	return ch;
	}
	public static void fileGet() 
	{
		//calling method for getting file name from it.
		List<String> fileNames=FileManager.getAllFiles(folderpath);
		//printing arraylist of name
			for(String f:fileNames)
			System.out.println(f);
	}
	public static void fileAdd() 
	{
		//declaring var
				Scanner obj=new Scanner(System.in);
				String fileName;
				int lineCount;
				List<String> content= new 	ArrayList<String>();
				//input for name from user
				System.out.println("Enter File Name:");
				fileName=obj.nextLine();
				
				// taking number of line from user
				
				System.out.println("Enter Number of lines to be added:");
				lineCount=Integer.parseInt(obj.nextLine());
				//looping for taking input line by line from user
				for(int i=1;i<=lineCount;i++)
				{
					System.out.println("Enter Line:"+i);
					content.add(obj.nextLine());
				}
			//save content to the file
				boolean isSave=FileManager.addToFolder(folderpath,fileName,content);
				if(isSave)
					System.out.println("File is saved .");
				else
					System.out.println("File is NOT saved.");
				//clossing scanner;
				//obj.close();
	}
	public static void fileDelete() 
	{
		//declaring variable
				String fileName;
				Scanner obj=new Scanner(System.in);
				System.out.println("Enter the file name to be deleted:");
				fileName=obj.nextLine();
				//obj.close();
				//Calling deleteFile method for deleting .
				boolean Deleted=FileManager.deleteFile(folderpath,fileName);
				
				if(Deleted) 
					System.out.println("Deleted.");
					else
						System.out.println("Not Deleted");
	}
	public static void fileSearch() 
	{
		//declaring variable
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the file name to be Searched:");
		fileName=obj.nextLine();
		//obj.close();
		//Calling searchFile method method for searching .
		boolean found=FileManager.searchFile(folderpath,fileName);				
		if(found) 
		System.out.println("It is inside:"+ folderpath);
		else
		System.out.println("Something Went Wrong.");	

	}
	}


