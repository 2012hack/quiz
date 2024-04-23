package com.amiya.quiz;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView quizQuestion;
    EditText answerGiven;
    String quizAnswer;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        quizQuestion = findViewById(R.id.QuestionTextView);
        answerGiven = findViewById(R.id.editTextText);
        Submit = findViewById(R.id.answerButton);
        customDataType D[] = new customDataType[3];

        D[0] = new customDataType("Who told introduced to us about the gases, Oxyzen and Hydrogen",
                "antoine lavoiser");
        D[1] = new customDataType("Who is the first person to tell about matters made of small particles",
                "maharishi kannada");
        D[2] = new customDataType("Who told that molecules make up matter",
                "john dalton");
        D[3] = new customDataType("Who got world cup the most number of times in ODI world cup",
                "Australia");
        Random randomNo = new Random();
        int num = randomNo.nextInt(4);

        quizQuestion.setText(D[num].quizQuestion);
        quizAnswer = D[num].quizAnswer;

        Submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(answerGiven.getText().toString().toLowerCase().equals(quizAnswer)){
                    int num = randomNo.nextInt(4);
                    quizQuestion.setText(D[num].quizQuestion);
                    quizAnswer = D[num].quizAnswer;

                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    answerGiven.setText("");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}