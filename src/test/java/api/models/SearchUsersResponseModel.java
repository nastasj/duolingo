package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchUsersResponseModel {
    private int totalResults;
    private Users[] users;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Users {
        private String contextString, learningLanguage, name, picture, username, subscriptionItemType;
        private int id, totalXP;
        private Boolean hasSubscription, isVerified;
    }
}
