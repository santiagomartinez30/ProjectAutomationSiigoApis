package co.com.reqres.enums;

public enum EndPoints {

    CONSULT_USER_FOR_ID("/api/users/");

    private final String value;

    EndPoints(String value) {
        this.value = value;
    }

    public String resource() {
        return value;
    }
}
