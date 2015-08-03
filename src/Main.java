import java.io.File;

public class Main {

	public static void main(String[] args) {
		/*
		 * TODO
		 * Accept a folder path in the cli and use that to run.
		 * Add menu functionality
		 * Add file IO functionality. For reading settings and outputting results.
		 * Calculate file size
		 * Implement deep folder searching.
		 * Look into GUI work
		 */
		
		System.out.println("~~~~~~~~~~~~~~~~~~WYRM~~~~~~~~~~~~~~~~~~");
		System.out.println("This is an alpha build.");
		//Feeler tent1 = new Feeler("C:\\Users\\Kobby\\Downloads\\");
		Feeler tent1 = new Feeler("D://");
		tent1.ListFilesByCategory();
		
	}

}
