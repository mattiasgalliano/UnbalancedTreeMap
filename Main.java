/*
Mattias Galliano 3347016
COP-3530 Data Structures
Programming Assignment 3:
Balanced/Unbalanced Trees

Main.java

Description:
This analyzer compares the efficiency of two data structures in a task of
calculating the frequency of words appearing in choice text excerpts.
A custom unbalanced tree map is compared against a native java tree map.
Specifically, the analyzer opens multiple text files and records the time
it takes for each class to store the frequency of each word for each file
in the implemented data structure. File input is substracted from the
efficiency comarison measured in nanoseconds.

Input:
.okpuncs files containing text are read using a native java Scanner. 

Process:
Two analyzers are run, the first analyzing the efficiency of the
unbalanced tree map, the second the efficinecy of the native java tree map.

Output:
The time in nanoseconds representing the amount of time it takes for each
class object, respresenting two tree map implementations, to tally the frequency
of each word in a given text file is printed to the console, for 77 files.

Dependencies:
UnbalancedTreeMap.java BinaryNode.java OrderedKeyValue.java

Instructions:
javac Main.java UnbalancedTreeMap.java BinaryNode.java OrderedKeyValue.java
java Main
*/

import java.util.Scanner; // for reading file input
import java.io.File; // for file input
import java.io.FileNotFoundException; // for file input to catch exception
import java.util.TreeMap; // native java tree map for comparison

// explain / ask cast in okv class
// explain / ask return 0 hack for nativa java tree
// clean / doc/ opt
// in readme explain difference between unbalanced tree imp and native java tree imp (red black?) re performance

public class Main {
    
    public static void main(String args[])
    {
        try {
            myTreeAnalyzer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        

        try {
            javaTreeAnalyzer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Analyzes the efficiency of custom implemented unbalanced tree map in counting words in file
     * @throws FileNotFoundException
     */
    public static void myTreeAnalyzer() throws FileNotFoundException
    {
        UnbalancedTreeMap myTree = new UnbalancedTreeMap();

        long startTime = System.nanoTime();
        long totalTime = 0;
        
        for (int i = 1; i <= 77; ++i)
        {
            Scanner sc = new Scanner(new File("C:/Users/Mattias/Documents/personal/coding/javacode/PA3/" + i + ".okpuncs")).useDelimiter("[ ,!?.;\"-:]+"); // filter punctuation characters from text
            while (sc.hasNext())
            {
                startTime = System.nanoTime();
                String word = sc.next();
                if (myTree.get(word) == 0) // amended provided code for equality as native java tree map's get method returns null not 0
                {
                    myTree.put(word, 1+0);
                }
                else
                {
                    myTree.put(word, 1+myTree.get(word));
                }
                totalTime += (System.nanoTime()-startTime);
            }
            System.out.println(i + "," + totalTime);
        }
    }

    /**
     * Analyzes the efficiency of native java tree map in counting words in file
     * @throws FileNotFoundException
     */
    public static void javaTreeAnalyzer() throws FileNotFoundException
    {
        TreeMap<String, Integer> javaTree = new TreeMap<String, Integer>();

        long startTime = System.nanoTime();
        long totalTime = 0;
        
        for (int i = 1; i <= 77; ++i)
        {
            Scanner sc = new Scanner(new File("C:/Users/Mattias/Documents/personal/coding/javacode/PA3/" + i + ".okpuncs")).useDelimiter("[ ,!?.;\"-:]+"); // filter punctuation characters from text
            while (sc.hasNext())
            {
                startTime = System.nanoTime();
                String word = sc.next();
                if (javaTree.get(word) == null) // amended provided code as native java tree map's get method returns null not 0
                {
                    javaTree.put(word, 1+0);
                }
                else
                {
                    javaTree.put(word, 1+javaTree.get(word));
                } 
                totalTime += (System.nanoTime()-startTime);
            }
            System.out.println(i + "," + totalTime);
        }
    }    
}