class CharStringASCII {
    public static void main(String[] args) {
        char ch = 'A';
        String str = "Hello";
        System.out.println("Character: " + ch + ", ASCII: " + (int)ch);
        for (char c : str.toCharArray()) {
            System.out.println("Character: " + c + ", ASCII: " + (int)c);
        }
    }
}
