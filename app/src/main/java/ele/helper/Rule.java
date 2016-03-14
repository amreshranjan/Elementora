package ele.helper;

import android.provider.Telephony;

/**
 * Created by Amresh on 3/11/2016.
 */
public class Rule {

    SmsStructure smsBody;
    String body;

    public Rule(SmsStructure smsBody)
    {
        this.smsBody= smsBody;
        this.body= smsBody.getBody();
    }

    public String getSmsCheck()
    {
        String bodyType= "";
        if(body.contains("INR")|| body.contains("RS "))
        {
            //if(body.contains("Your Net Available Balance is")) {
                bodyType = "Banking";
            }

        //}

        if(body.contains("more details"))
        {
            bodyType="Promotional";

        }
        return bodyType;
    }
}
