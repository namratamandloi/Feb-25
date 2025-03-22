public class Question5{
    
    public static void setAge(int age) {
        if (age < 0 || age > 150) {
            
        }
        
        System.out.println("Age is set to: " + age);
    }

    public static void main(String[] args) {
        try {
            setAge(25); 
            setAge(200); 
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            setAge(-5);  
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}