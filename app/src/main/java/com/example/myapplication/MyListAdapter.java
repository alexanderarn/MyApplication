package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// We created this class to have a custom Array Adapter
// For this we created a new one that extends the given Array Adapter class
public class MyListAdapter extends ArrayAdapter<String> {

    //for this we need to define our variables first
    private final Activity context;

    private final String[] mainTitle;
    private final String[] subTitle;
    private final int[] imageArray;

    // created the constructor method by clicking the red lamb
    public MyListAdapter(Activity context, String[] mainTitle, String[] subTitle, int[] imageArray) {
        // because this class extends another class we need to create the constructor and pass the parameters with super
        super(context, R.layout.myitem, mainTitle);
        this.context = context;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.imageArray = imageArray;
    }


    // This method is used to inflate the views in our xml with our content from this class
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.myitem, null, true);

        TextView titleText = rowView.findViewById(R.id.textview1);
        TextView subtitleText = rowView.findViewById(R.id.textview2);
        ImageView imageView = rowView.findViewById(R.id.imageview);

        titleText.setText(mainTitle[position]);
        subtitleText.setText(subTitle[position]);
        imageView.setImageResource(imageArray[position]);

        return rowView;
    }
}
