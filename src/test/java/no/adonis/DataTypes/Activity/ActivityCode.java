package no.adonis.DataTypes.Activity;

public class ActivityCode {
    private String name;
    private String code;

    public ActivityCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
