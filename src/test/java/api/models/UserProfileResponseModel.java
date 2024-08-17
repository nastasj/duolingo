package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileResponseModel {
    Boolean canFollow, isFollowedBy, isFollowing, isVerified;
    Followers followers;
    Following following;
    FriendsInCommon friendsInCommon;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Followers {
        String cursor;
        int totalUsers;
        Users[] users;

        @Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Users {
            String displayName, picture, subscriptionItemType, username;
            int totalXp, userId;
            Boolean canFollow, hasSubscription, isCurrentlyActive, isFollowedBy, isFollowing, isVerified;
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Following {
        String cursor;
        int totalUsers;
        Users[] users;

        @Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Users {
            String displayName, picture, subscriptionItemType, username;
            int totalXp, userId;
            Boolean canFollow, hasSubscription, isCurrentlyActive, isFollowedBy, isFollowing, isVerified;
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FriendsInCommon {
        String cursor;
        int totalUsers;
        Users[] users;

        @Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Users {
            String displayName, picture, subscriptionItemType, username;
            int totalXp, userId;
            Boolean canFollow, hasSubscription, isCurrentlyActive, isFollowedBy, isFollowing, isVerified;
        }
    }
}
