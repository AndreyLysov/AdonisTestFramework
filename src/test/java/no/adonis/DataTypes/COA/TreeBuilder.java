package no.adonis.DataTypes.COA;

import no.adonis.DataTypes.COA.Nodes.*;
import no.adonis.DataTypes.COA.Repository.INodesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeBuilder {
    private RootNode root;
    public TreeBuilder(INodesRepository data) {
        root = new RootNode();
        vessels = data.getVesselsNode();
        chains = data.getChainsNode();
        members= data.getMembersNode();
    }

    private ArrayList<VesselNode> vessels;
    public TreeBuilder Append(VesselNode node){
        vessels.add(node);
        return this;
    }

    private ArrayList<ChainNode> chains;
    public TreeBuilder Append(ChainNode node){
        chains.add(node);
        return this;
    }

    private ArrayList<MemberNode> members;
    public TreeBuilder Append(MemberNode node){
        members.add(node);
        return this;
    }

    public RootNode Build(){
        for (VesselNode vessel : vessels) {
            setDocumentsForVessel(vessel);
            for(NodeBase document: vessel.getKids().GetAll()){
                setChainsForDocument(vessel, ((DocumentNode) document));
                for(NodeBase chain: document.getKids().GetAll()){
                    setApproversForChains((ChainNode)chain);
                    for(NodeBase level: chain.getKids().GetAll()){
                        setMember((MemberNode)level, getKidsCollect(level.getId()));
                    }
                }
            }
            vessel.setParent(root);
            root.getKids().Append(vessel);
        }
        return root;
    }

    private void setMember(MemberNode level, List<MemberNode> kids) {
        for (MemberNode member: kids) {
            member.setParent(level);
            level.getKids().Append(member);
            setMember(member, getKidsCollect(member.getId()));
        }
    }

    private List<MemberNode> getKidsCollect(int id) {
        return members.stream()
                .filter(c -> c.getParentId() == id)
                .collect(Collectors.toList());
    }

    private void setApproversForChains(ChainNode chain) {
        for (MemberNode member: getKidsCollect(chain.getId())) {
            member.setParent(chain);
            chain.getKids().Append(member);
        }
    }

    private void setChainsForDocument(VesselNode vessel, DocumentNode document) {
        for (ChainNode chain: chains.stream()
                        .filter(c -> c.getVesselId() == vessel.getNumorgId() &&
                                c.getDocumentCode() == document.getCode())
                        .collect(Collectors.toList())) {
            chain.setParent(document);
            document.getKids().Append(chain);
        }
    }

    private void setDocumentsForVessel(VesselNode vessel) {
        DocumentNode taa = new DocumentNode();
        taa.setParent(vessel);
        taa.setCode(DocumentsCode.TAA());

/*        DocumentNode te = new DocumentNode(root);
        te.setCode(DocumentsCode.TE());
        vessel.getKids().Append(te);
        */

        vessel.getKids().Append(taa);
    }
}
