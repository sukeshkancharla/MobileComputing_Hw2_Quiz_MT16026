package com.example.user.quiz_mt16026;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 25-Aug-16.
 */
public class CheatActivity extends AppCompatActivity {
    public static final String answer_value="answer";
    private Button mShowAnswerButton;
    private TextView mShowAnswerText;
    private boolean buttonClicked;
    public int default_question=-1;
    private int question_value;
    private boolean answer;
    private static final String button_clicked="buttonClicked";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        if(savedInstanceState!=null)
        {
            question_value=savedInstanceState.getInt(MainActivity.question);
            buttonClicked=savedInstanceState.getBoolean(button_clicked);
            answer=savedInstanceState.getBoolean(answer_value);
            if(buttonClicked)
            {
                mShowAnswerText=(TextView)findViewById(R.id.answer_text);
                if(answer)
                {
                    mShowAnswerText.setText(question_value+" is a prime");
                }
                else
                {
                    mShowAnswerText.setText(question_value+" is not a prime");
                }
                Intent resultIntent=new Intent();
                resultIntent.putExtra(MainActivity.result_class,"cheat");
                setResult(Activity.RESULT_OK,resultIntent);
            }
        }
        else
        {
            buttonClicked=false;
            question_value=getIntent().getIntExtra(MainActivity.question,default_question);
        }
        int flag=0;
        for(int i=2;i<question_value/2;i++)
        {
            if(question_value%i==0)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
        {
            answer=false;
        }
        else
        {
            answer=true;
        }
        mShowAnswerButton=(Button)findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowAnswerText=(TextView)findViewById(R.id.answer_text);
                if(answer)
                {
                    mShowAnswerText.setText(question_value+" is a Prime");
                }
                else
                {
                    mShowAnswerText.setText(question_value+" is not a Prime");
                }
                buttonClicked=true;
                Intent resultIntent=new Intent();
                resultIntent.putExtra(MainActivity.result_class,"cheat");
                setResult(Activity.RESULT_OK,resultIntent);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(button_clicked,buttonClicked);
        savedInstanceState.putInt(MainActivity.question,question_value);
        savedInstanceState.putBoolean(answer_value,answer);
    }
}
