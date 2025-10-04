import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer; // store index (1-based)

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create list of questions
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"1. Earth", "2. Mars", "3. Venus", "4. Jupiter"}, 2));
        quiz.add(new Question("Who wrote the play 'Romeo and Juliet'?",
                new String[]{"1. Charles Dickens", "2. William Shakespeare", "3. Mark Twain", "4. George Orwell"}, 2));
        quiz.add(new Question("Which is the smallest prime number?",
                new String[]{"1. 0", "2. 1", "3. 2", "4. 3"}, 3));
        quiz.add(new Question("What is the national currency of Japan?",
                new String[]{"1. Yen", "2. Won", "3. Dollar", "4. Peso"}, 1));
        quiz.add(new Question("In Java, which keyword is used to inherit a class?",
                new String[]{"1. implement", "2. extends", "3. inherits", "4. super"}, 2));

        int score = 0;

        System.out.println("===== Welcome to the Quiz App =====\n");

        // Loop through questions
        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("Q" + (i + 1) + ". " + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.print("Your answer (1-4): ");
            int answer = sc.nextInt();

            if (q.checkAnswer(answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer was option " + q.correctAnswer + ".\n");
            }
        }

        // Show final result
        System.out.println("===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + quiz.size());

        sc.close();
    }
}
