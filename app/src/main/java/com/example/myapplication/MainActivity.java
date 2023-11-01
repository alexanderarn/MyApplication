package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        The goal of this app is just to practice list views in AS.

        1. I created a ListView inside the XML main file with the ID: listview
        2. I referenced this View to the new ListView Object listView
        3. Created a new Array List and added Items to it
        4. Created an array adapter to display the Array List Items into the list view
        5. Now we want to customize the list item display
            for this i added a new layout-resource-file "myitem.xml"
            changed some design settings there
        6. Then we just gave some other variables to the adapter and refered inside there to the
            layout resource file
        7. Now we want to Customize the list even further. We want to add images and subtitles
            For this we add two more arrays for image and for subtitles
        8. Added my images to the drawable folder and refered them into my array list
        9. Now we are customizing the layout in the xml again
        10. Created a new Java Class called MyListAdapter that will be custom
         */

        // 2.
        ListView listView = findViewById(R.id.listview);

        // create a Array list and adding Items to it
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Banana");
        list.add("Grapes");
        System.out.print(list);

        // 7. Here we are adding our two additional Arrays
        String[] mainTitle = {
            "App No.1",
            "App No.2",
            "App No.3",
        };

        String[] subTitle = {
            "Untertitel No.1",
            "Untertitel No.2",
            "Untertitel No.3",
        };

        // Images are given back by ints not strings
        int[] imagesArray = {
                R.drawable.brain,
                R.drawable.lungs,
                R.drawable.meditation,
        };

        /*
        //1st way - no customization
        //need to create a array adapter to display the list inside the view
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                list);
        // connect created Adapter to listView
        listView.setAdapter(arrayAdapter);
         */

        /*
        //2nd way - with customization
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,
                R.layout.myitem,
                R.id.itemText,
                list
        );
        listView.setAdapter(arrayAdapter);
        */

        //3th way - with multiple data sources
        MyListAdapter myListAdapter = new MyListAdapter(this, mainTitle, subTitle, imagesArray);
        listView.setAdapter(myListAdapter);

    }
}