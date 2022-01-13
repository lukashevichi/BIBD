// See https://aka.ms/new-console-template for more information


using System.Diagnostics;
var cdir = Directory.GetCurrentDirectory();
Console.WriteLine($"Hello, World!");
Console.WriteLine($"Current dir path\n{cdir}");
ProcessDirectory(cdir);

while (true)
{

    Console.WriteLine("Input file name, exit for quit");
    var fname = Console.ReadLine();

    if (File.Exists(fname))
    {
        try
        {
            Process.Start(@"cmd.exe ", @$"/c {fname}");
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
        }
    }
    else
    {
        if (fname == "exit")
        {
            break;
        }
        else
            Console.WriteLine($"File {fname} not exists");
    }
}



// Process all files in the directory passed in, recurse on any directories
// that are found, and process the files they contain.
void ProcessDirectory(string targetDirectory)
{
    Console.WriteLine("Files in path:");
    // Process the list of files found in the directory.
    string[] fileEntries = Directory.GetFiles(targetDirectory);
    foreach (string fileName in fileEntries)
        ProcessFile(fileName);
}

// Insert logic for processing found files here.
void ProcessFile(string path)
{
    Console.WriteLine(path);
}