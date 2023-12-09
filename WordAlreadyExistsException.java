package project_AVL;
public class WordAlreadyExistsException extends Exception{
    public WordAlreadyExistsException(){
        super("Exception : Word Already Exists");
    }
    public WordAlreadyExistsException(String message){
        super(message);
    }
}
