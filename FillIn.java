public class FillIn extends Question {
    @Override
    public String toString() {
        System.out.println(Question.numoftask+"."+this.getDescription().replace("{blank}","______")
                +"\n--------------------------");
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Type your answer: ");
        String chekans = input.nextLine();
        if (chekans.toLowerCase().equals(this.getAnswer().toLowerCase())) {
            System.out.println("Correct!");
            Question.scores++;
        }
        else {
            System.out.println("Incorrect!");
        }
        Question.numoftask++;
        return "________________________________________________________";
    }
}
