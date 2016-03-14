package ele.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.elementora.amresh.ele.BookMarkViewPager;
import com.elementora.amresh.ele.R;

import java.util.ArrayList;
import java.util.HashMap;

import ele.helper.FillDataForGrid;
import ele.helper.FilterSms;
import ele.helper.Rule;
import ele.helper.SmsStructure;

/**
 * Created by Amresh on 2/27/2016.
 */
public class CustomAdapter extends BaseAdapter {

    int listOfCategory=4; /* Use for number of categories for different views*/
    boolean updateView= false;
    TextView textView, tvNonData;
    GridView gridView;
    Context context;
    ArrayList<SmsStructure> transactionalSMS = new ArrayList<>();
    ArrayList<SmsStructure> nonTransactionalSMS = new ArrayList<>();
    ArrayList<SmsStructure> cabTravelSMS = new ArrayList<>();
    ArrayList<SmsStructure> mIciciSmsArrayList,mHdfcSmsArrayList,mKotakSmsArrayList,mSbiSmsArrayList, mCitiSmsArrayList, mAxisSmsArrayList;
    ArrayList<SmsStructure> mOlaSmsList, mUberSmsList, mTaxiFSSmsList;
    ArrayAdapter<String> mArrayAdaptor;
    Bundle bundle;
    public  CustomAdapter()
    {

    }

    public CustomAdapter(Context context, boolean updateView)
    {
        this.context=context;
        this.updateView= updateView;
        mSbiSmsArrayList = new ArrayList<>();
        mIciciSmsArrayList = new ArrayList<>();
        mKotakSmsArrayList = new ArrayList<>();
        mHdfcSmsArrayList = new ArrayList<>();
        mAxisSmsArrayList= new ArrayList<>();
        mOlaSmsList = new ArrayList<>();
        mUberSmsList= new ArrayList<>();
        mTaxiFSSmsList= new ArrayList<>();
        mCitiSmsArrayList= new ArrayList<>();
        
        
    }
    public void isUpdateView(boolean updateView)
    {
        this.updateView= updateView;
    }

    @Override
    public int getCount() {
        return listOfCategory;
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
        View view=null;
        bundle = new Bundle();
        /* Temporary variable for Banking Sms*/
        final ArrayList<String> H_bankSmsList= new ArrayList<>();
        final ArrayList<String> K_bankSmsList= new ArrayList<>();
        final ArrayList<String> S_bankSmsList= new ArrayList<>();
        final ArrayList<String> A_bankSmsList= new ArrayList<>();
        final ArrayList<String> I_bankSmsList= new ArrayList<>();
        final ArrayList<String> C_bankSmsList= new ArrayList<>();

        /* Temporary variable for Cabs Sms*/
        final ArrayList<String> O_CabSmsList= new ArrayList<>();
        final ArrayList<String> U_CabSmsList= new ArrayList<>();
        final ArrayList<String> T_CabSmsList= new ArrayList<>();

        /* Temporary variable for all Non-Transactional sms*/

        final ArrayList<String> other_SmsList= new ArrayList<>();

        FilterSms filterSms = new FilterSms(context);
        final HashMap<String, Integer> hashMap= new HashMap<>();
        LayoutInflater layoutInflater= (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        switch (position)
        {
            case 0:
                view= layoutInflater.inflate(R.layout.home_page,parent,false );
                textView = (TextView) view.findViewById(R.id.tvTransactional);
                textView.setText("Transactional");
                gridView = (GridView) view.findViewById(R.id.gvTrnsactional);
                transactionalSMS = filterSms.parseTransactionalSms();
                if(transactionalSMS.size()>0) {

                    mIciciSmsArrayList= filterSms.getICICISms();
                    mHdfcSmsArrayList= filterSms.getHDFCSms();
                    mKotakSmsArrayList= filterSms.getKotakSms();
                    mSbiSmsArrayList= filterSms.getSBISms();
                    mAxisSmsArrayList= filterSms.getAxisSms();
                    mCitiSmsArrayList= filterSms.getCitiSms();

                    if(mIciciSmsArrayList.size()>0)
                    {
                        System.out.println("AmreshCode Size" + mIciciSmsArrayList.size());
                        for(int i=0; i<mIciciSmsArrayList.size();i++)
                        {
                            String strBody = mIciciSmsArrayList.get(i).getBody();

                                I_bankSmsList.add(strBody);
                                if(hashMap.containsKey("ICICI")) {
                                    hashMap.put("ICICI",hashMap.get("ICICI")+1 );
                                }
                                else {
                                    hashMap.put("ICICI", 1);
                                }
                            }




                    }

                    if(mHdfcSmsArrayList.size()>0)
                    {
                        for(int i=0; i<mHdfcSmsArrayList.size();i++) {
                            String strBody = mHdfcSmsArrayList.get(i).getBody();
                            H_bankSmsList.add(strBody);

                            if (hashMap.containsKey("HDFC")) {
                                hashMap.put("HDFC", hashMap.get("HDFC") + 1);
                            } else {
                                hashMap.put("HDFC", 1);
                            }
                        }

                    }
                    if(mKotakSmsArrayList.size()>0)
                    {
                        for(int i=0; i<mKotakSmsArrayList.size();i++) {
                            String strBody = mKotakSmsArrayList.get(i).getBody();
                            K_bankSmsList.add(strBody);
                            if (hashMap.containsKey("KOTAK")) {
                                hashMap.put("KOTAK", hashMap.get("KOTAK") + 1);
                            } else {
                                hashMap.put("KOTAK", 1);
                            }
                        }


                    }

                    if(mSbiSmsArrayList.size()>0)
                    {
                        for(int i=0; i<mSbiSmsArrayList.size();i++) {
                            String strBody = mSbiSmsArrayList.get(i).getBody();
                            S_bankSmsList.add(strBody);
                            if (hashMap.containsKey("SBI")) {
                                hashMap.put("SBI", hashMap.get("SBI") + 1);
                            } else {
                                hashMap.put("SBI", 1);
                            }
                        }

                    }

                    if(mAxisSmsArrayList.size()>0)
                    {
                        for(int i=0; i<mAxisSmsArrayList.size();i++) {
                            String strBody = mAxisSmsArrayList.get(i).getBody();
                            A_bankSmsList.add(strBody);
                            if(hashMap.containsKey("AXIS")) {
                                hashMap.put("AXIS",hashMap.get("AXIS") + 1 );
                            }
                            else {
                                hashMap.put("AXIS", 1);
                            }
                        }

                    }

                    if(mCitiSmsArrayList.size()>0)
                    {
                        for(int i=0; i<mCitiSmsArrayList.size();i++) {
                            String strBody = mCitiSmsArrayList.get(i).getBody();
                            C_bankSmsList.add(strBody);
                            if(hashMap.containsKey("CITI")) {
                                hashMap.put("CITI",hashMap.get("CITI") + 1 );
                            }
                            else {
                                hashMap.put("CITI", 1);
                            }
                        }

                    }

                    gridView.setNumColumns(GridView.AUTO_FIT);

                    gridView.setAdapter(new ImageAdapter(context, "Transactional",  hashMap));
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            System.out.println("viewId : "+ view.getId()+" "+position);
                            Intent newIntent = new Intent(context, BookMarkViewPager.class);
                            FillDataForGrid fillDataForGrid = new FillDataForGrid(hashMap);
                            Integer[] listOfImages= fillDataForGrid.getBankImage();

                            if(listOfImages[position]== R.drawable.icici)
                            {
                                bundle.clear();
                                bundle.putStringArrayList("SMSLIST", I_bankSmsList);
                            }
                            if(listOfImages[position]== R.drawable.hdfc)
                            {
                                bundle.clear();
                                bundle.putStringArrayList("SMSLIST", H_bankSmsList);
                            }
                            if(listOfImages[position]== R.drawable.kotak)
                            {
                                bundle.clear();
                                bundle.putStringArrayList("SMSLIST", K_bankSmsList);
                            }
                            if(listOfImages[position]== R.drawable.sbi)
                            {
                                bundle.clear();
                                bundle.putStringArrayList("SMSLIST", S_bankSmsList);
                            }
                            if(listOfImages[position]== R.drawable.axis)
                            {
                                bundle.clear();
                                bundle.putStringArrayList("SMSLIST", A_bankSmsList);
                            }
                            if(listOfImages[position]== R.drawable.citi)
                            {
                                bundle.clear();
                                bundle.putStringArrayList("SMSLIST", C_bankSmsList);
                            }
                            newIntent.putExtras(bundle);
                            context.startActivity(newIntent);
                        }
                    });

                }
                else
                {
                    gridView.setVisibility(View.GONE);
                    tvNonData =(TextView) view.findViewById(R.id.tvNoData);
                    tvNonData.setVisibility(View.VISIBLE);
                    tvNonData.setText("No Transaction found");
                }
                break;
            case 1: // Will inflate Cab related Sms
                view= layoutInflater.inflate(R.layout.home_page,parent,false );
                textView = (TextView) view.findViewById(R.id.tvTransactional);
                textView.setText("Traveled Data");
                gridView = (GridView) view.findViewById(R.id.gvTrnsactional);
                cabTravelSMS = filterSms.parseCabTravelSms();
                if(cabTravelSMS.size()>0)
                {
                    mOlaSmsList= filterSms.getOlaSms();
                    mUberSmsList= filterSms.getUberSms();
                    mTaxiFSSmsList= filterSms.getTaxiFSSms();

                    if(mOlaSmsList.size()>0)
                    {
                        for(int i=0; i<mOlaSmsList.size();i++)
                        {
                            String strBody = mOlaSmsList.get(i).getBody();
                            O_CabSmsList.add(strBody);
                            if(hashMap.containsKey("OLA")) {
                                hashMap.put("OLA", hashMap.get("OLA")+1 );
                            }
                            else {
                                hashMap.put("OLA", 1);
                            }

                        }

                    }

                    if(mUberSmsList.size()>0)
                    {
                        for(int i=0; i<mUberSmsList.size();i++)
                        {
                            String strBody = mUberSmsList.get(i).getBody();
                            U_CabSmsList.add(strBody);
                            if(hashMap.containsKey("UBER")) {
                                hashMap.put("UBER",hashMap.get("UBER")+1 );
                            }
                            else {
                                hashMap.put("UBER", 1);
                            }


                        }

                    }

                    if(mTaxiFSSmsList.size()>0)
                    {
                        for(int i=0; i<mTaxiFSSmsList.size();i++)
                        {
                            String strBody = mTaxiFSSmsList.get(i).getBody();
                            T_CabSmsList.add(strBody);
                            if(hashMap.containsKey("TAXIFS")) {
                                hashMap.put("TAXIFS",hashMap.get("TAXIFS")+1 );
                            }
                            else {
                                hashMap.put("TAXIFS", 1);
                            }



                        }

                    }


                    gridView.setNumColumns(GridView.AUTO_FIT);
                    gridView.setAdapter(new ImageAdapter(context, "Cab", hashMap));
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            System.out.println("viewId : "+ view.getId()+" "+position);
                            Intent newIntent = new Intent(context, BookMarkViewPager.class);
                            FillDataForGrid fillDataForGrid = new FillDataForGrid(hashMap);
                            Integer[] listOfImages= fillDataForGrid.getCabImage();

                                if(listOfImages[position]== R.drawable.ola)
                                {
                                    bundle.clear();
                                    bundle.putStringArrayList("SMSLIST", O_CabSmsList);
                                }
                                if(listOfImages[position]== R.drawable.uber)
                                {
                                    bundle.clear();
                                    bundle.putStringArrayList("SMSLIST", U_CabSmsList);
                                }
                                if(listOfImages[position]== R.drawable.taxiforsure)
                                {
                                    bundle.clear();
                                    bundle.putStringArrayList("SMSLIST", T_CabSmsList);
                                }

                            newIntent.putExtras(bundle);
                            context.startActivity(newIntent);
                        }
                    });


                }
                else
                {
                    gridView.setVisibility(View.GONE);
                    tvNonData =(TextView) view.findViewById(R.id.tvNoData);
                    tvNonData.setVisibility(View.VISIBLE);
                    tvNonData.setText("No Travel found");
                }

                break;
            case 2:
                view= layoutInflater.inflate(R.layout.home_page,parent,false );
                textView = (TextView) view.findViewById(R.id.tvTransactional);
                textView.setText("Non-Transactional");
                gridView = (GridView) view.findViewById(R.id.gvTrnsactional);
                nonTransactionalSMS = filterSms.parseNonTransactionalSms();
                if(nonTransactionalSMS.size()>0) {
                    for(int i=0; i< nonTransactionalSMS.size();i++)
                    {
                        String strBody = nonTransactionalSMS.get(i).getBody();
                        other_SmsList.add(strBody);
                        if(hashMap.containsKey("Non-Transactional")) {
                            hashMap.put("Non-Transactional",hashMap.get("Non-Transactional")+1 );
                        }
                        else {
                            hashMap.put("Non-Transactional", 1);
                        }

                    }
                    gridView.setNumColumns(GridView.AUTO_FIT);

                    gridView.setAdapter(new ImageAdapter(context, "Non-Transactional",  hashMap));
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent newIntent = new Intent(context, BookMarkViewPager.class);

                            bundle.clear();
                            bundle.putStringArrayList("SMSLIST", other_SmsList);


                            newIntent.putExtras(bundle);
                            context.startActivity(newIntent);
                        }
                    });
                }
                else
                {
                    gridView.setVisibility(View.GONE);
                    tvNonData =(TextView) view.findViewById(R.id.tvNoData);
                    tvNonData.setVisibility(View.VISIBLE);
                    tvNonData.setText("No Travel found");
                }

                break;
            case 3:
                view= layoutInflater.inflate(R.layout.home_page,parent,false );
                textView = (TextView) view.findViewById(R.id.tvTransactional);
                gridView = (GridView) view.findViewById(R.id.gvTrnsactional);
                if(updateView)
                {
                    textView.setText("Matched Transactional");
                    nonTransactionalSMS = filterSms.parseMatchTransactionalSms();
                    if(nonTransactionalSMS.size()>0) {
                        for(int i=0; i< nonTransactionalSMS.size();i++)
                        {
                            String strBody = nonTransactionalSMS.get(i).getBody();
                            other_SmsList.add(strBody);
                            if(hashMap.containsKey("Matched-Transactional")) {
                                hashMap.put("Matched-Transactional",hashMap.get("Matched-Transactional")+1 );
                            }
                            else {
                                hashMap.put("Matched-Transactional", 1);
                            }

                        }
                        gridView.setNumColumns(GridView.AUTO_FIT);
                        gridView.setAdapter(new ImageAdapter(context, "Matched-Transactional",  hashMap));
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent newIntent = new Intent(context, BookMarkViewPager.class);

                                bundle.clear();
                                bundle.putStringArrayList("SMSLIST", other_SmsList);


                                newIntent.putExtras(bundle);
                                context.startActivity(newIntent);
                            }
                        });
                    }


                }
                else
                {
                    gridView.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    tvNonData =(TextView) view.findViewById(R.id.tvNoData);
                    tvNonData.setVisibility(View.VISIBLE);
                    tvNonData.setText("***Click on Notifications to add new Structure");

                }
                break;
        }
        return view;
    }


}
