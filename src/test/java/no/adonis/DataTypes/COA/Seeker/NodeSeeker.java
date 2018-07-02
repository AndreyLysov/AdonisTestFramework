package no.adonis.DataTypes.COA.Seeker;

import no.adonis.DataTypes.COA.Nodes.MemberNode;
import no.adonis.DataTypes.COA.Nodes.NodeBase;

public class NodeSeeker {
    public static MemberNode Search(NodeBase node, SearchValues toCompare) {
        if (node instanceof  MemberNode && compare((MemberNode) node, toCompare)) {
            return (MemberNode) node;
        }
        for (NodeBase kid : node.getKids().GetAll()) {
            return Search(kid, toCompare);
        }
        return null;
    }

    private static boolean compare(MemberNode node, SearchValues toCompare) {
        boolean result = true;
        if (toCompare.getSearchConditions().contains(SearchConditions.byIsApprover)) {
            result = result && node.isApprover() == toCompare.isApprover();
        }
        if (toCompare.getSearchConditions().contains(SearchConditions.byIsCoordinator)) {
            result = result && node.isCoordinator() == toCompare.isCoordinator();
        }
        if (toCompare.getSearchConditions().contains(SearchConditions.byIsSubordinate)) {
            result = result && node.isSubordinate() == toCompare.isSubordinate();
        }
        if (toCompare.getSearchConditions().contains(SearchConditions.byIsPanelPC)) {
            result = result && node.isPanelPC() == toCompare.isPanelPC();
        }
        if (toCompare.getSearchConditions().contains(SearchConditions.byPositionNumorgId)) {
            result = result && node.getPositionNumorgId() == toCompare.getPositionNumorgId();
        }
        if (toCompare.getSearchConditions().contains(SearchConditions.byRank)) {
            result = result && node.getRank() == toCompare.getRank();
        }
        if (toCompare.getSearchConditions().contains(SearchConditions.byClientNumorgId)) {
            result = result && node.getClientNumorgId() == toCompare.getClientNumorgId();
        }
        if (toCompare.getSearchConditions().contains(SearchConditions.byChainId)) {
            result = result && node.getChainId() == toCompare.getChainId();
        }
        if (toCompare.getSearchConditions().contains(SearchConditions.byVesselId)) {
            result = result && node.getVesselId() == toCompare.getVesselId();
        }
        if (toCompare.getSearchConditions().contains(SearchConditions.byDocumentCode)) {
            result = result && node.getDocumentCode() == toCompare.getDocumentCode();
        }

        return result;
    }
}
