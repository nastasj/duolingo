package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchUsersResponseModel {
    int totalResults;
    Users[] users;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Users {
        String contextString, learningLanguage, name, picture, username, subscriptionItemType;
        int id, totalXP;
        Boolean hasSubscription, isVerified;
    }
}
