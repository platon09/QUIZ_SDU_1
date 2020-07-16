import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class Test extends Question {
    String[] options = new String[4];
    int numOfOptions;
    String[] labels = {"A","B","C","D"};

    Test() {};

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getOptionAt(int numOfOptions) {
        return options[numOfOptions];
    }

    @Override
    public String toString() {

        System.out.println(Question.numoftask+"."+this.getDescription());
        for (int i = 0; i < 4; i++) {
            System.out.println(labels[i]+") "+this.options[i]);
        }
        System.out.print("--------------------------\n"+
                "Enter the correct choice: ");
        java.util.Scanner input = new java.util.Scanner(System.in);
        while (true) {
            String chekans = input.nextLine();
            if (chekans.equals(labels[0]) || chekans.equals(labels[1]) || chekans.equals(labels[2]) || chekans.equals(labels[3])) {
                if (this.options[Arrays.asList(labels).indexOf(chekans)].equals(this.getAnswer())) {
                    System.out.println("Correct!");
                    scores++;
                    break;
                }
                else {
                    System.out.println("Incorrect!");
                    break;
                }
            }
            else {
                System.out.print("Invalid choice! Try again (Ex: A, B, ...): ");
                continue;
            }
        }
        Question.numoftask++;
        return "________________________________________________________";
    }
}
