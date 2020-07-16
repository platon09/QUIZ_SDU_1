import javax.management.QueryEval;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Quiz {
    String name;
    ArrayList<Question> questions = new ArrayList<Question>();
    Quiz() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addQuestion(Question qstn) {
        questions.add(qstn);
    }
    static Quiz loadFromFile(String path) throws java.io.FileNotFoundException{
        try {
            if (!path.substring(path.length()-4,path.length()).equals(".txt")) throw new InvalidQuizFormatException("InvalidFormatNotTxt");
        }
        catch (InvalidQuizFormatException e) {
            e.printStackTrace();System.exit(1);
        }
        File file = new File(path);
        Quiz quiz = new Quiz();
        Scanner in = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            try {
                String string = in.nextLine();
                if (!in.hasNext()) {
                    list.add(string);
                }
                if (string.isEmpty() || !in.hasNext()) {
                    if (list.size() == 5){
                        Question test = new Test();
                        test.setDescription(list.get(0));
                        list.remove(0);
                        test.setAnswer(list.get(0));
                        Collections.shuffle(list);
                        String[] options = list.toArray(new String[4]);
                        ((Test) test).setOptions(options);
                        quiz.addQuestion(test);
                        list.clear();
                    }
                    else if (list.size() == 2){
                        Question fillIn = new FillIn();
                        fillIn.setDescription(list.get(0));
                        fillIn.setAnswer(list.get(1));
                        quiz.addQuestion(fillIn);
                        list.clear();
                    }
                    else throw new InvalidQuizFormatException("NoLineFound");
                }
                if (!in.hasNext()) {
                    break;
                }
                if (!string.isEmpty()) {
                    list.add(string);
                }
            }
            catch (Exception e) {e.printStackTrace();System.exit(1);break;}
        }
        quiz.setName(path);
        return quiz;
    }

    @Override
    public String toString() {
        Collections.shuffle(questions);
        for (Question k : this.questions) {
            System.out.println(k.toString());
        }
        double percent = ((Question.scores*1d)/(this.questions.size()*1d))*100d;
        return "Correct answers: "+Question.scores+"/"+this.questions.size()+" ("+percent+"%)";
    }
    public static void start(String fileName) throws java.io.FileNotFoundException{
        String path = fileName;
        Quiz quiz = loadFromFile(path);
        System.out.println(quiz.toString());
    }
}
