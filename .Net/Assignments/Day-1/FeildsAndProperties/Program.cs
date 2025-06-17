namespace FeildsAndProperties
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            Class1 obj = new Class1();

            obj.Prop1 = 10; // Using property to set value\
            Console.WriteLine($"Value of prop1: {obj.Prop1}");  // Using property to get value

            obj.Prop2 = "Hello, World!"; // Using property to set value
            Console.WriteLine($"Value of prop2: {obj.Prop2}");  // Using property to get value
            //obj.i = 10;
            //Console.WriteLine($"Value of i: {obj.i}");


            //obj.SetI(50);
            //Console.WriteLine($"Value of i: {obj.GetI()}");
        }
    }

    public class Class1
    {
        //    private int i;  // field - class `

        //    public void SetI(int value)
        //    {
        //        if (value < 100)
        //        {
        //            i = value;
        //        }
        //        else
        //        {
        //            Console.WriteLine("Value must be less than 100.");
        //        }
        //    }
        //    public int GetI()
        //    {
        //        return i;
        //    }
        //}

        private int prop1;

        public int Prop1
        {
            set
            {
                if (value < 100)  // value will depend on property name, here Prop1 int so value is alo int
                {
                    prop1 = value;
                }
                else
                {
                    Console.WriteLine("Value must be less than 100.");
                }
            }
            get
            {
                return prop1;
            }

        }


        private String prop2; // field - class `
        public String Prop2
        {
            set
            {
                if (value.Length < 100)  // value will depend on property name, here Prop2 is string so value is a string
                {
                    prop2 = value;
                }
                else
                {
                    Console.WriteLine("Value must be less than 100 characters.");
                }
            }
            get
            {
                return prop2;
            }
        }

        // to create a property of differnt data type, we just change the type of the field and property

        public string prop4; // field - class `
        //automatically implemented property
        //when there is no logic in the property, we can use auto-implemented properties

        public string Prop3 { get; set; } // auto-implemented property, no need to define a backing field

    }
}