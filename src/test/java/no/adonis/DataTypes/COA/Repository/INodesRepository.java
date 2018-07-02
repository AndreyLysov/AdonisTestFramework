package no.adonis.DataTypes.COA.Repository;

import no.adonis.DataTypes.COA.Nodes.ChainNode;
import no.adonis.DataTypes.COA.Nodes.MemberNode;
import no.adonis.DataTypes.COA.Nodes.VesselNode;

import java.util.ArrayList;

public interface INodesRepository {
    ArrayList<ChainNode> getChainsNode();
    ArrayList<VesselNode> getVesselsNode();
    ArrayList<MemberNode> getMembersNode();
}
