package dsa.tree.binarytree;


public class BalancedBinaryTree {

    public static void main(String[] args) {
        System.out.println(new BalancedBinaryTree().isBalanced(TreeNode.BinaryTree.getBalancedTree()));
    }

    public boolean isBalanced(TreeNode root) {
         return isBalanceV2(root).isBalanced;
    }

    private class Pair{
        boolean isBalanced = true;
        int height = -1;
        public Pair(){
        }
        public Pair(boolean isBalanced,int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public Pair isBalanceV2(TreeNode node){
        if (node == null){
            return new Pair();
        }

        if (node.getLeft() == null && node.getRight() == null)
            return new Pair(true,1);

        Pair leftBalance = isBalanceV2(node.getLeft());
        Pair rightBalance = isBalanceV2(node.getRight());
        int balancingFactor = (leftBalance.height) - (rightBalance.height);
        boolean isSelfNodeBalanced = (balancingFactor == 0 || balancingFactor == -1 || balancingFactor == 1);
        boolean isBothNodeBalanced = leftBalance.isBalanced && rightBalance.isBalanced;
        return new Pair(isSelfNodeBalanced && isBothNodeBalanced,Math.max(leftBalance.height, rightBalance.height)+1);
    }

    public boolean isBalance(TreeNode node){
        if (node == null)
            return true;
        if (node.getLeft() == null && node.getRight() == null)
            return true;
        boolean isRightBalanced = isBalance(node.getRight());
        boolean isLeftBalanced = isBalance(node.getLeft());
        int leftHeight = treeHeight(node.getLeft());
        int rightHeight = treeHeight(node.getRight());
        int balancingFactor = (leftHeight)-(rightHeight);
        boolean isSelfBalanced = (balancingFactor >= 2 || balancingFactor <= -2);
        return isRightBalanced && isLeftBalanced && isSelfBalanced;
    }

    public int treeHeight(TreeNode node){
        if (node == null)
            return -1;
        int leftHeight = treeHeight(node.getLeft());
        int rightHeight = treeHeight(node.getRight());
        return Math.max(leftHeight,rightHeight)+1;
    }


}
