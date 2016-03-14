package ele.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.elementora.amresh.ele.R;

import java.util.HashMap;

import ele.helper.FillDataForGrid;

/**
 * Created by Amresh on 2/27/2016.
 */
public class ImageAdapter extends BaseAdapter {
    Context context;
    String smsType;
    HashMap<String, Integer> hasmap;
    public ImageAdapter(Context context, String smsType, HashMap<String, Integer> hasmap)
    {
        this.context= context;
        this.smsType= smsType;
        this.hasmap = hasmap;
    }

    @Override
    public int getCount()
    {
        return hasmap.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ImageView imageView;
        TextView textView;
        FillDataForGrid fillDataForGrid= new FillDataForGrid(hasmap);
        LayoutInflater layoutInflater= (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        view= layoutInflater.inflate(R.layout.grid_data, parent, false);
        imageView = (ImageView) view.findViewById(R.id.ivGridData);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        textView = (TextView) view.findViewById(R.id.tvGridData);
        //imageView.setPadding(20, 20, 20, 20);

        if(smsType=="Transactional") {

            System.out.println("See Parent" + parent.getId());

            imageView.setImageResource(fillDataForGrid.getBankImage()[position]);
            textView.setText(fillDataForGrid.getBankSMSCount()[position]+ " SMS Found");

        }

        if(smsType=="Cab") {

            imageView.setImageResource(fillDataForGrid.getCabImage()[position]);
            textView.setText(fillDataForGrid.getCabSMSCount()[position] +" SMS Found ");
        }

        if(smsType=="Non-Transactional"){

            imageView.setImageResource(R.drawable.others);
            textView.setText(hasmap.get("Non-Transactional") + " SMS Found");
        }
        if(smsType=="Matched-Transactional") {
            imageView.setImageResource(R.drawable.transaction);
            textView.setText(hasmap.get("Matched-Transactional") + " SMS Found");
        }

        return view;
    }



}
