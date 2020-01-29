import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
	
	
	public static void main(String[]args) {
		 try {
			 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	            Scanner input = new Scanner(new File("/data/agenda.txt"));
	            while (input.hasNextLine()) {
	                String line = input.nextLine();
	                System.out.println(line);
	            }
	            input.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
