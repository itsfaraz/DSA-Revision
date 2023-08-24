package dsa.customdatastructure.tree;

import com.sun.source.tree.Tree;
import dsa.tree.binarytree.TreeNode;

public class BST {

    private TreeNode root;
    public BST(int []inOrder){
        this.root = construct(inOrder,0,inOrder.length-1);
    }

    private TreeNode construct(int []values,int start,int end){
        if (start < 0 || start > end)
            return null;


        int mid = (start + (end-start)/2);
        TreeNode node = new TreeNode(values[mid]);
        node.setLeft(construct(values,start,mid-1));
        node.setRight(construct(values,mid+1,end));
        return node;
    }

    public TreeNode getRoot(){
        return this.root;
    }

    public int max(){
        return max(root).getVal();
    }

    private TreeNode max(TreeNode node){
        if (node.getRight() == null)
            return node;
        return max(node.getRight());
    }

    public int find(int value){
        return find(root,value).getVal();
    }

    private TreeNode find(TreeNode node,int value){
//        if (node == null)
//            return null;
//        int nodeValue = node.getVal();
//        if (nodeValue == value)
//            return node;
//        if (node.getLeft() != null && value < nodeValue)
//            find(node.getLeft(),value);
//        if (node.getRight() != null && value > nodeValue)
//            find(node.getRight(),value);
        return node;
    }
}
