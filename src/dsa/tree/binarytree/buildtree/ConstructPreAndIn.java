package dsa.tree.binarytree.buildtree;

import dsa.tree.binarytree.Pair;
import dsa.tree.binarytree.TreeNode;

// Construct tree from pre-order and in-order traversal
public class ConstructPreAndIn {

    public static void main(String[] args) {
        int []preOrder = {10,20,40,50,30,70};
        int []inOrder = {40,20,50,10,30,70};
        TreeNode node = new ConstructPreAndIn().buildTree(preOrder,inOrder);
        System.out.println(node);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder,inorder,0, preorder.length-1,0,inorder.length-1);
    }


    private TreeNode construct(int[]preOrder,int[] inOrder,int preLow,int preHigh,int inLow,int inHigh){

        if (preLow > preHigh || inLow > inHigh){
            return null;
        }



        TreeNode node = new TreeNode(preOrder[preLow]);
        Pair pair = findTreeNode(preOrder[preLow],inOrder,inLow,inHigh);
        int midIdx = pair.first;
        int noOfElements = pair.second;
        node.setLeft(construct(preOrder,inOrder,preLow+1,preLow+noOfElements,inLow,midIdx-1));
        node.setRight(construct(preOrder, inOrder, preLow+noOfElements+1,preHigh,midIdx+1,inHigh));
        return node;
    }

    private Pair findTreeNode(int ele, int[]inOrder, int start, int end){
        int midIdx = -1;
        int prevElements = 0;
        for (int i = start; i <= end; i++){
            if (inOrder[i] == ele) {
                midIdx = i;
                break;
            }
            prevElements++;
        }
        return new Pair(midIdx,prevElements);
    }

}
