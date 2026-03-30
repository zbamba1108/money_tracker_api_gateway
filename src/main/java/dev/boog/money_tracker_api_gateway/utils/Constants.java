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
        public static final String USER_ID = "X-User-ID";
        public static final String API_KEY = "X-Api-Key";
    }

    public static class Tokens {
        public static final String BEARER = "Bearer ";
        public static final String REFRESH_TOKEN = "refresh_token";
    }

    public static class Services {
        public static final String AUTH_SERVICE = "auth-service";
        public static final String DATA_SERVICE = "data-service";
        public static final String AUTH_SERVICE_BASE_PATH = "/authentication";
        public static final String DATA_SERVICE_BASE_PATH = "/data";
        public static final String AUTH_SERVICE_REDIRECT_BASE_PATH = "/api/auth/";
        public static final String DATA_SERVICE_REDIRECT_BASE_PATH = "/api/data/";
    }

    public static class Tags {

        public static final String AUTH_SERVICE = "Auth Service";

        public static final String DATA_SERVICE = "Data Service";
        public static final String WALLET_API = "Wallet API";
        public static final String TRANSACTION_API = "Transaction API";
        public static final String CATEGORY_API = "Category API";
        public static final String BUDGET_API = "Budget API";
    }

    public static class Secrets {
        public static final String CLIENT = "secretlongenoughtobearealsecretwithadditionalcharactershopingnowislongenough"; // TODO replace with ENV_VARIABLE
        public static final String INTERNAL = "api-gateway_secret";
    }

    public static class Hosts {
        public static final String DATA_SERVICE_HOST = "http://localhost:8081";
        public static final String AUTH_SERVICE_HOST = "http://localhost:8082";
    }
}
