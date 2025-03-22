import java.io.FileReader;
import java.io.FileNotFoundException;

public class Question7 {
    public static void main(String[] args) {
        String fileName = "file1.txt"; 
        
        try {
            FileReader fileReader = new FileReader(fileName);
            System.out.println("File opened successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Exception: File not found.");
            System.out.println("Details: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}