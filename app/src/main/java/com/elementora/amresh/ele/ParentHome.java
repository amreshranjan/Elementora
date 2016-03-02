package com.elementora.amresh.ele;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import ele.adapter.CustomAdapter;

/**
 * Created by Amresh on 2/27/2016.
 */
public class ParentHome extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_home);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("Ele:SMS Category");
        ListView lvContainor = (ListView) findViewById(R.id.lvContainor);
        lvContainor.setAdapter(new CustomAdapter(ParentHome.this));
    }
}
