/**
 * 
 * @author Kobby
 * This class is a wyrm feeler, primarily responsible for crawling folders and
 * returning lists of files and folders in the given directory.
 * The returned arrays of strings can be for a specific file type, or general.
 * There might also be additional file analysis functions
 *
 */

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class Feeler {
	private ArrayList <File> files = new ArrayList<File>();
	private ArrayList <File> folders = new ArrayList<File>();
	private ArrayList <File> searchResults = new ArrayList<File>();
	private int numberOfFiles=0;
	private int numberOfFolders=0;
	private File activeFile;
	private File activeFolder;
	private ArrayList<String> pictureFiles = new ArrayList<String>();
	private ArrayList<String> audioFiles = new ArrayList<String>();
	private ArrayList<String> videoFiles = new ArrayList<String>();
	private ArrayList<String> documentFiles = new ArrayList<String>();
	private ArrayList<String> otherFiles = new ArrayList<String>();
	private ArrayList<String> executableFiles = new ArrayList<String>();
	
	public Feeler(String path){
		System.out.println("Starting out a feeler...");
		File given = new File(path);
		
		if(given.isFile()){
			// call function to handle file operations
			analyseFile(given);
			activeFile= given;
		}else if(given.isDirectory()){
			//call function to crawl folder
			activeFolder = given;
			crawlFolder(given);
		}else{
			System.out.println("Error, cannot process given file path. Please enter a valid file path");
			return;
		}
		
		
	}
	
	private void crawlFolder(File folder){
		for(File cur : folder.listFiles()){
			if(cur.isFile()){
				files.add(cur);
				numberOfFiles++;
			}else if (cur.isDirectory()){
				folders.add(cur);
				numberOfFolders++;
			}
		}
		System.out.println("Feeling out "+folder.getAbsolutePath());
		System.out.println(numberOfFiles+numberOfFolders+" items in total the folder");
		System.out.println(numberOfFiles+" files in folder.");
		System.out.println(numberOfFolders+" folder in folder.");
		//Scan through and pick the filenames of pictures
		//TODO create an interface or a class to hold the arrays of filename extensions
		//
		String[] pictureFileExtensions = {".jpg",".png",".gif"};
		String[] audioFileExtensions={".mp3",".ogg",".aac",".flac","wma"};
		String[] videoFileExtensions={".mp4",".flv",".avi",".webm",".mkv"};
		String[] documentFileExtensions={".txt",".pdf",".nfo",".mobi",".epub",".tex",".doc",".docx"};
		String[] executableFileExtensions={".exe",".msi",".jar",".iso"};
		
		pictureFiles= new ArrayList<String>(Arrays.asList(folder.list(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		    	for(String filterVal : pictureFileExtensions){
		    		if( name.toLowerCase().endsWith(filterVal)){
		    			return true;
		    		}else{
		    			continue;
		    		}
		    	}
		        return false;
		    }
		})));
		audioFiles= new ArrayList<String>(Arrays.asList(folder.list(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		    	for(String filterVal : audioFileExtensions){
		    		if( name.toLowerCase().endsWith(filterVal)){
		    			return true;
		    		}else{
		    			continue;
		    		}
		    	}
		        return false;
		    }
		})));
		videoFiles= new ArrayList<String>(Arrays.asList(folder.list(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		    	for(String filterVal : videoFileExtensions){
		    		if( name.toLowerCase().endsWith(filterVal)){
		    			return true;
		    		}else{
		    			continue;
		    		}
		    	}
		        return false;
		    }
		})));
		documentFiles= new ArrayList<String>(Arrays.asList(folder.list(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		    	for(String filterVal : documentFileExtensions){
		    		if( name.toLowerCase().endsWith(filterVal)){
		    			return true;
		    		}else{
		    			continue;
		    		}
		    	}
		        return false;
		    }
		})));
		executableFiles= new ArrayList<String>(Arrays.asList(folder.list(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		    	for(String filterVal : executableFileExtensions){
		    		if( name.toLowerCase().endsWith(filterVal)){
		    			return true;
		    		}else{
		    			continue;
		    		}
		    	}
		        return false;
		    }
		})));
		files.trimToSize();
		folders.trimToSize();
	}

	
	private String analyseFile(File file){
		//Basically build a small report on the file
		String desc= "Wyrm File Analysis Started on: "+file.getName()+"\n";
		
		try {
			desc = "Absolute File Path: "+file.getCanonicalPath() +"\n"; //TODO replace /n with system independent newline character
			desc = "File last modified: "+file.lastModified()+"\n";
		} catch (IOException e) {
			// Catch if file io errors
			e.printStackTrace();
			System.out.println("Error while reading the file "+file.getName());
		}
		return desc;
	}
	
	public void ListFilesandFolders(){
		System.out.println("Files: ");
		int counter =1;
		for(File file : files){
			System.out.println(counter++ +". "+ file.getName());
		}
		System.out.println("Folders: ");
		counter =1;
		for(File folder:folders){
			System.out.println(counter++ +". "+ folder.getName());
		}
	}
	
	public void ListFilesByCategory(){
		//List Pictures, Music, Video, Programs, Documents, Others
		System.out.println("Pictures:");
		int counter=1;
		for(String name : pictureFiles){
			System.out.println(counter++ +". "+name);
		}
		
		System.out.println("Audio:");
		counter=0;
		for(String name : audioFiles){
			System.out.println(counter++ +". "+name);
		}
		
		System.out.println("Video:");
		counter=0;
		for(String name : videoFiles){
			System.out.println(counter++ +". "+name);
		}
		
		System.out.println("Documents:");
		counter=0;
		for(String name : documentFiles){
			System.out.println(counter++ +". "+name);
		}
		
		System.out.println("Executables:");
		counter=0;
		for(String name : executableFiles){
			System.out.println(counter++ +". "+name);
		}
		
	}
	
	
}
