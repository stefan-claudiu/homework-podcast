package tests;

import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Cerinta6Test extends ExtractData {

    //Calculeaza si printeaza doar emisiunile de podcast difuzate saptamanal precum si ziua si ora la care aceste emisiuni sunt difuzate folosind originalEventTime

    @Test
    public void cerinta6() {

        Map<String, List<Long>> showsAndTime = getShowsAndEventTime();
        ArrayList<String> testResults = new ArrayList<>();
        System.out.println("Weekly shows are:");
        System.out.println();
        // Analyze the podcast data
        for (Map.Entry<String, List<Long>> entry : showsAndTime.entrySet()) {
            String podcastName = entry.getKey(); List<Long> timestamps = entry.getValue();
            List<LocalDateTime> dates = timestamps.stream() .map(ts -> LocalDateTime.ofInstant(Instant.ofEpochMilli(ts), ZoneOffset.of("+00:00"))) .collect(Collectors.toList());
            // Check if all dates are on the same day of the week and hour
            boolean isWeekly = dates.stream()
                    .map(date -> Map.entry(date.getDayOfWeek(), date.getHour()))
                    .distinct()
                    .count() == 1;
            if (isWeekly) {
                LocalDateTime sampleDate = dates.get(0);
                DayOfWeek dayOfWeek = sampleDate.getDayOfWeek();
                int hour = sampleDate.getHour();
                String testResult = podcastName + " - "+dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)+" "+hour + ":00";
                System.out.println(testResult);
                testResults.add(testResult);
            } else {
               // System.out.println(podcastName + " is not a weekly podcast.");
            }
        }
        for(int i=0; i<testResults.size(); i++) {
            if(i==0) Assert.assertEquals("Crime Junkie - Wed 22:00",testResults.get(i));
            else if(i==1) Assert.assertEquals("Who Trolled Amber - Mon 20:00",testResults.get(i));
            else Assert.fail();
        }
    }
}
