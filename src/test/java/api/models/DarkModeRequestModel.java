package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DarkModeRequestModel {
    int generation_id;
    Entries[] entries;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entries {
        String key, value;
        int dirtyValue, version;

    }
}