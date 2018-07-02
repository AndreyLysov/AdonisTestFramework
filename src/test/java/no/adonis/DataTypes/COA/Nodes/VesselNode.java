package no.adonis.DataTypes.COA.Nodes;

import no.adonis.DataTypes.COA.OrganizationType;

public class VesselNode extends NodeBase {
    public VesselNode() {
        setLevel(1);
    }

    public int getNumorgId() {
        return numorgId;
    }

    public void setNumorgId(int numorgId) {
        this.numorgId = numorgId;
    }

    public OrganizationType getOrgType() {
        return orgType;
    }

    public void setOrgType(OrganizationType orgType) {
        this.orgType = orgType;
    }

    private int numorgId;
    private OrganizationType orgType;
}
