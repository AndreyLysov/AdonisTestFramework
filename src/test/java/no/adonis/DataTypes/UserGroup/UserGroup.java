package no.adonis.DataTypes.UserGroup;

public class UserGroup {

    private int sequenceno;
    private String name;
    private static int counter = 0;

    public UserGroup(String name) {
        this.sequenceno = counter++;
        this.name = name;
    }

    public int getSequenceno() {
        return sequenceno;
    }

    public String getName() {
        return name;
    }
}
