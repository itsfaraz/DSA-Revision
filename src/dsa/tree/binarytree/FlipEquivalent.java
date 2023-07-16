package dsa.tree.binarytree;

public class FlipEquivalent {
    
    public boolean flipEquivalent(TreeNode node1, TreeNode node2){

        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        if (node1.getVal() != node2.getVal())
            return false;


        boolean flip = flipEquivalent(node1.getLeft(),node2.getRight()) && flipEquivalent(node1.getRight(),node2.getLeft());
        if (flip)
            return true;
        boolean noFlip = flipEquivalent(node1.getLeft(),node2.getLeft()) && flipEquivalent(node1.getRight(),node2.getRight());

        return flip || noFlip;
    }
    
}
