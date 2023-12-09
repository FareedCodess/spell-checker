package project_AVL;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = null;
        boolean next = true;
        while (next) {
            displayDashboard();
            try {
                int operationNumber = scanner.nextInt();

                switch (operationNumber) {
                    case 1 -> {
                        System.out.print("Enter filename: ");
                        String fileName = scanner.next().trim();
                        try {
                            System.out.println("Loading dictionary from file " + fileName + "...");
                            dictionary = new Dictionary(new File(fileName));
                        } catch (FileNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.println("Enter a word : ");
                        dictionary = new Dictionary(scanner.next().trim());
                        System.out.println("Dictionary initialized successfully");

                    }
                    case 3 -> {
                        dictionary = new Dictionary();
                        System.out.println("Empty dictionary created successfully");

                    }
                    case 4 -> {
                        if (dictionary == null) {
                            System.out.println("Dictionary not loaded/created");
                        } else {
                            try {
                                System.out.println("Enter word: ");
                                String word = scanner.next();
                                if (dictionary.findWord(word)) {
                                    System.out.println("FOUND: Word '" + word + "' was found.");
                                } else {
                                    throw new WordNotFoundException();
                                }
                            } catch (WordNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    case 5 -> {
                        if (dictionary == null) {
                            System.out.println("Dictionary not loaded/created");
                        } else {
                            System.out.println("Enter word: ");
                            String word = scanner.next();
                            try {
                                dictionary.addWord(word);
                                System.out.println("Word added successfully.");
                            } catch (WordAlreadyExistsException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    case 6 -> {
                        if (dictionary == null) {
                            System.out.println("Dictionary not loaded/created");
                        } else {
                            System.out.println("Enter word: ");
                            String word = scanner.next();
                            try {
                                dictionary.deleteWord(word);
                                System.out.println("Word deleted successfully.");
                            } catch (WordNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    case 7 -> {
                        if (dictionary == null) {
                            System.out.println("Dictionary not loaded/created");
                        } else {
                            System.out.print("Enter word: ");
                            String word = scanner.next();
                            String[] similarWords = dictionary.findSimilar(word);
                            if (similarWords.length == 1 && similarWords[0].isEmpty()) {
                                System.out.println("No similar words found.");
                            } else {
                                System.out.println("Similar words:");
                                for (String similarWord : similarWords) {
                                    System.out.println(similarWord);
                                }
                            }
                        }
                    }
                    case 8 -> {
                        if (dictionary == null) {
                            System.out.println("Dictionary not loaded/created");
                        } else {

                            System.out.print("Enter filename: ");
                            String saveFilename = scanner.next();
                            System.out.println("Saving dictionary...in progress");
                            try {
                                dictionary.saveDictionary(saveFilename);
                                System.out.println("Dictionary saved successfully.");
                            } catch (FileNotFoundException e) {
                                System.out.println("Error in saving file.");
                            }
                        }
                    }
                    case 9 -> next = false;
                    default -> System.out.println("Error : Invalid option");
                }
                System.out.println();
            }catch(InputMismatchException e){
                System.out.println("Error: Invalid option");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayDashboard() {
        System.out.println();
        System.out.println("The Dictionary supports the following operations : ");
        System.out.println("1. Load a dictionary from existing file");
        System.out.println("2. Initialize a dictionary from a word");
        System.out.println("3. Create an empty dictionary");
        System.out.println("4. Find a word in the dictionary");
        System.out.println("5. Add a word to the dictionary");
        System.out.println("6. Remove a word from the dictionary");
        System.out.println("7. Search for similar words");
        System.out.println("8. Save the updated dictionary as a text file");
        System.out.println("9. Exit");
        System.out.println(">> Enter the operation number: ");
    }

}
