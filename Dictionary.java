package project_AVL;
import project_AVL.WordAlreadyExistsException;
import project_AVL.WordNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


// Dictionary Data Structure
// Description :
public class Dictionary extends AVLTree<String>{

    // Constructors
    // Creating an empty dictionary
    public Dictionary() {
        super();
    }
    // Creating a single string dictionary
    public Dictionary(String s)  {
        super(new BSTNode<>(s));
    }
    // Creating a dictionary from file
    public Dictionary(File f) throws FileNotFoundException {
        Scanner input = new Scanner(f);
        while(input.hasNext()){
            super.insertAVL(input.next());
        }
        System.out.println("Dictionary loaded successfully");
    }

    // Function : To add a new word to the dictionary.
    // if word already exists, WordAlreadyExistsException is raised
    // return : null
    public void addWord(String s) throws WordAlreadyExistsException {
        if (!findWord(s)) super.insertAVL(s);
        else throw new WordAlreadyExistsException();
    }

    // Function : To search for a word in the dictionary.
    // return : boolean
    public boolean findWord(String s){
        return super.isInTree(s);
    }

    // Function : To delete a word from the dictionary.
    // if word is not found, WordNotFoundException is raised
    // return : null
    public void deleteWord(String s) throws WordNotFoundException {
        if (super.isInTree(s)) super.deleteAVL(s);
        else throw new WordNotFoundException();
    }

    // Function : To find similar words in the dictionary.
    // return : An array of words which are similar (i.e. differ by only 1 letter) to the passed string from
    // the dictionary.
    public String[] findSimilar(String s){
        String similarWords = "";
        BSTNode<String> p = root;
        Queue<BSTNode<String>> queue = new Queue<BSTNode<String>>();
        if (p != null) {
            queue.enqueue(p);
            while (!queue.isEmpty()) {
                p = queue.dequeue();
                if (isOneLetterDifference(s,(String)p.el))
                    similarWords = similarWords + " " + p.el;

                if (p.left != null)
                    queue.enqueue(p.left);
                if (p.right != null)
                    queue.enqueue(p.right);
            }
        }
        return similarWords.trim().split(" ");

    }

    private boolean isOneLetterDifference(String s1, String s2) {
        int lenDiff = Math.abs(s1.length() - s2.length());
        if (lenDiff > 1) {
            return false;                           // More than one-letter difference in length
        }

        int differenceCount = 0;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                ++differenceCount;
                if (differenceCount > 1) {
                    return false;                   // More than one-letter difference
                }
                if (s1.length() > s2.length()) {
                    i++;
                } else if (s1.length() < s2.length()) {
                    j++;
                } else {
                    i++;j++;
                }
            } else {
                i++;j++;
            }
        }

        return differenceCount == 1 || (differenceCount == 0 && lenDiff == 1);
    }

    public void saveDictionary(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        PrintWriter output = new PrintWriter(file);
        inorderSave(root, output);
        output.close();

    }
    private void inorderSave(BSTNode<String> p, PrintWriter writer){
        if (p!= null) {
            inorderSave(p.left,writer);
            writer.println(p.el);
            inorderSave(p.right,writer);
        }
    }

}