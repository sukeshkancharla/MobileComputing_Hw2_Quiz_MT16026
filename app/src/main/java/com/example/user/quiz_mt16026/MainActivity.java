package com.example.user.quiz_mt16026;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String question_value="value";
    public static final int REQUEST_CODE=1;
    public static final String correct_questions="Corrects";
    public static final String questions_attempted="questions";
    public static final String question_attempted="isAttempted";
    public static final String is_correct="isCorrect";
    public static final String question="question";
    public static final String result_class="resultClass";
    private boolean attempt=false;
    private boolean isCorrect=false;
    private Button mNextButton;
    private Button mHintButton;
    private Button mCheatButton;
    private Button mCorrectButton;
    private Button mIncorrectButton;
    private TextView mNumberText;
    private TextView mQuestionText;
    private TextView mCorrectsText;
    private static int correct_Answers=0;
    private static int questions=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCorrectsText = (TextView)findViewById(R.id.Quiz_Correct_Text);
        mNumberText =  (TextView)findViewById(R.id.Quiz_Number_Text);
        int num;
        findViewById(R.id.Quiz_Correct_Button).setEnabled(true);
        findViewById(R.id.Quiz_Incorrect_Button).setEnabled(true);
        mCheatButton=(Button)findViewById(R.id.cheat_button);
        mCheatButton.setEnabled(true);
        mHintButton=(Button)findViewById(R.id.hint_button);
        mHintButton.setEnabled(true);
        if(savedInstanceState==null)
        {
            Random r=new Random();
            num=r.nextInt(1000);
            mNumberText.setText(String.valueOf(num));
            mNumberText.setTextColor(Color.parseColor("#000000"));
        }
        else
        {
            attempt=true;
            correct_Answers=savedInstanceState.getInt(correct_questions);
            questions=savedInstanceState.getInt(question_attempted);
            num=savedInstanceState.getInt(question_value);
            mNumberText.setText(String.valueOf(num));
            correct_Answers=savedInstanceState.getInt(correct_questions);
            questions=savedInstanceState.getInt(questions_attempted);
            mNumberText.setTextColor(Color.parseColor("#000000"));
            if(savedInstanceState.getBoolean(question_attempted))
            {
                isCorrect=true;
                mCorrectButton=(Button)findViewById(R.id.Quiz_Correct_Button);
                mCorrectButton.setEnabled(false);
                mIncorrectButton=(Button)findViewById(R.id.Quiz_Incorrect_Button);
                mIncorrectButton.setEnabled(false);
                if(savedInstanceState.getBoolean(is_correct))
                {
                    mQuestionText=(TextView)findViewById(R.id.Quiz_Question_Text);
                    mQuestionText.setTextColor(Color.parseColor("#00FF00"));
                    mNumberText.setTextColor(Color.parseColor("#00FF00"));
                }
                else
                {
                    mQuestionText=(TextView)findViewById(R.id.Quiz_Question_Text);
                    mQuestionText.setTextColor(Color.parseColor("#FF0000"));
                    mNumberText.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        }
        mCorrectsText.setText(correct_Answers+" are correct out of "+questions+" questions attempted");
        mNextButton = (Button)findViewById(R.id.Quiz_Next_Button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r=new Random();
                isCorrect=false;
                mNumberText =  (TextView)findViewById(R.id.Quiz_Number_Text);
                int num=r.nextInt(1000);
                mNumberText.setText(String.valueOf(num));
                mCorrectButton=(Button)findViewById(R.id.Quiz_Correct_Button);
                mCorrectButton.setEnabled(true);
                mIncorrectButton=(Button)findViewById(R.id.Quiz_Incorrect_Button);
                mIncorrectButton.setEnabled(true);
                mCheatButton=(Button)findViewById(R.id.cheat_button);
                mCheatButton.setEnabled(true);
                mHintButton=(Button)findViewById(R.id.hint_button);
                mHintButton.setEnabled(true);
                mQuestionText=(TextView)findViewById(R.id.Quiz_Question_Text);
                mQuestionText.setTextColor(Color.parseColor("#000000"));
                mNumberText.setTextColor(Color.parseColor("#000000"));
            }
        });
        mCorrectButton = (Button) findViewById(R.id.Quiz_Correct_Button);
        mCorrectButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                attempt=true;
                mNumberText = (TextView)findViewById(R.id.Quiz_Number_Text);
                int num= Integer.parseInt(mNumberText.getText().toString());
                int flag=0;
                for(int i=2;i<num/2;i++)
                {
                    if(num%i==0)
                    {
                        flag=1;
                        break;
                    }
                }
                mCorrectButton=(Button)findViewById(R.id.Quiz_Correct_Button);
                mCorrectButton.setEnabled(false);
                mIncorrectButton=(Button)findViewById(R.id.Quiz_Incorrect_Button);
                mIncorrectButton.setEnabled(false);
                mHintButton=(Button)findViewById(R.id.hint_button);
                mHintButton.setEnabled(false);
                mCheatButton=(Button)findViewById(R.id.cheat_button);
                mCheatButton.setEnabled(false);
                questions++;
                if(flag==1)
                {
                    Toast.makeText(getApplicationContext(),"InCorrect",Toast.LENGTH_SHORT).show();
                    mQuestionText=(TextView)findViewById(R.id.Quiz_Question_Text);
                    mQuestionText.setTextColor(Color.parseColor("#FF0000"));
                    mNumberText=(TextView)findViewById(R.id.Quiz_Number_Text);
                    mNumberText.setTextColor(Color.parseColor("#FF0000"));

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                    mQuestionText=(TextView)findViewById(R.id.Quiz_Question_Text);
                    mQuestionText.setTextColor(Color.parseColor("#00FF00"));
                    mNumberText=(TextView)findViewById(R.id.Quiz_Number_Text);
                    mNumberText.setTextColor(Color.parseColor("#00FF00"));
                    correct_Answers++;
                    isCorrect=true;
                }
                mCorrectsText = (TextView)findViewById(R.id.Quiz_Correct_Text);
                mCorrectsText.setText(correct_Answers+" are correct out of "+questions+" questions attempted");
            }
        });
        mIncorrectButton = (Button) findViewById(R.id.Quiz_Incorrect_Button);
        mIncorrectButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                attempt=true;
                mNumberText = (TextView)findViewById(R.id.Quiz_Number_Text);
                int num= Integer.parseInt(mNumberText.getText().toString());
                int flag=0;
                for(int i=2;i<num/2;i++)
                {
                    if(num%i==0)
                    {
                        flag=1;
                        break;
                    }
                }
                mCorrectButton=(Button)findViewById(R.id.Quiz_Correct_Button);
                mCorrectButton.setEnabled(false);
                mIncorrectButton=(Button)findViewById(R.id.Quiz_Incorrect_Button);
                mIncorrectButton.setEnabled(false);
                mHintButton=(Button)findViewById(R.id.hint_button);
                mHintButton.setEnabled(false);
                mCheatButton=(Button)findViewById(R.id.cheat_button);
                mCheatButton.setEnabled(false);
                questions++;
                if(flag==1)
                {
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                    mQuestionText=(TextView)findViewById(R.id.Quiz_Question_Text);
                    mQuestionText.setTextColor(Color.parseColor("#00FF00"));
                    mNumberText=(TextView)findViewById(R.id.Quiz_Number_Text);
                    mNumberText.setTextColor(Color.parseColor("#00FF00"));
                    isCorrect=true;
                    correct_Answers++;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"InCorrect",Toast.LENGTH_SHORT).show();
                    mQuestionText=(TextView)findViewById(R.id.Quiz_Question_Text);
                    mQuestionText.setTextColor(Color.parseColor("#FF0000"));
                    mNumberText=(TextView)findViewById(R.id.Quiz_Number_Text);
                    mNumberText.setTextColor(Color.parseColor("#FF0000"));
                }
                mCorrectsText = (TextView)findViewById(R.id.Quiz_Correct_Text);
                mCorrectsText.setText(correct_Answers+" are correct out of "+questions+" questions attempted");
            }
        });
        mHintButton=(Button)findViewById(R.id.hint_button);
        mHintButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i=new Intent(getApplicationContext(),HintActivity.class);
                startActivityForResult(i,REQUEST_CODE);
            }
        });
        mCheatButton=(Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),CheatActivity.class);
                mQuestionText=(TextView)findViewById(R.id.Quiz_Question_Text);
                i.putExtra(question,Integer.parseInt(mNumberText.getText().toString()));
                startActivityForResult(i,REQUEST_CODE);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        mNumberText = (TextView)findViewById(R.id.Quiz_Number_Text);
        int num=Integer.parseInt(mNumberText.getText().toString());
        savedInstanceState.putInt(question_value,num);
        savedInstanceState.putBoolean(question_attempted,attempt);
        savedInstanceState.putBoolean(is_correct,isCorrect);
        savedInstanceState.putInt(correct_questions,correct_Answers);
        savedInstanceState.putInt(questions_attempted,questions);
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if(REQUEST_CODE==requestCode)
        {
            if(resultCode==RESULT_OK)
            {
                if(data.getStringExtra(MainActivity.result_class).equals("hint"))
                {
                    Toast.makeText(getApplicationContext(),"Hint Taken",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Cheated",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
