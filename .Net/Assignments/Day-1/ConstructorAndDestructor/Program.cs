namespace ConstructorAndDestructor
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");

            //MyClass obj1 = new MyClass(10, "Hello", true); // Calls parameterised constructor
            //Console.WriteLine($"Prop1: {obj1.Prop1}, Prop2: {obj1.Prop2}, Prop3: {obj1.Prop3}");
            //MyClass obj2 = new MyClass(); // Calls Non Parameterised constructor
            //Console.WriteLine($"Prop1: {obj2.Prop1}, Prop2: {obj2.Prop2}, Prop3: {obj2.Prop3}");

            //MyClass obj3 = new MyClass(obj1); // Calls copy constructor
            //Console.WriteLine($"Prop1: {obj3.Prop1}, Prop2: {obj3.Prop2}, Prop3: {obj3.Prop3}");


            MyClass obj4 = new MyClass(); // Calls constructor with default parameters
            Console.WriteLine($"Prop1: {obj4.Prop1}, Prop2: {obj4.Prop2}, Prop3: {obj4.Prop3}");

        }
    }

    public class MyClass
    {
        // Constructor
        public int Prop1 { get; set; }

        public string Prop2 { get; set; }

        public bool Prop3 { get; set; }


        // Default constructor
        //public MyClass()
        //{
        //    Prop1 = 0;
        //    Prop2 = "Default";
        //    Prop3 = false;
        //    Console.WriteLine("Default constructor called");
        //}

        // Copy constructor
        //public MyClass(MyClass other)
        //{
        //    Prop1 = other.Prop1;
        //    Prop2 = other.Prop2;
        //    Prop3 = other.Prop3;
        //    Console.WriteLine("Copy constructor called");
        //}

        // Parameterised constructor
        //public MyClass(int prop1, string prop2)
        //{
        //    Prop1 = prop1;
        //    Prop2 = prop2;
        //    Prop3 = true; // Default value for Prop3
        //    Console.WriteLine("Parameterised constructor called");
        //}

        public MyClass(int prop1 = 1, string prop2 = "Nidhi", bool prop3 = false)
        {
            this.Prop1 = prop1;
            this.Prop2 = prop2;
            this.Prop3 = prop3;
            Console.WriteLine("Constructor with default parameters called");
        }
        // Destructor dont write the code for destructor in C# unless you have a specific reason to do so
        //~MyClass()
        //{
        //    Console.WriteLine("Destructor called");
        //}
    }
}