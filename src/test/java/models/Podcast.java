package models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Podcast {

    @JsonProperty("downloadIdentifier")
    private DownloadIdentifier downloadIdentifier;
    @JsonProperty("opportunities")
    private List<Opportunity> opportunities;
    @JsonProperty("agency")
    private int agency;
    @JsonProperty("deviceType")
    private String deviceType;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("listenerId")
    private String listenerId;

    public DownloadIdentifier getDownloadIdentifier() { return downloadIdentifier; }
    public List<Opportunity> getOpportunities() { return opportunities; }
    public int getAgency() { return agency; }
    public String getDeviceType() { return deviceType; }
    public String getCountry() { return country; }
    public String getCity() { return city; }
    public String getListenerId() { return listenerId; }

}
