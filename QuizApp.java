import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswer; // index of correct option (1-based)

    // Constructor
    public Question(String questionText, List<String> options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Display question
    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    // Check answer
    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List of questions
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Which language is used for Android development?",
                Arrays.asList("Python", "Java", "C#", "Swift"),
                2 // Java
        ));

        questions.add(new Question(
                "Which company developed Java?",
                Arrays.asList("Microsoft", "Apple", "Sun Microsystems", "Google"),
                3 // Sun Microsystems
        ));

        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                Arrays.asList("extends", "implements", "inherit", "super"),
                1 // extends
        ));

        int score = 0;

        System.out.println("===== Welcome to the Online Quiz App =====");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ":");
            q.displayQuestion();

            System.out.print("Your answer (1-4): ");
            int answer = sc.nextInt();

            if (q.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        sc.close();
    }
}
