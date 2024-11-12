package tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Opportunity;
import models.Podcast;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class ExtractData {


    // this method is used extract data from downloads.txt into a list of json
    public List<String> parseToJsonList(String fileName) {
        List<String> jsonList = new ArrayList<>();
        File myObj = new File("./src/test/resources/" + fileName);
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            jsonList.add(data);
        }
        myReader.close();

        return jsonList;
    }

    //Cerinta 3
    public ArrayList<String> getListOfShowsPerCity(String cityName) {
        ArrayList<String> downloads = new ArrayList<>();
        //Iterator itr = jsonList.iterator();
        Iterator<String> itr = parseToJsonList("downloads.txt").iterator();
        while (itr.hasNext()) {
            String jsonString = "[" + itr.next() + "]";
            //System.out.println(jsonString);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Podcast>>() {
            }.getType();
            List<Podcast> myList = gson.fromJson(jsonString, listType);

            for (Podcast item : myList) {
                //System.out.println("ID: " + item.getDownloadIdentifier().getShowId() + ", Name: " + item.getCity());
                String showId = item.getDownloadIdentifier().getShowId();
                String city = item.getCity();
                if (city.equalsIgnoreCase(cityName)) {
                    downloads.add(showId);
                }
            }
            //break;
        }
        return downloads;
    }

    //cerinta 4
    public ArrayList<String> getListOfDevices() {
        ArrayList<String> devices = new ArrayList<>();
        Iterator<String> itr = parseToJsonList("downloads.txt").iterator();
        while (itr.hasNext()) {
            String jsonString = "[" + itr.next() + "]";
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Podcast>>() {}.getType();
            List<Podcast> myList = gson.fromJson(jsonString, listType);

            for (Podcast item : myList) {
                String device = item.getDeviceType();
                devices.add(device);
            }
        }
        return devices;
    }

    //cerinta 5
    public List<String> getListOfPrerollShows() {
        Iterator<String> itr = parseToJsonList("downloads.txt").iterator();
        List<String> showIds = new ArrayList<>();
        while (itr.hasNext()) {
            String jsonString = "[" + itr.next() + "]";
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Podcast>>() {}.getType();
            List<Podcast> myList = gson.fromJson(jsonString, listType);
            for (Podcast item : myList) {
                for (Opportunity opportunity : item.getOpportunities()) {
                    Map<String, List<String>> positionUrlSegments = opportunity.getPositionUrlSegments();
                    if (positionUrlSegments.get("aw_0_ais.adBreakIndex").contains("preroll")) {
                        showIds.add(item.getDownloadIdentifier().getShowId());
                        //System.out.println(item.getDownloadIdentifier().getShowId());
                    }
                }
            }

        }
        return showIds;
    }

    //cerinta 6
    public Map<String, List<Long>> getShowsAndEventTime() {
        Iterator<String> itr = parseToJsonList("downloads.txt").iterator();
        Map<String, List<Long>> showsAndTime = new HashMap<>();
        while (itr.hasNext()) {
            String jsonString = "[" + itr.next() + "]";
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Podcast>>() {}.getType();
            List<Podcast> myList = gson.fromJson(jsonString, listType);
            for (Podcast item : myList) {
                for (Opportunity opportunity : item.getOpportunities()) {
                    String showId = item.getDownloadIdentifier().getShowId();

                    long originalEventTime = opportunity.getOriginalEventTime();
                    LocalDateTime showTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(originalEventTime), ZoneOffset.of("+00:00"));
                    showsAndTime.computeIfAbsent(showId, k -> new ArrayList<>()).add(originalEventTime);
                    //System.out.println(showId +" - " +showTime);
                }
            }
        }
        return showsAndTime;
    }
}
