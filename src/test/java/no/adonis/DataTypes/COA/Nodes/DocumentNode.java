package no.adonis.DataTypes.COA.Nodes;

public class DocumentNode extends NodeBase {
    public DocumentNode() {
        setLevel(2);
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
