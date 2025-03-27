//Recursive infinite loop
class Recursion1
{
	static int i=0;
	static void show(){
			i++;
			if(i<=5)
			{
				System.out.println("HI Girls!!!");
				show();
			}
		}
	public static void main(String args[]){
				show();
			}
		}