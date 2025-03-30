class Recursion7 { 
    static void mul_table(int n, int i) 
    {  
        if (i > 10) 
            return ;  
        System.out.println(n + " * " + i + " = " + n * i); 
        mul_table(n, i + 1); 
    } 
      
    public static void main (String[] args) 
    {  
        int n = 8;  
        mul_table(n, 1); 
    } 
}