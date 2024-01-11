using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

namespace boj
{
    class Program
    {
        static void Main(string[] args)
        {
            var A = int.Parse(Console.ReadLine());
            Queue<int> queue = new();
            StringBuilder sw = new();

            for (int i = 0; i < A; i++)
            {
                string[] input = Console.ReadLine().Split(' ');


                if (input[0] == "push")
                {
                    queue.Enqueue(int.Parse(input[1]));
                }
                else if (input[0] == "pop")
                {
                    if (queue.Count == 0)
                    {
                        sw.AppendLine("-1");
                    }
                    else
                    {
                        sw.Append(queue.Dequeue() + "\n");
                    }
                }
                else if (input[0] == "size")
                {
                    sw.Append(queue.Count + "\n");
                }
                else if (input[0] == "empty")
                {
                    if (queue.Count == 0)
                    {
                        sw.AppendLine("1");
                    }
                    else
                    {
                        sw.AppendLine("0");
                    }
                }
                else if (input[0] == "front")
                {
                    if (queue.Count == 0)
                    {
                        sw.AppendLine("-1");
                    }
                    else
                    {
                        sw.Append(queue.Peek() + "\n");
                    }
                }
                else if (input[0] == "back")
                {
                    if (queue.Count == 0)
                    {
                        sw.AppendLine("-1");
                    }
                    else
                    {
                        sw.Append(queue.Last() + "\n");
                    }
                }
            }
            Console.WriteLine(sw.ToString());
        }
    }
}