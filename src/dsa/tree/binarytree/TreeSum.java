package dsa.tree.binarytree;

public class TreeSum {

    public static void main(String[] args) {

        TreeSum treeSum = new TreeSum();
        System.out.println(treeSum.treeSum(TreeNode.BinaryTree.getTree()));
        int max = treeSum.maximumSubTreeSum(treeSum.getTree()).first;
        System.out.println("Maximum SubTree Sum "+max); // 335
    }

    public TreeNode getTree(){
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(-30);
        TreeNode node4 = new TreeNode(40);
        TreeNode node5 = new TreeNode(-60);
        TreeNode node6 = new TreeNode(50);
        TreeNode node7 = new TreeNode(-100);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(3);
        TreeNode node10 = new TreeNode(60);
        TreeNode node11 = new TreeNode(70);
        TreeNode node12 = new TreeNode(80);


        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node3);
        node2.setRight(node4);
        node4.setLeft(node8);
        node4.setRight(node9);
        node3.setLeft(node6);
        node3.setRight(node7);
        node6.setLeft(node10);
        node6.setRight(node11);
        node11.setLeft(node12);

        return node1;

    }

    public int treeSum(TreeNode node){

        if (node == null)
            return 0;

        int leftSum = treeSum(node.getLeft());
        int rightSum = treeSum(node.getRight());
        return leftSum+rightSum+node.getVal();
    }


    public Pair maximumSubTreeSum(TreeNode node){
        if (node == null)
            return new Pair(0,0); // MaxSum, Tree Sum

        Pair leftPair = maximumSubTreeSum(node.getLeft());
        Pair rightPair = maximumSubTreeSum(node.getRight());
        int subTreeSum = leftPair.second + rightPair.second + node.getVal();
        int maxTreeSum = Math.max(subTreeSum,Math.max(leftPair.first, rightPair.first));
        return new Pair(maxTreeSum,subTreeSum);
    }

}
