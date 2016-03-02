package ele.helper;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Amresh on 2/27/2016.
 */
public class FilterSms {

    ArrayList<SmsStructure> allSms = new ArrayList<>();
    ArrayList<SmsStructure> transactionalSms = new ArrayList<>();
    ArrayList<SmsStructure> NontransactionalSms = new ArrayList<>();
    ArrayList<SmsStructure> cabTravelSms = new ArrayList<>();
    SmsRepository smsRepository;

    public FilterSms(Context context) {
        smsRepository = new SmsRepository(context);
        allSms = smsRepository.getAllSMS();
    }

    /* Banking Related Methods */
    public ArrayList<SmsStructure> getICICISms()
    {
        ArrayList<SmsStructure> IciciSMS= new ArrayList<>();
        ArrayList<SmsStructure> Temp= new ArrayList<>();
        Temp = parseTransactionalSms();
        for(int i=0; i< Temp.size();i++)
        {
            SmsStructure eachSms = Temp.get(i);
            if(eachSms.getAddress().contains("ICICI"))
            {
                IciciSMS.add(eachSms);
            }

        }
        return IciciSMS;

    }
    public ArrayList<SmsStructure> getHDFCSms()
    {
        ArrayList<SmsStructure> HDFCSMS= new ArrayList<>();
        ArrayList<SmsStructure> Temp= new ArrayList<>();
        Temp = parseTransactionalSms();
        for(int i=0; i< Temp.size();i++)
        {
            SmsStructure eachSms = Temp.get(i);
            if(eachSms.getAddress().contains("HDFC"))
            {
                HDFCSMS.add(eachSms);
            }

        }
        return HDFCSMS;

    }
    public ArrayList<SmsStructure> getKotakSms()
    {
        ArrayList<SmsStructure> KotakSMS= new ArrayList<>();
        ArrayList<SmsStructure> Temp= new ArrayList<>();
        Temp = parseTransactionalSms();
        for(int i=0; i< Temp.size();i++)
        {
            SmsStructure eachSms = Temp.get(i);
            if(eachSms.getAddress().contains("Kotak"))
            {
                KotakSMS.add(eachSms);
            }

        }
        return KotakSMS;

    }
    public ArrayList<SmsStructure> getSBISms()
    {
        ArrayList<SmsStructure> SBISMS= new ArrayList<>();
        ArrayList<SmsStructure> Temp= new ArrayList<>();
        Temp = parseTransactionalSms();
        for(int i=0; i< Temp.size();i++)
        {
            SmsStructure eachSms = Temp.get(i);
            if(eachSms.getAddress().contains("SBI"))
            {
                SBISMS.add(eachSms);
            }

        }
        return SBISMS;

    }

    public ArrayList<SmsStructure> getAxisSms()
    {
        ArrayList<SmsStructure> AxisSMS= new ArrayList<>();
        ArrayList<SmsStructure> Temp= new ArrayList<>();
        Temp = parseTransactionalSms();
        for(int i=0; i< Temp.size();i++)
        {
            SmsStructure eachSms = Temp.get(i);
            if(eachSms.getAddress().contains("AXIS"))
            {
                AxisSMS.add(eachSms);
            }

        }
        return AxisSMS;

    }

    public ArrayList<SmsStructure> getCitiSms()
    {
        ArrayList<SmsStructure> CitiSMS= new ArrayList<>();
        ArrayList<SmsStructure> Temp= new ArrayList<>();
        Temp = parseTransactionalSms();
        for(int i=0; i< Temp.size();i++)
        {
            SmsStructure eachSms = Temp.get(i);
            if(eachSms.getAddress().contains("CITI"))
            {
                CitiSMS.add(eachSms);
            }

        }
        return CitiSMS;

    }




    public ArrayList<SmsStructure> parseTransactionalSms() {
        for (int i = 0; i < allSms.size(); i++) {
            SmsStructure eachSms = allSms.get(i);

            if (eachSms.getAddress().contains("ICIC") ||
                    eachSms.getAddress().contains("HDFC") ||
                    eachSms.getAddress().contains("Kotak") ||
                    eachSms.getAddress().contains("SBI") ||
                    eachSms.getAddress().contains("AXIS") ||
                    eachSms.getAddress().contains("CITI")) {
                transactionalSms.add(eachSms);
            }

            /*Pattern regEx
                    = Pattern.compile("(?:INR|inr|RS|rs)+[\\s]*[0-9+[\\,]*+[0-9]*]+[\\.]*[0-9]+");
            // Find instance of pattern matches
            Matcher m = regEx.matcher(eachSms.getBody());
            if (m.find() && eachSms.getAddress().contains("ICIC")) {
                try {
                    Log.e("amount_value= ", "" + m.group(0));
                    String amount = (m.group(0).replaceAll("inr", ""));
                    amount = amount.replaceAll("rs", "");
                    amount = amount.replaceAll("inr", "");
                    amount = amount.replaceAll(" ", "");
                    amount = amount.replaceAll(",", "");
                    eachSms.setAmount(Double.valueOf(amount));
                    if (eachSms.getBody().contains("debited") ||
                            eachSms.getBody().contains("purchasing") || eachSms.getBody().contains("purchase") || eachSms.getBody().contains("dr")) {
                        eachSms.setTransactionType("0");
                    } else if (eachSms.getBody().contains("credited") || eachSms.getBody().contains("cr")) {
                        eachSms.setTransactionType("1");
                    }
                    eachSms.setParsed("1");
                    Log.e("matchedValue= ", "" + amount);
                    if (eachSms.getSenderID()==null)
                        transactionalSms.add(eachSms);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("No_matchedValue ", "No_matchedValue ");
            } */
        }


        return transactionalSms;
    }

    public ArrayList<SmsStructure> getOlaSms()
    {
        ArrayList<SmsStructure> OlaSMS= new ArrayList<>();
        ArrayList<SmsStructure> Temp= new ArrayList<>();
        Temp = parseCabTravelSms();
        for(int i=0; i< Temp.size();i++)
        {
            SmsStructure eachSms = Temp.get(i);
            if(eachSms.getAddress().contains("OLA"))
            {
                OlaSMS.add(eachSms);
            }

        }
        return OlaSMS;

    }

    public ArrayList<SmsStructure> getUberSms()
    {
        ArrayList<SmsStructure> UberSMS= new ArrayList<>();
        ArrayList<SmsStructure> Temp= new ArrayList<>();
        Temp = parseCabTravelSms();
        for(int i=0; i< Temp.size();i++)
        {
            SmsStructure eachSms = Temp.get(i);
            if(eachSms.getAddress().contains("UBER"))
            {
                UberSMS.add(eachSms);
            }

        }
        return UberSMS;

    }

    public ArrayList<SmsStructure> getTaxiFSSms()
    {
        ArrayList<SmsStructure> TaxiFSSMS= new ArrayList<>();
        ArrayList<SmsStructure> Temp= new ArrayList<>();
        Temp = parseCabTravelSms();
        for(int i=0; i< Temp.size();i++)
        {
            SmsStructure eachSms = Temp.get(i);
            if(eachSms.getAddress().contains("TAXIFS"))
            {
                TaxiFSSMS.add(eachSms);
            }

        }
        return TaxiFSSMS;

    }



    public ArrayList<SmsStructure> parseCabTravelSms() {
        for (int i = 0; i < allSms.size(); i++) {
            SmsStructure eachSms = allSms.get(i);

            if (eachSms.getAddress().contains("OLA") ||
                    eachSms.getAddress().contains("UBER") ||
                    eachSms.getAddress().contains("TAXIFS")) {
                cabTravelSms.add(eachSms);
            }

        }
        return cabTravelSms;
    }

    public ArrayList<SmsStructure> parseNonTransactionalSms() {
        for (int i = 0; i < allSms.size(); i++) {
            SmsStructure eachSms = allSms.get(i);

            if (!eachSms.getAddress().contains("OLA") ||
                    !eachSms.getAddress().contains("UBER") ||
                    !eachSms.getAddress().contains("TAXIFS") ||
                    !eachSms.getAddress().contains("ICIC") ||
                    !eachSms.getAddress().contains("HDFC") ||
                    !eachSms.getAddress().contains("Kotak") ||
                    !eachSms.getAddress().contains("SBI") ||
                    !eachSms.getAddress().contains("AXIS") ||
                    !eachSms.getAddress().contains("CITI")) {
                NontransactionalSms.add(eachSms);
            }

        }
        return NontransactionalSms;
    }



}