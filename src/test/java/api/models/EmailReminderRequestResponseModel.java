package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailReminderRequestResponseModel {
    String userID, username;
    PracticeReminderSettings practiceReminderSettings;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PracticeReminderSettings {
        En en;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class En {
            int timeInMinutes;
            Boolean useSmartReminderTime, emailEnabled, pushEnabled;
        }
    }
}