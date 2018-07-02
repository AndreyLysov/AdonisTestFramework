package no.adonis.DataTypes.COA.Nodes;

public class MemberNode extends NodeBase {

    private int parentId;

    private int clientNumorgId;
    private int pin;
    private int rank;
    private int positionNumorgId;

    public int getChainId() {
        return chainId;
    }

    public void setChainId(int chainId) {
        this.chainId = chainId;
    }

    public int getVesselId() {
        return vesselId;
    }

    public void setVesselId(int vesselId) {
        this.vesselId = vesselId;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    private int chainId;
    private int vesselId;
    private String documentCode;

    private boolean isApprover;
    private boolean isCoordinator;
    private boolean isSubordinate;
    private boolean isPanelPC;

    public MemberNode(int parentId) {
        this.parentId = parentId;
    }

    public int getClientNumorgId() {
        return clientNumorgId;
    }

    public void setClientNumorgId(int clientNumorgId) {
        this.clientNumorgId = clientNumorgId;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPositionNumorgId(int positionNumorgId) {
        this.positionNumorgId = positionNumorgId;
    }

    public void setApprover() {
        this.isApprover = true;
    }

    public void setCoordinator() {
        this.isCoordinator = true;
    }

    public void setSubordinate() {
        this.isSubordinate = true;
    }

    public void setPanelPC() {
        this.isPanelPC = true;
    }

    public int getParentId() {
        return parentId;
    }

    public int getOfficeNumorgId() {
        return clientNumorgId;
    }

    public int getPin() {
        return pin;
    }

    public int getRank() {
        return rank;
    }

    public int getPositionNumorgId() {
        return positionNumorgId;
    }

    public boolean isApprover() {
        return isApprover;
    }

    public boolean isCoordinator() {
        return isCoordinator;
    }

    public boolean isSubordinate() {
        return isSubordinate;
    }

    public boolean isPanelPC() {
        return isPanelPC;
    }

    @Override
    public String toString() {
        return "MemberNode{" +
                "parentId=" + parentId +
                ", clientNumorgId=" + clientNumorgId +
                ", pin=" + pin +
                ", rank=" + rank +
                ", positionNumorgId=" + positionNumorgId +
                ", isApprover=" + isApprover +
                ", isCoordinator=" + isCoordinator +
                ", isSubordinate=" + isSubordinate +
                ", isPanelPC=" + isPanelPC +
                "} ";
    }
}
