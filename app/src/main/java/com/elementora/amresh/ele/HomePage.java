package com.elementora.amresh.ele;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;


/**
 * Created by Amresh on 2/27/2016.
 */
public class HomePage extends Activity {

    GridView gvTransactional, gvNonTransactional;
    TextView tvTransactional, tvNonTransactional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        gvTransactional= (GridView) findViewById(R.id.gvTrnsactional);
        tvTransactional =(TextView) findViewById(R.id.tvTransactional);


    }

}
