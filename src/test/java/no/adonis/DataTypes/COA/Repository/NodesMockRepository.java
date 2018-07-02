package no.adonis.DataTypes.COA.Repository;

import no.adonis.DataTypes.COA.*;
import no.adonis.DataTypes.COA.Nodes.ChainNode;
import no.adonis.DataTypes.COA.Nodes.DocumentsCode;
import no.adonis.DataTypes.COA.Nodes.MemberNode;
import no.adonis.DataTypes.COA.Nodes.VesselNode;

import java.util.ArrayList;

public class NodesMockRepository implements INodesRepository {
    @Override
    public ArrayList<ChainNode> getChainsNode() {
        ChainNode chain = new ChainNode();
        chain.setVesselId(1000);
        chain.setId(1001);
        chain.setDocumentCode(DocumentsCode.TAA());

        ArrayList<ChainNode> array = new ArrayList<>();
        array.add(chain);
        return array;
    }

    @Override
    public ArrayList<VesselNode> getVesselsNode() {
        VesselNode vessel = new VesselNode();
        vessel.setNumorgId(1000);
        vessel.setOrgType(OrganizationType.Vessel);

        ArrayList<VesselNode> array = new ArrayList<>();
        array.add(vessel);
        return array;
    }

    @Override
    public ArrayList<MemberNode> getMembersNode() {
        MemberNode approver = new MemberNode(1001);
        approver.setApprover();
        approver.setId(1002);
        approver.setPositionNumorgId(900);
        approver.setVesselId(1000);
        approver.setDocumentCode(DocumentsCode.TAA());
        approver.setChainId(1001);

        MemberNode subordinate = new MemberNode(1002);
        subordinate.setId(1003);
        subordinate.setVesselId(1000);
        subordinate.setDocumentCode(DocumentsCode.TAA());
        subordinate.setChainId(1001);
        subordinate.setSubordinate();
        subordinate.setPanelPC();
        subordinate.setPositionNumorgId(900);

        ArrayList<MemberNode> array = new ArrayList<>();
        array.add(approver);
        array.add(subordinate);
        return array;
    }
}
