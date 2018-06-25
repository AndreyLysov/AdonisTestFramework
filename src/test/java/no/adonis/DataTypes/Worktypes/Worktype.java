package no.adonis.DataTypes.Worktypes;

import no.adonis.DataTypes.PWORG.PWORG;

public class Worktype {
    private String code;
    private String name;
    private PWORG vessel;
    private boolean isWork;
    private boolean isDrill;
    private boolean isRest;
    private boolean isMeal;
    private boolean isSideDuty;
    private boolean isSick;
    private boolean isWorkAndRest;
    private boolean hideInTimeclock;
    private boolean hideInManual;
    private boolean nonOT;

    public Worktype(String name, PWORG vessel) {
        this.code = name.length() > 10 ? name.substring(0, 9) : name;
        this.name = name;
        this.vessel = vessel;
    }

    //useless constructor need to think how to work without it
    public Worktype(String code, String name, PWORG vessel, boolean isWork, boolean isDrill, boolean isRest, boolean isMeal,
                    boolean isSideDuty, boolean isSick, boolean isWorkAndRest, boolean hideInTimeclock,
                    boolean hideInManual, boolean nonOT) {
        this.code = code;
        this.name = name;
        this.vessel = vessel;
        this.isWork = isWork;
        this.isDrill = isDrill;
        this.isRest = isRest;
        this.isMeal = isMeal;
        this.isSideDuty = isSideDuty;
        this.isSick = isSick;
        this.isWorkAndRest = isWorkAndRest;
        this.hideInTimeclock = hideInTimeclock;
        this.hideInManual = hideInManual;
        this.nonOT = nonOT;
    }

    public void setWork(boolean work) {
        isWork = work;
    }

    public void setDrill(boolean drill) {
        isDrill = drill;
    }

    public void setRest(boolean rest) {
        isRest = rest;
    }

    public void setMeal(boolean meal) {
        isMeal = meal;
    }

    public void setSideDuty(boolean sideDuty) {
        isSideDuty = sideDuty;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public void setWorkAndRest(boolean workAndRest) {
        isWorkAndRest = workAndRest;
    }

    public void setHideInTimeclock(boolean hideInTimeclock) {
        this.hideInTimeclock = hideInTimeclock;
    }

    public void setHideInManual(boolean hideInManual) {
        this.hideInManual = hideInManual;
    }

    public void setNonOT(boolean nonOT) {
        this.nonOT = nonOT;
    }

    public String getCode() { return code; }

    public String getName() { return name; }

    public PWORG getVessel() {
        return vessel;
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

    @Override
    public String toString() {
        return "Worktype{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", vessel=" + vessel +
                ", isWork=" + isWork +
                ", isDrill=" + isDrill +
                ", isRest=" + isRest +
                ", isMeal=" + isMeal +
                ", isSideDuty=" + isSideDuty +
                ", isSick=" + isSick +
                ", isWorkAndRest=" + isWorkAndRest +
                ", hideInTimeclock=" + hideInTimeclock +
                ", hideInManual=" + hideInManual +
                ", nonOT=" + nonOT +
                '}';
    }
}