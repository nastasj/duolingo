package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailReminderRequestResponseModel {
    private String userID, username;
    private PracticeReminderSettings practiceReminderSettings;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PracticeReminderSettings {
        private En en;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class En {
            private int timeInMinutes;
            private Boolean useSmartReminderTime, emailEnabled, pushEnabled;
        }
    }
}