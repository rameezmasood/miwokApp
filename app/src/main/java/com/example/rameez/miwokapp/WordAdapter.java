package com.example.rameez.miwokapp;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rameez on 9/28/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    public WordAdapter(Activity context,ArrayList<Word> words,int colorResourceId) {
        super(context,0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null ){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.miwok_default_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getmImageResourceId());

            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }
        //find the linear layout which containg two text area
        LinearLayout textViewLayout = (LinearLayout) listItemView.findViewById(R.id.text_container);
        //fetch color from color resource id
        int color = ContextCompat.getColor(getContext(),this.mColorResourceId);
        //applying color on the layout according to selected category
        textViewLayout.setBackgroundColor(color);

        return listItemView;
    }
}
/*public class WordAdapter extends ArrayAdapter<Word> {

    public View getView(int position, View convertView, ViewGroup parent){
        return  super.getView(position,convertView,parent);
    }
}*/
