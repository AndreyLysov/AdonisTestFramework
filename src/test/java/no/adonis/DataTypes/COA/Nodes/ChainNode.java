package no.adonis.DataTypes.COA.Nodes;

public class ChainNode extends NodeBase {
    public ChainNode() {
        setLevel(3);
    }
    private int vesselId;

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    private String documentCode;

    public int getVesselId() {
        return vesselId;
    }

    public void setVesselId(int vesselId) {
        this.vesselId = vesselId;
    }
}
