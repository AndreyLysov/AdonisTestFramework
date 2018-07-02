package no.adonis.DataTypes.COA.Nodes;

import no.adonis.DataTypes.COA.NodesList;

public abstract class NodeBase {
    private int id;
    private String Description;
    private NodeBase Parent;

    public NodeBase() {
        this.kids = new NodesList();
    }

    public NodesList getKids() {
        return kids;
    }

    public void setKids(NodesList kids) {
        this.kids = kids;
    }

    private NodesList kids;
    private int Level;
    private boolean IsPassive;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public NodeBase getParent() {
        return Parent;
    }

    public void setParent(NodeBase parent) {
        Parent = parent;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public boolean isPassive() {
        return IsPassive;
    }

    public void setPassive(boolean passive) {
        IsPassive = passive;
    }
}
