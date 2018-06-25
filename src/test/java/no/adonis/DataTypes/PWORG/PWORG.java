package no.adonis.DataTypes.PWORG;

public class PWORG {

    private String name;
    private int numorgId;
    private String orgCode;
    private int orgType;

    public PWORG(String name, int numorgId, String orgCode, int orgType) {
        this.name = name;
        this.numorgId = numorgId;
        this.orgCode = orgCode;
        this.orgType = orgType;
    }

    public String getName() {
        return name;
    }

    public int getNumorgId() {

        return numorgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public int getOrgType() {
        return orgType;
    }
}
