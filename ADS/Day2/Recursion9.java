import java.util.*;
 
class Recursion9	{
static float sumOfSeries(int i, int n, float s) 
{
    if (i > n)
        return s;
    else
    {
        if (i % 2 == 0) 
            s -= 1 / i;
        else
            s += 1 / i;
             
        return sumOfSeries(i + 1, n, s);
    }
}

public static void main(String[] args)
{
    float sum = sumOfSeries(1, 3, 0);
     
    System.out.printf("%f", sum);
}
}
 