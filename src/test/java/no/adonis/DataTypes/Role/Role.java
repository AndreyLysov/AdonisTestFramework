package no.adonis.DataTypes.Role;

public class Role {
    private static int count = 0;
    private int sequenceno;
    private String name;

    public Role(String name) {
        this.sequenceno = count++;
        this.name = name;
    }

    public int getSequenceno() {
        return sequenceno;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "sequenceno=" + sequenceno +
                ", name='" + name + '\'' +
                '}';
    }
}
