package com.example.maria.dictionary.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maria.dictionary.DefinitionActivity;
import com.example.maria.dictionary.Model.Dictionary_Model;
import com.example.maria.dictionary.R;

import java.util.List;

/**
 * Created by maria on 28.10.17.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    public List<Dictionary_Model> data;

    public WordAdapter() {
    }

    public void setData(List<Dictionary_Model> data) {
    this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater =  LayoutInflater.from(context);

        //Inflate the custom layout

        View wordView = inflater.inflate(R.layout.word_item,parent,false);

        //Return a new holder instance

        ViewHolder viewHolder = new ViewHolder(wordView,context);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Dictionary_Model dictionary_Model= data.get(position);
        holder.wordText.setText(dictionary_Model.getWord());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public TextView wordText;
        public ViewHolder(View itemView, final Context context) {
            super(itemView);
            this.context = context;

            wordText = (TextView)itemView.findViewById(R.id.wordText);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int position=getAdapterPosition();
                    Dictionary_Model dictionary_Model=data.get(position);

                    Intent intent=new Intent(context, DefinitionActivity.class);
                    intent.putExtra("WORD",dictionary_Model.getWord());
                    intent.putExtra("DEFINITION",dictionary_Model.getDefinition());

                    context.startActivity(intent);
                }
            });
        }

    }
}


























