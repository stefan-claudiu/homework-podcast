package models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Zone {

    @JsonProperty("id")
    private int id;
    @JsonProperty("maxAds")
    private int maxAds;
    @JsonProperty("maxDuration")
    private int maxDuration;

    public int getId() { return id; }
    public int getMaxAds() { return maxAds; }
    public int getMaxDuration() { return maxDuration; }

}
