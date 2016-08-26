package com.example.user.quiz_mt16026;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.quiz_mt16026.R;

/**
 * Created by user on 25-Aug-16.
 */
public class HintActivity extends AppCompatActivity {
    private Button mShowHintButton;
    private TextView mHintText;
    private boolean buttonClicked;
    private static final String button_clicked="buttonClicked";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        if(savedInstanceState!=null)
        {
            buttonClicked=savedInstanceState.getBoolean(button_clicked);
            if(buttonClicked)
            {
                mHintText=(TextView)findViewById(R.id.hint_text);
                mHintText.setText("Prime Number is the number which cannot be divided except the number itself and one");
                Intent resultIntent=new Intent();
                resultIntent.putExtra(MainActivity.result_class,"hint");
                setResult(Activity.RESULT_OK,resultIntent);
            }
        }
        else
        {
            buttonClicked=false;

        }
        mShowHintButton=(Button)findViewById(R.id.show_hint_button);
        mShowHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHintText=(TextView)findViewById(R.id.hint_text);
                mHintText.setText("Prime Number is the number which cannot be divided except the number itself and one");
                buttonClicked=true;
                Intent resultIntent=new Intent();
                resultIntent.putExtra(MainActivity.result_class,"hint");
                setResult(Activity.RESULT_OK,resultIntent);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(button_clicked,buttonClicked);

    }
}
