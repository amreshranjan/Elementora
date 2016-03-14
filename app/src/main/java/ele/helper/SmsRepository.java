package ele.helper;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by Amresh on 2/27/2016.
 */
public class SmsRepository  {

    SmsStructure smsStructure;
    ArrayList<String> smsMessagesList = new ArrayList<>();
    ArrayList<SmsStructure> allSmsList= new ArrayList<>();
    ArrayList<SmsStructure> parsedList= new ArrayList<>();
    //ListView smsListView;
    //ArrayAdapter arrayAdapter;
    Context context;
    public SmsRepository(Context context)
    {
        this.context=context;
    }

    /*  Method for getting all SMS*/
    public ArrayList<SmsStructure> getAllSMS() {

        ContentResolver contentResolver = context.getContentResolver();
        Cursor smsInboxCursor = contentResolver.query(Uri.parse("content://sms/inbox"), null, null, null, null);
        int indexBody = smsInboxCursor.getColumnIndex("body");
        int indexAddress = smsInboxCursor.getColumnIndex("address");
        int indexPerson = smsInboxCursor.getColumnIndex("person");

        if (indexBody < 0 || !smsInboxCursor.moveToFirst()) return null;
        //arrayAdapter.clear();
        if(allSmsList.size()>0) {
            allSmsList.clear();
        }
        do {
            smsStructure = new SmsStructure();
            smsStructure.setAddress(smsInboxCursor.getString(indexAddress) == null ? "121" : smsInboxCursor.getString(indexAddress));
            smsStructure.setBody(smsInboxCursor.getString(indexBody));
            smsStructure.setSenderID(smsInboxCursor.getString(indexPerson));

            allSmsList.add(smsStructure);
        } while (smsInboxCursor.moveToNext());


        return  allSmsList;

    }


}
