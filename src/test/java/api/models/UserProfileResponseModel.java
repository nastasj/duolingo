package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileResponseModel {
    private Boolean canFollow, isFollowedBy, isFollowing, isVerified;
    private Followers followers;
    private Following following;
    private FriendsInCommon friendsInCommon;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Followers {
        private String cursor;
        private int totalUsers;
        private Users[] users;

        @Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Users {
            private String displayName, picture, subscriptionItemType, username;
            private int totalXp, userId;
            private Boolean canFollow, hasSubscription, isCurrentlyActive, isFollowedBy, isFollowing, isVerified;
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Following {
        private String cursor;
        private int totalUsers;
        private Users[] users;

        @Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Users {
            private String displayName, picture, subscriptionItemType, username;
            private int totalXp, userId;
            private Boolean canFollow, hasSubscription, isCurrentlyActive, isFollowedBy, isFollowing, isVerified;
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FriendsInCommon {
        private String cursor;
        private int totalUsers;
        private Users[] users;

        @Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Users {
            private String displayName, picture, subscriptionItemType, username;
            private int totalXp, userId;
            private Boolean canFollow, hasSubscription, isCurrentlyActive, isFollowedBy, isFollowing, isVerified;
        }
    }
}
