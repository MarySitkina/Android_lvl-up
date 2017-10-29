package com.example.maria.dictionary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.example.maria.dictionary.Model.Dictionary_Model;
import com.example.maria.dictionary.adapters.WordAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String fileDictionary = "ENRUS.TXT";

    private List<Dictionary_Model> data;
    private RecyclerView rvWord;
    private WordAdapter wordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWord = (RecyclerView)findViewById(R.id.rvWord);
        rvWord.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        data = new ArrayList<>();
        readFromAsset(getApplicationContext(),fileDictionary);
        wordAdapter = new WordAdapter();
        wordAdapter.setData(data);
        rvWord.setAdapter(wordAdapter);
        //get data from searchview
        SearchView searchView=(SearchView)findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText){
                searchWord(newText);
                return false;
            }

        });
    }
        //Read data from file ENRUS.txt
    private  void  readFromAsset(Context context,String fileName){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
            String mLine;
            int i=0;
            while ((mLine=reader.readLine()) !=null){
                String[] lineData=mLine.split("-");
                data.add(new Dictionary_Model(""+i,lineData[0],lineData[1]));
                i++;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void searchWord(String wordSearch){
        data.clear();
        readFromAsset(getApplicationContext(),fileDictionary);
        List<Dictionary_Model> temp = new ArrayList<>();
        for(Dictionary_Model dictionaryModel : data){
            if(dictionaryModel.getWord().startsWith(wordSearch)){
                temp.add(dictionaryModel);
            }
        }
            data = temp;

        wordAdapter.setData(data);
    }
}
