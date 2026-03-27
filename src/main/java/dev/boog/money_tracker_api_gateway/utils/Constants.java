package dev.boog.money_tracker_api_gateway.utils;

public class Constants {

    public static class Messages {

        public static final String UTILITY_CLASS = "Utility class!";
        public static final String DOCS_METHOD = "This method is used only for documentation";
    }

    public static class Profile {
        public static final String DOCS = "docs";
    }

    public static class Headers {
        public static final String USER_ID = "User-ID";
        public static final String ACCESS_TOKEN = "Access-Token";
        public static final String REFRESH_TOKEN = "Refresh-Token";
    }

    public static class Token {
        public static final String BEARER = "Bearer ";
    }

    public static class Tags {

        public static final String AUTH_SERVICE = "Auth Service";
        public static final String USER_API = "User API";
        public static final String AUTH_API = "Auth API";

        public static final String DATA_SERVICE = "Data Service";
        public static final String WALLET_API = "Wallet API";
        public static final String TRANSACTION_API = "Transaction API";
        public static final String CATEGORY_API = "Category API";
        public static final String BUDGET_API = "Budget API";
    }

    public static final String SECRET = "secretlongenoughtobearealsecretwithadditionalcharactershopingnowislongenough"; // TODO replace with ENV_VARIABLE
}
