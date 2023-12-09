package project_AVL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class efficiencies {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("efficiency.txt"));
        writer.println("This file contains big-O complexities of the methods/constructors in dictionary data structure whose primary purpose is " +
                "to be used for a spell checker. ");
        writer.println("_".repeat(50));
        writer.println("Method Name    " + " ".repeat(15) + "Complexities");
        writer.println("_".repeat(50));
        writer.println("addWord        " + " ".repeat(15) + "O(log n)");
        writer.println("findWord       " + " ".repeat(15) + "O(log n)");
        writer.println("deleteWord       " + " ".repeat(15) + "O(log n)");
        writer.println("findSimilar    " + " ".repeat(15) + "O(n)");
        writer.println("saveDictionary " + " ".repeat(15) + "O(n)");
        writer.println("_".repeat(50));
        writer.println("Constructor argument" + " ".repeat(10) + "Complexities");
        writer.println("_".repeat(50));
        writer.println("null                " + " ".repeat(10) + "O(1)");
        writer.println("word                " + " ".repeat(10) + "O(1)");
        writer.println("file                " + " ".repeat(10) + "O(n)");
        writer.close();
    }
}
