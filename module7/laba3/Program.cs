// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");

var mainStr = "";
var searchStr = "";
var N = 0;

int InStr(int n, string s1, string s2)
{
    var k = 0;
    for (int i = n; i < s1.Length; i++)
    {
        if (s1[i] == s2[k])
        {
            k++;
        }
        else
        {
            k = 0;
        }

        if (k == s2.Length)
        {
            return i - k + 1;
        }
    }
    return 0;
}

do
{
    try
    {

        Console.WriteLine("\nPlease input main string");

        mainStr = Console.ReadLine();

        Console.WriteLine("Pleas input search sub string");

        searchStr = Console.ReadLine();

        Console.WriteLine("Input number N");

        N = int.Parse(Console.ReadLine());

        Console.WriteLine($"InStr({N}, {mainStr}, {searchStr}) = {InStr(N, mainStr, searchStr)}");

        Console.WriteLine($"Type Q for exit, any for repeat...");
        var key = Console.ReadKey();
        if (key.Key != ConsoleKey.Q)
        {
            continue;
        }
        break;
    }
    catch (Exception ex)
    {
        Console.WriteLine(ex.Message);
    }

} while (true);