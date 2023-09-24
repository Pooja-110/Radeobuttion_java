package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("MissingInflatedId")
public class MainActivity2 extends AppCompatActivity  {
    public static String[] questions = {
            "1. What is the orange part of an egg called?",
            "2. How many legs do insects have?",
            "3. What is a baby kangaroo called?",
            "4. What is the closest planet to the Sun?",
            "5. In which country can you find the Eiffel Tower",
            "6. How many days are there in a year?",
            "7. How many players are in a soccer team?",
            "8. Where do polar bears live?",
            "9. Which is faster, light or sound?",
            "10. How many letters are in the English alphabet?",
            "11. What is the name of a shape with 5 sides?",
            "12. How many Continents are there?",
            "13. What is the name of the tallest mountain on earth?",
            "14. The planet Mars is also known as what? The ( ) planet.",
            "15. How many months have 31 days?",
            "16. How many colors of the rainbow are there?",
            "17. My mother’s mother is my…what?",
            "18. Which animal lays the largest eggs?",
            "19. How many zeros are in ten thousand?",
            "20.In which country would you find the Sydney Opera House?"
    };
    public static String[][] choices = {
            {"Yolk", "Gel", "York", "Woke"},
            {"Six", "Eight", "Ten", "Two"},
            {"A Cub", "A pup", "A Joey", "A Kitten"},
            {"Mercury", "Earth", "Venus", "Mars"},
            {"USA", "France", "Spain", "Italy"},
            {"356", "536", "365", "337"},
            {"Eleven", "Fifteen", "Seven", "Eight"},
            {"The South Pole", "The Arctic", "Australia", "India"},
            {"Light", "Sound", "Aeroplane", "Fan"},
            {"24", "25", "26", "27"},
            {"Octagon", "Pentagon", "Dodecahedron", "Cube"},
            {"Seven", "Five", "Six", "Nine"},
            {"Fuji", "Kilimanjaro", "Mount Everest", "Himalaya"},
            {"The Red Planet", "The Windy Planet", "The cold Planet", "The Large Planet"},
            {"Four", "One", "Seven", "Five"},
            {"Seven", "Five", "Six", "Three"},
            {"Sister", "Aunt", "Grandmother", "Grandfather"},
            {"Chicken", "Ostrich", "Turkey", "China"},
            {"Three", "Four", "Five", "two"},
            {"Australia", "Canada", "USA", "India"}

    };

    public static String[] answer = {
            "Yolk",
            "Six",
            "A Joey",
            "Mercury",
            "France",
            "365",
            "Eleven",
            "The Arctic",
            "Light",
            "26",
            "Pentagon",
            "Seven",
            "Mount Everest",
            "The Red Planet",
            "Seven",
            "Seven",
            "Grandmother",
            "Ostrich",
            "Four",
            "Australia"

    };

    TextView t,w, s;
    TextView que;
    RadioButton a, b, c, d;
    RadioGroup rg;
    Button sub;
    int score = 0;
    int id=-1;
    int wcount=0;

    String       sAnswer;
    int totalQuestion = questions.length;
    int currentQuestion = 0;
    int current = 1;
    RadioButton selectedAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        que = findViewById(R.id.text_view_question);
        rg=findViewById(R.id.radio_group);
        a=findViewById(R.id.a);
        b=findViewById(R.id.b);
        c=findViewById(R.id.c);
        d=findViewById(R.id.d);
        s=findViewById(R.id.score);
        w=findViewById(R.id.wrong);
        sub = findViewById(R.id.button_confirm_next);
        t=findViewById(R.id.text_view_sco);
        t.setText("Total Question :" +currentQuestion+"/"+ totalQuestion);
        loadNewQuestion();
        sub.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Button clickedButton = (Button) view;
                id = rg.getCheckedRadioButtonId();

                if (currentQuestion < questions.length) {

                    if (id < 0) {
                        Toast.makeText(MainActivity2.this, "select one option", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        selectedAnswer = findViewById(id);
                        sAnswer = selectedAnswer.getText().toString();
                        if(sAnswer.equals(answer[currentQuestion]))
                        {
                            score++;
                            s.setText("Score: " + score);
                            rg.clearCheck();
                            currentQuestion++;
                        }
                        else
                        {
                            wcount++;
                            currentQuestion++;
                            rg.clearCheck();
                            w.setText("Wrong: " + wcount);
                        }
                        if (currentQuestion<totalQuestion)
                        {
                            loadNewQuestion();
                        }
                        else{

                        Toast.makeText(MainActivity2.this, " NO Question are available", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
                else {

                    Toast.makeText(MainActivity2.this, " NO Question are available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void loadNewQuestion() {
        que.setText(questions[currentQuestion]);
        a.setText(choices[currentQuestion][0]);
        b.setText(choices[currentQuestion][1]);
        c.setText(choices[currentQuestion][2]);
        d.setText(choices[currentQuestion][3]);
        t.setText("Total Question :" +current+"/"+ totalQuestion);
        current += 1;

    }
}

