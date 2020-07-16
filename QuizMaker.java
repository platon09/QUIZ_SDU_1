import java.util.Scanner;

public class QuizMaker{

    public static void main(String[] args) throws java.io.FileNotFoundException{
        String fileName = args[0];
        // String fileName = "JavaQuiz.txt";
        Quiz.start(fileName);
    }
}
