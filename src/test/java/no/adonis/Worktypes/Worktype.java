package no.adonis.Worktypes;

public class Worktype {
    private String name;
    private int sequenceno;
    private int numOrgId;
    private boolean isWork;
    private boolean isDrill;
    private boolean isRest;
    private boolean isMeal;
    private boolean isSick;
    private boolean isSideDuty;
    private boolean isWorkAndRest;
    private boolean hideInTimeclock;
    private boolean hideInManual;
    private boolean nonOT;

    public Worktype(String name, int sequenceno, int numOrgId, boolean isWork, boolean isDrill, boolean isRest,
                    boolean isMeal, boolean isSick, boolean isSideDuty, boolean isWorkAndRest,
                    boolean hideInTimeclock, boolean hideInManual, boolean nonOT) {
        this.name = name;
        this.numOrgId = numOrgId;
        this.sequenceno = sequenceno;
        this.isWork = isWork;
        this.isDrill = isDrill;
        this.isRest = isRest;
        this.isMeal = isMeal;
        this.isSick = isSick;
        this.isSideDuty = isSideDuty;
        this.isWorkAndRest = isWorkAndRest;
        this.hideInTimeclock = hideInTimeclock;
        this.hideInManual = hideInManual;
        this.nonOT = nonOT;
    }

    public String getName() { return name; }

    public int getSequenceno() { return sequenceno; }

    public int getNumOrgId() {
        return numOrgId;
    }

    public boolean isWork() {
        return isWork;
    }

    public boolean isDrill() {
        return isDrill;
    }

    public boolean isRest() {
        return isRest;
    }

    public boolean isMeal() {
        return isMeal;
    }

    public boolean isSick() {
        return isSick;
    }

    public boolean isSideDuty() {
        return isSideDuty;
    }

    public boolean isWorkAndRest() {
        return isWorkAndRest;
    }

    public boolean isHideInTimeclock() {
        return hideInTimeclock;
    }

    public boolean isHideInManual() {
        return hideInManual;
    }

    public boolean isNonOT() {
        return nonOT;
    }
}