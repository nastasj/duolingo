package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DarkModeRequestModel {

    @JsonProperty("generation_id")
    private int generationId;

    private Entries[] entries;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entries {
        private String key, value;
        private int dirtyValue, version;
    }
}