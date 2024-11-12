package tests;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Cerinta4Test extends ExtractData {

    //Calculeaza si printeaza care este device-ul (aceasta este identificat prin deviceType; eg. desktops & laptops, mobiles & tablets, smart speakers, digital appliances) cel mai folosit pentru a asculta podcast-uri precum si numarul de download-uri asociat acestui device.

    @Test
    public void cerinta4() {
        Set<String> set = new HashSet<>(getListOfDevices());
        List<String> distinctList = new ArrayList<>(set);
        //System.out.println(distinctList);
        HashMap<Integer, String> result = new HashMap<>();
        int max = 0;
        for (int i = 0; i < distinctList.size(); i++) {

            int occurrences = Collections.frequency(getListOfDevices(), distinctList.get(i));
            result.put(occurrences, distinctList.get(i));
            max = Math.max(max, occurrences);
        }
        System.out.println("Most popular device is: "+result.get(max));
        System.out.println("Number of downloads is: "+max);
        Assert.assertEquals("mobiles & tablets",result.get(max));
        Assert.assertEquals(60,max);
    }
}
