package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DarkModeResponseModel {
    private Entries[] entries;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entries {
        private String key, value;
        private int version;
    }
}