package com.elementora.amresh.ele;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import ele.adapter.CustomAdapter;
import ele.helper.FilterSms;

/**
 * Created by Amresh on 2/27/2016.
 */
public class ParentHome extends AppCompatActivity{

    //FilterSms filterSms = new FilterSms(ParentHome.this);
    boolean updateStatus= false;
    private static ParentHome parentHomeRef;
    String extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_home);
        parentHomeRef = this;
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle("Ele:SMS Category");
        extras = getIntent().getStringExtra("AddToList");
        if (extras != null) {
            this.updateStatus=true;

        }
        ListView lvContainor = (ListView) findViewById(R.id.lvContainor);
        lvContainor.setAdapter(new CustomAdapter(ParentHome.this, updateStatus));

    }

    public static ParentHome getInstance(){
        return parentHomeRef;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_settings).setIcon(R.drawable.notification);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            if(extras!=null)
            {
                Toast.makeText(ParentHome.this,"Already Added",Toast.LENGTH_SHORT ).show();
            }
            else {
                intent = new Intent(this, MatchStructure.class);
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    /*@Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }*/
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        System.exit(0);
    }
}
