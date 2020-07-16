import java.io.*;
import java.util.*;

public class InvalidQuizFormatException extends Exception{
    public InvalidQuizFormatException() {
        super();
    }
    public InvalidQuizFormatException(String msg) {
        super(msg);
    }
}
