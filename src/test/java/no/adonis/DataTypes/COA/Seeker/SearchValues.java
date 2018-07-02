package no.adonis.DataTypes.COA.Seeker;

import java.util.ArrayList;

public class SearchValues {
    public SearchValues() {
        this.searchConditions = new ArrayList<>();
    }

    public boolean isApprover() {
        return isApprover;
    }

    public void setApprover(boolean approver) {
        if (!searchConditions.contains(SearchConditions.byIsApprover))
            searchConditions.add(SearchConditions.byIsApprover);
        isApprover = approver;
    }

    public boolean isCoordinator() {
        return isCoordinator;
    }

    public void setCoordinator(boolean coordinator) {
        if (!searchConditions.contains(SearchConditions.byIsCoordinator))
            searchConditions.add(SearchConditions.byIsCoordinator);
        isCoordinator = coordinator;
    }

    public boolean isSubordinate() {
        return isSubordinate;
    }

    public void setSubordinate(boolean subordinate) {
        if (!searchConditions.contains(SearchConditions.byIsSubordinate))
            searchConditions.add(SearchConditions.byIsSubordinate);
        isSubordinate = subordinate;
    }

    public boolean isPanelPC() {
        return isPanelPC;
    }

    public void setPanelPC(boolean panelPC) {
        if (!searchConditions.contains(SearchConditions.byIsPanelPC))
            searchConditions.add(SearchConditions.byIsPanelPC);
        isPanelPC = panelPC;
    }

    public int getClientNumorgId() {
        return clientNumorgId;
    }

    public void setClientNumorgId(int clientNumorgId) {
        if (!searchConditions.contains(SearchConditions.byClientNumorgId))
            searchConditions.add(SearchConditions.byClientNumorgId);
        this.clientNumorgId = clientNumorgId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        if (!searchConditions.contains(SearchConditions.byPin))
            searchConditions.add(SearchConditions.byPin);
        this.pin = pin;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (!searchConditions.contains(SearchConditions.byRank))
            searchConditions.add(SearchConditions.byRank);
        this.rank = rank;
    }

    public int getPositionNumorgId() {
        return positionNumorgId;
    }

    public void setPositionNumorgId(int positionNumorgId) {
        if (!searchConditions.contains(SearchConditions.byPositionNumorgId))
            searchConditions.add(SearchConditions.byPositionNumorgId);
        this.positionNumorgId = positionNumorgId;
    }

    public int getChainId() {
        return chainId;
    }

    public void setChainId(int chainId) {
        if (!searchConditions.contains(SearchConditions.byChainId))
            searchConditions.add(SearchConditions.byChainId);
        this.chainId = chainId;
    }

    public int getVesselId() {
        return vesselId;
    }

    public void setVesselId(int vesselId) {
        if (!searchConditions.contains(SearchConditions.byVesselId))
            searchConditions.add(SearchConditions.byVesselId);
        this.vesselId = vesselId;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        if (!searchConditions.contains(SearchConditions.byDocumentCode))
            searchConditions.add(SearchConditions.byDocumentCode);
        this.documentCode = documentCode;
    }

    private boolean isApprover;
    private boolean isCoordinator;
    private boolean isSubordinate;
    private boolean isPanelPC;

    private int clientNumorgId;
    private int pin;
    private int rank;
    private int positionNumorgId;

    private int chainId;
    private int vesselId;
    private String documentCode;

    public ArrayList<SearchConditions> getSearchConditions() {
        return searchConditions;
    }

    private ArrayList<SearchConditions> searchConditions;
}
