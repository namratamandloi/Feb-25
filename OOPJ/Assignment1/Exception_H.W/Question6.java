import java.io.FileReader;
import java.io.IOException;

public class Question6 {
    public static void main(String[] args) {
        String fileName = "file1.txt"; 
        
        try {
            FileReader f = new FileReader(fileName);
            System.out.println("File read successfully");
        } catch (IOException e) {
         
            System.out.println("File not found or could not be read");
            System.out.println("Details: " + e.getMessage());
        }
    }
}