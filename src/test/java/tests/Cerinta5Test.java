package tests;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;

public class Cerinta5Test extends ExtractData {

    //Calculeaza si printeaza cate oportunitati de a insera o reclama in preroll au existat pentru fiecare emisiune de podcast in ordinea descrescatoare a numarului de oportunitati.

    @Test
    public void cerinta5() {

        List<String> listOfPrerollShows = getListOfPrerollShows();
        //HashMap to count the occurrences of each string
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String title : listOfPrerollShows) {
            frequencyMap.put(title, frequencyMap.getOrDefault(title, 0) + 1);
        }
        // Convert the map to a list of entries and sort descending by value (number of occurrences)
        List<Map.Entry<String, Integer>> sortedList = frequencyMap.entrySet() .stream() .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) .collect(Collectors.toList());
        // Print the results
        int i=0;
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ", Preroll Opportunity Number: " + entry.getValue());
            long resultValue = entry.getValue();
            switch (i) {
                case 0: {
                    Assert.assertEquals("Stuff You Should Know",entry.getKey());
                    Assert.assertEquals(40,resultValue);
                }
                    break;
                case 1: {
                    Assert.assertEquals("Who Trolled Amber",entry.getKey());
                    Assert.assertEquals(40,resultValue);
                }
                break;
                case 2: {
                    Assert.assertEquals("Crime Junkie",entry.getKey());
                    Assert.assertEquals(30,resultValue);
                }
                break;
                case 3: {
                    Assert.assertEquals("The Joe Rogan Experience",entry.getKey());
                    Assert.assertEquals(10,resultValue);
                }
                break;
                case 4:
                    Assert.fail();
            }
            i++;
        }
    }
}
