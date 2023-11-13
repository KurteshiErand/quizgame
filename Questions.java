import java.util.ArrayList;
import java.util.Collections;

public class Questions {
    private String  question;
    private ArrayList<String> choices;
    private String answer;
    public Questions(String question, String[] choices, String answer) {
        this.question = question;
        this.choices = new ArrayList<String>();
        for (int i = 0; i < choices.length; i++){
            this.choices.add(choices[i]);
        }
        Collections.shuffle(this.choices);
        this.answer = answer;
        
    } 
    public String getQuestions() {
        return question;
    }
    public ArrayList<String> getchoices() {
        return choices;
    }
    public String getanswer() {
        return answer;
    }
}
