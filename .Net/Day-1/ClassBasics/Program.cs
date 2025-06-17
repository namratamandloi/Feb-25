namespace classBasics
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            class1 obj; //obj is a reference type variable of class1
            obj = new class1(); //obj is initialized with a new instance of class1
            obj.Display(); // Calling the Display method of class1 instance

            obj.Display("Hello"); // Calling the overloaded Display method with a string parameter  

            class1 obj2 = new class1(); // Another instance of class1
            //positional parameters
            Console.WriteLine(obj2.Add(10, 20, 30, 40));

            //named parameters
            Console.WriteLine(obj2.Add(d: 40, c: 30, b: 20, a: 10)); // Using named parameters to specify the order

            Console.WriteLine(obj2.Add(10, c: 30));

            //Console.WriteLine(obj2.Add(10, a: 30)); this will not compile because 'a' is not the first parameter

            obj.DoSomething1(); // Calling the DoSomething method of class1 instance
        }
    }

    public class class1
    {
        public void Display()
        {
            System.Console.WriteLine("Hello from class1!");
        }
        //overloaded method
        public void Display(String s)
        {
            System.Console.WriteLine("Hello from class1 with parameter: " + s);
        }

        //ads method with four parameters

        //default values for parameters are given from right to left
        public int Add(int a = 0, int b = 0, int c = 0, int d = 0)
        {
            return a + b + c + d; // Returns the sum of the parameters
        }


        public void DoSomething1()
        {
            int i = 100; //local variable is a variable declared in a function
                         //local variables are unassigned

            DoSomething2();
            Console.WriteLine(i);

            //local function - func defined within another func
            //only available from the outer function
            //implicitly private


            //void DoSomething2( String s)  //error - cannot overload local function with different parameters
            //{
            //local func can access local variables declared in the outer function
            //  Console.WriteLine(++i);
            // }


            static void DoSomething2() //local function
            {
                //statuc local func CANOOT access local varialbles declared in the outer function
                //Console.WriteLine(++i); //error - cannot access local variable from outer function

            }
        }

    }
}