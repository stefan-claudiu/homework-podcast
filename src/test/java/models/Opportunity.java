package models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class Opportunity {

    @JsonProperty("originalEventTime")
    private long originalEventTime;
    @JsonProperty("maxDuration")
    private int maxDuration;
    @JsonProperty("zones")
    private Map<String, Zone> zones;
    @JsonProperty("positionUrlSegments")
    private Map<String, List<String>> positionUrlSegments;
    @JsonProperty("insertionRate")
    private int insertionRate;

    public long getOriginalEventTime() { return originalEventTime; }
    public int getMaxDuration() { return maxDuration; }
    public Map<String, Zone> getZones() { return zones; }
    public Map<String, List<String>> getPositionUrlSegments() { return positionUrlSegments; }
    public int getInsertionRate() { return insertionRate; }

}
