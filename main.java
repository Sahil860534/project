import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int userChoice) {
        return userChoice == correctAnswerIndex;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {

    private List<Question> questions;
    int input;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public void startQuiz() {
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestionText());

            for (int i = 0; i < question.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + question.getOptions()[i]);
            }
            int userChoice = getValidInput(1, question.getOptions().length);

            if (question.isCorrectAnswer(userChoice - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " +
                        (question.getCorrectAnswerIndex() + 1));
            }
        }
        System.out.println("Your score is: " + score + "/" + questions.size());
    }

    private int getValidInput(int min, int max) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter your choice: ");
            try {
                input = scanner.nextInt();
                if (input < min || input > max) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between "
                        + min + " and " + max);
                scanner.nextLine();
            }
        } while (input < min || input > max);
        return input;
    }
}

class main {

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                new String[] { "London", "Paris", "Berlin", "Rome" }, 1));
        questions.add(new Question("What is the largest planet in our solar system?",
                new String[] { "Earth", "Jupiter", "Mars", "Venus" }, 1));
        questions.add(
                new Question("What is the chemical symbol for water?", new String[] { "H20", "CO2", "O2", "N2" }, 0));
        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }

}