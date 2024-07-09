package roadmap.dsa.tree.binarytree;

public class Diameter {

    public static void main(String[] args) {
        int diameter = new Diameter().diameterOfBinaryTree(TreeNode.BinaryTree.getTree()).second;
        System.out.println(diameter);
    }

    public Pair diameterOfBinaryTree(TreeNode node) {
        if (node == null)
            return new Pair(-1,0);

        Pair leftPair = diameterOfBinaryTree(node.getLeft());
        Pair rightPair = diameterOfBinaryTree(node.getRight());
        int first = Math.max(leftPair.first , rightPair.first)+1;
        int second = (leftPair.first + leftPair.first) + 2;
        return new Pair(first,second);
    }

    public int diameterOfBinaryTreeV1(TreeNode root) {
        if (root == null)
            return 0;


        int leftDiameter = diameterOfBinaryTreeV1(root.getLeft()) ;
        int rightDiameter = diameterOfBinaryTreeV1(root.getRight());


        int leftMax = treeHeight(root.getLeft());
        int rightMax = treeHeight(root.getRight());

        return (Math.max(leftDiameter,rightDiameter))+leftMax + rightMax + 2 ;
    }

    public int treeHeight(TreeNode node){
        if (node == null)
            return -1;

        int left = treeHeight(node.getLeft());
        int right = treeHeight(node.getRight());
        return Math.max(left,right)+1;
    }
}
