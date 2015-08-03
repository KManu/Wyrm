import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("This is text.");
		File path = new File("C:\\Users\\Kobby\\Pictures\\");
		String lastModified = String.valueOf(path.lastModified());
		File [] fileNames = path.listFiles();
		
		for(File curFile : fileNames){
			if(curFile.isFile()){
				System.out.println(curFile.getName() +" is a file.");
			}else if(curFile.isDirectory()){
				System.out.println(curFile.getName()+" is a folder.");
			}
			else{
				System.out.println(curFile.getAbsolutePath() +" is not a file or a directory");
			}
			
		}*/
		System.out.println("~~~~~~~~~~~~~~~~~~WYRM~~~~~~~~~~~~~~~~~~");
		System.out.println("This is an alpha build.");
		//Feeler tent1 = new Feeler("C:\\Users\\Kobby\\Downloads\\");
		Feeler tent1 = new Feeler("D://");
		tent1.ListFilesByCategory();
		
	}

}
