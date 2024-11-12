package tests;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class Cerinta3Test extends ExtractData {

    //Calculeaza si printeaza care este emisiunea de podcast (aceasta este identificata prin showId) cea mai ascultata (cea cu cele mai multe download-uri)
    // din San Francisco precum si numarul de download-uri asociat acestei emisiuni.

    @Test
    public void cerinta3()  {

        String cityName="san francisco";
        Set<String> set = new HashSet<>(getListOfShowsPerCity(cityName));
        List<String> distinctList = new ArrayList<>(set);
        //System.out.println(distinctList);
        HashMap<Integer, String> result = new HashMap<>();
        int max=0;
        for(int i=0;i<distinctList.size();i++) {

            int occurrences = Collections.frequency(getListOfShowsPerCity(cityName), distinctList.get(i));
            //System.out.println(distinctList.get(i)+" "+occurrences);
            result.put(occurrences,distinctList.get(i));
            max=Math.max(max, occurrences);
        }
        System.out.println();
        System.out.println("Most popular show is: "+result.get(max));
        System.out.println("Number of downloads is: "+max);
        Assert.assertEquals("Who Trolled Amber",result.get(max));
        Assert.assertEquals(24,max);
    }
}
