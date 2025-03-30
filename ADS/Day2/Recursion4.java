class Recursion4
{
	static int fibonacci(int n)
	{
	if(n<=1)
	{
	  return n;
	}
	return fibonacci(n-1) + fibonacci(n-2);
}

public static void main(String args[])
{
  int number = 25;
  for(int i=1;i<=number;i++)
  {
	System.out.print(fibonacci(i)+ " ");
}
}
}