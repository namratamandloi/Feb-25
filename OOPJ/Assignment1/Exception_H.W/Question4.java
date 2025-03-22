public class Question4 {
    public static void main(String[] args) {
        String s = "Name123"; 

        try {
            int number = Integer.parseInt(s);
            System.out.println("Converted number: " + s);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert '" + s + "' to an integer.");
        }
    }
}