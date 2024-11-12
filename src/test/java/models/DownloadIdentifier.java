package models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DownloadIdentifier {

    @JsonProperty("client")
    private String client;
    @JsonProperty("publisher")
    private int publisher;
    @JsonProperty("podcastId")
    private String podcastId;
    @JsonProperty("showId")
    private String showId;
    @JsonProperty("episodeId")
    private String episodeId;
    @JsonProperty("downloadId")
    private String downloadId;

    public String getClient() { return client; }
    public int getPublisher() { return publisher; }
    public String getPodcastId() { return podcastId; }
    public String getShowId() { return showId; }
    public String getEpisodeId() { return episodeId; }
    public String getDownloadId() { return downloadId; }

}
