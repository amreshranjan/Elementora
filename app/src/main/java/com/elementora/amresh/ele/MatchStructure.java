package com.elementora.amresh.ele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ele.adapter.CustomAdapter;
import ele.helper.FilterSms;
import ele.helper.SmsStructure;

/**
 * Created by Amresh on 3/13/2016.
 */
public class MatchStructure extends Activity {


    ArrayList<SmsStructure> listOfUnknown= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_structure);
        FilterSms filterSms= new FilterSms(MatchStructure.this);
        listOfUnknown = filterSms.parseMatchTransactionalSms();
        System.out.println("In Diolouge" + listOfUnknown.size());
        TextView textView = (TextView) findViewById(R.id.tvMatchStructure);
        textView.setText("You have "+ listOfUnknown.size()+" new SMS Matched with Transactional Structure");
        Button addButton = (Button) findViewById(R.id.btnAddToList);
        Button discardButton = (Button) findViewById(R.id.btnCancel);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParentHome.getInstance().finish();
                Intent intent= new Intent(MatchStructure.this, ParentHome.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("AddToList", "AddtoList");
                startActivity(intent);

            }
        });

        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        System.exit(0);
    }
}
