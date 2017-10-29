package com.example.maria.dictionary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DefinitionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_definition);

        String word=getIntent().getStringExtra("WORD");
        String definition=getIntent().getStringExtra("DEFINITION");

        //SOMETHING GOES WRONG(((((
       // String Str1 = "cat";
       // boolean retVal;
        //retVal = word.equals(Str1);
        //if(!retVal)
            setContentView(R.layout.cat);

        TextView wordText=(TextView)findViewById(R.id.wordText);
        TextView definitionText=(TextView)findViewById(R.id.definitionText);
        wordText.setText(word);


        definitionText.setText(definition);
    }
}
