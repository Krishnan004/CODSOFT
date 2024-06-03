package NumberGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Quiz_Application extends Frame {
    
    static int result = 0;
    static TextField question;
    static CheckboxGroup optionsGroup;
    static Checkbox a, b, c, d;
    static Button nextButton;
    static int currentQuestion = 0;
    
    public Quiz_Application() {
        question = new TextField();
        question.setEditable(false);
        
        optionsGroup = new CheckboxGroup();
        a = new Checkbox("", optionsGroup, false);
        b = new Checkbox("", optionsGroup, false);
        c = new Checkbox("", optionsGroup, false);
        d = new Checkbox("", optionsGroup, false);
        
        nextButton = new Button("Next");
        
        setLayout(new FlowLayout());
        
        add(question);
        add(a);
        add(b);
        add(c);
        add(d);
        add(nextButton);
        
        setSize(800, 800);
        setVisible(true);
        
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestion++;
                if (currentQuestion < questions.length) {
                    displayQuestion(currentQuestion);
                } else {
                    question.setText("Quiz Over! Your score: " + result);
                    a.setVisible(false);
                    b.setVisible(false);
                    c.setVisible(false);
                    d.setVisible(false);
                    nextButton.setVisible(false);
                }
            }
        });
        
        displayQuestion(currentQuestion);
    }
    
    String[][] questions = {
        {"Java was launched in which year?", "1991", "1994", "1995", "1996", "3"},
        {"What level language is Java?", "Machine Level", "Low Level", "High Level", "Scripting Level", "3"},
        {"Is Java Platform Independent?", "True", "False", "", "", "1"},
        {"Which of the following is not a valid access modifier in Java?", "Public", "Private", "Protected", "Package", "4"},
        {"What is the correct way to declare a main method in Java?", "public void main(String[] args)", "public static void main(String[] args)", "public void main()", "public static void main()", "2"}
    };
    
    void displayQuestion(int qIndex) {
        question.setText(questions[qIndex][0]);
        a.setLabel(questions[qIndex][1]);
        b.setLabel(questions[qIndex][2]);
        c.setLabel(questions[qIndex][3]);
        d.setLabel(questions[qIndex][4]);
        optionsGroup.setSelectedCheckbox(null);
    }
    
    void checkAnswer() {
        String correctAnswer = questions[currentQuestion][5];
        Checkbox selected = optionsGroup.getSelectedCheckbox();
        if (selected != null) {
            String selectedAnswer = selected.getLabel();
            if (questions[currentQuestion][Integer.parseInt(correctAnswer)].equals(selectedAnswer)) {
                result++;
            }
        }
    }
    
    public static void main(String[] args) {
        new Quiz_Application();
    }
}
