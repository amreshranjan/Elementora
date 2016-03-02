package ele.helper;

import com.elementora.amresh.ele.R;

import java.util.HashMap;

/**
 * Created by Amresh on 2/28/2016.
 */
public class FillDataForGrid {

HashMap<String, Integer> hasmap = new HashMap<>();
    public  FillDataForGrid(HashMap<String, Integer> hasmap)
    {
        this.hasmap= hasmap;
    }
    public int[] getBankSMSCount()
    {
        int[] count= new int[hasmap.size()];
        Integer[] l_image;
        l_image= getBankImage();
        for(int i=0; i< l_image.length; i++)
        {
            if(l_image[i]== R.drawable.icici)
            {
                count[i]= hasmap.get("ICICI");
            }
            if(l_image[i]== R.drawable.hdfc)
            {
                count[i]= hasmap.get("HDFC");
            }
            if(l_image[i]== R.drawable.kotak)
            {
                count[i]= hasmap.get("Kotak");
            }
            if(l_image[i]== R.drawable.sbi)
            {
                count[i]= hasmap.get("SBI");
            }
            if(l_image[i]== R.drawable.axis)
            {
                count[i]= hasmap.get("AXIS");
            }
            if(l_image[i]== R.drawable.citi)
            {
                count[i]= hasmap.get("CITI");
            }
        }

        return count;

    }

    public int[] getCabSMSCount()
    {
        int[] count= new int[hasmap.size()];
        Integer[] l_image;
        l_image= getCabImage();
        for(int i=0; i< l_image.length; i++)
        {
            if(l_image[i]== R.drawable.ola)
            {
                count[i]= hasmap.get("OLA");
            }
            if(l_image[i]== R.drawable.uber)
            {
                count[i]= hasmap.get("UBER");
            }
            if(l_image[i]== R.drawable.taxiforsure)
            {
                count[i]= hasmap.get("TAXIFS");
            }
        }

        return count;

    }


    public Integer[] getBankImage()
    {
        int index=0;
        Integer[] listofImages =new Integer[hasmap.size()];
        if(hasmap.containsKey("ICICI"))
        {
            listofImages[index]= R.drawable.icici;
            index++;
        }
        if(hasmap.containsKey("HDFC"))
        {
            listofImages[index]= R.drawable.hdfc;
            index++;
        }
        if(hasmap.containsKey("Kotak"))
        {
            listofImages[index]= R.drawable.kotak;
            index++;
        }
        if(hasmap.containsKey("SBI"))
        {
            listofImages[index]= R.drawable.sbi;
            index++;
        }
        if(hasmap.containsKey("AXIS"))
        {
            listofImages[index]= R.drawable.axis;
            index++;
        }
        if(hasmap.containsKey("CITI"))
        {
            listofImages[index]= R.drawable.citi;
            index++;
        }
        return listofImages;
    }

    public Integer[] getCabImage()
    {
        int index=0;
        Integer[] listofImages =new Integer[hasmap.size()];
        if(hasmap.containsKey("OLA"))
        {
            listofImages[index]= R.drawable.ola;
            index++;
        }
        if(hasmap.containsKey("UBER"))
        {
            listofImages[index]= R.drawable.uber;
            index++;
        }
        if(hasmap.containsKey("TAXIFS"))
        {
            listofImages[index]= R.drawable.taxiforsure;
            index++;
        }
        return listofImages;
    }


}
