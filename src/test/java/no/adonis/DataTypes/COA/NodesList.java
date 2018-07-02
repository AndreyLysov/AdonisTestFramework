package no.adonis.DataTypes.COA;

import no.adonis.DataTypes.COA.Nodes.NodeBase;

import java.util.ArrayList;
import java.util.List;

public class NodesList {

    private ArrayList<NodeBase> list;
    public NodesList(){
        list = new ArrayList<>();
    }

    public void Append(NodeBase node){
        list.add(node);
    }

    public void Remove(NodeBase node){
        list.remove(node);
    }

    public void Clear(){
        list.clear();
    }

    public List<NodeBase> GetAll(){
        return list;
    }
}
