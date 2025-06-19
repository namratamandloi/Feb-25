using System;

internal class Program
{
    static void Main()
    {
        Console.Write("Enter number of CDAC batches: ");
        int batchCount = int.Parse(Console.ReadLine());

      
        int[][] studentMarks = new int[batchCount][];

        for (int i = 0; i < batchCount; i++)
        {
            Console.Write($"Enter number of students in Batch {i + 1}: ");
            int studentCount = int.Parse(Console.ReadLine());

            studentMarks[i] = new int[studentCount];

            for (int j = 0; j < studentCount; j++)
            {
                Console.Write($"Enter mark for Student {j + 1} in Batch {i + 1}: ");
                studentMarks[i][j] = int.Parse(Console.ReadLine());
            }
        }

        Console.WriteLine("\n=== Displaying Student Marks ===");
        for (int i = 0; i < studentMarks.Length; i++)
        {
            Console.WriteLine($"Batch {i + 1}:");

            for (int j = 0; j < studentMarks[i].Length; j++)
            {
                Console.WriteLine($"  Student {j + 1}: {studentMarks[i][j]}");
            }
        }

        Console.WriteLine("\nAll student marks displayed.");
    }
}
