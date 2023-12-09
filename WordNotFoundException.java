package project_AVL;

public class WordNotFoundException extends Exception {
    public WordNotFoundException(){
        super("Exception : Word Not Found");
    }
    public WordNotFoundException(String message){
        super(message);
    }
}
