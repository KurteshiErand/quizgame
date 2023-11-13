import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList <Questions> questionSet; 
    public Game() {
        questionSet = new ArrayList <Questions>();
        String questionText  = "Cili eshte kryeqyteti i Irlandes?";
        String[] answerOptions  = {"DUBLIN" , "SOFIA" , "AMSTERDAM" , "TIRANA"};
        questionSet.add(new Questions(questionText , answerOptions , "DUBLIN"));

        questionText  = "Nga e ka origjinen Sushi?";
        answerOptions  = new String[] {"Kina" , "Japoni" , "France" , "Itali"};
        questionSet.add(new Questions(questionText , answerOptions , "Kina"));

        questionText  = "Cili eshte kryeqyteti i Japonis?";
        answerOptions  =  new String[] {"Tokio" , "Viena" , "Parisi" , "Zagrebi"};
        questionSet.add(new Questions(questionText , answerOptions , "Tokio"));

        Collections.shuffle(questionSet, new Random());
    }
    public void start() {
        Scanner scanner  = new Scanner (System.in);
        int numCorrect = 0;

        for (int question = 0; question < questionSet.size(); question++) {
            System.out.println(questionSet.get(question).getQuestions());
            int numChoices = questionSet.get(question).getchoices().size();

            for(int choice = 0; choice < numChoices; choice++) {
                System.out.println((choice + 1)+ "; " +
                questionSet.get(question).getchoices().get(choice));
            }

            int playerAnswer = scanner.nextInt();
            while (true) {
                try {
                    System.out.print("Shkruani zgjedhjen tuaj (1-" + numChoices + "): ");
                    playerAnswer = scanner.nextInt();
                    if (playerAnswer >= 1 && playerAnswer <= numChoices) {
                        break;
                    } else {
                        System.out.println("Zgjedhje e pavlefshme. Ju lutem shkruani nje numer midis 1 dhe " + numChoices);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input i pavlefshëm. Ju lutem shkruani një numer.");
                    scanner.next();
                }
            }
            
            ArrayList<String>choiceSet = 
            questionSet.get(question).getchoices();
            String correctAnswer = questionSet.get(question).getanswer();
            int correctAnswerIndex = choiceSet.indexOf(correctAnswer);
            if(playerAnswer == correctAnswerIndex + 1 ) {
                numCorrect ++;
            }
            System.out.println("Ju keni marre " + numCorrect + "pergjigje te sakta");

        }
    }

    
}
