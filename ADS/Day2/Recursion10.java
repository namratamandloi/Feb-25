class Recursion10 {
    static String gcdFormula(int n) {
        if (n == 2) {
            return "gcd(int, int)";
        }
        return "gcd(int, " + gcdFormula(n - 1) + ")";
    }

    public static void main(String[] args) {
		int n = 3; 
        System.out.println(gcdFormula(n));
    }
}