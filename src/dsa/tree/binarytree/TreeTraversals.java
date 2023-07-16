package dsa.tree.binarytree;

import java.util.Stack;

public class TreeTraversals {


    public static void main(String[] args) {
        System.out.println("Inorder Traversal   : Left Node Right");
        System.out.println("PreOrder Traversal  : Node Left Right");
        System.out.println("PostOrder Traversal : Left Right Node");
        TreeTraversals traversal = new TreeTraversals();
        TreeNode rootNode = traversal.getIdealTree();
        System.out.println("-------------------------------PreOrder-----------------------------------");
        traversal.preOrderTraversal(rootNode);
        System.out.println();
        traversal.preOrderTraversalI(rootNode);
        System.out.println();
        System.out.println("--------------------------------PostOrder---------------------------------");
        traversal.postOrderTraversal(rootNode);
        System.out.println();
        traversal.postOrderTraversalI(rootNode);
        System.out.println();
        System.out.println("--------------------------------InOrder---------------------------------");
        traversal.inOrderTraversal(rootNode);
        System.out.println();
        traversal.inOrderTraversalI(rootNode);
        System.out.println();
    }

    public TreeNode getIdealTree(){
        TreeNode node1 = new TreeNode(10,null,null);
        TreeNode node2 = new TreeNode(20,null,null);
        TreeNode node3 = new TreeNode(30,null,null);
        TreeNode node4 = new TreeNode(40,null,null);
        TreeNode node5 = new TreeNode(50,null,null);
        TreeNode node6 = new TreeNode(60,null,null);
        TreeNode node7 = new TreeNode(70,null,null);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setRight(node4);
        node3.setLeft(node5);
        node3.setRight(node6);
        node5.setRight(node7);;
        return node1;
    }



//    Recursive Solution
    public void preOrderTraversal(TreeNode node){

        if (node == null)
            return;

        System.out.print(node.getVal() + " ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

//    Iterative Solution
    public void preOrderTraversalI(TreeNode node){
        Stack<TreeNode> stack = new Stack();
        while (node != null){
            System.out.print(node.getVal()+" ");
            if (node.getRight() != null)
                stack.push(node.getRight());

            if (node.getLeft() != null){
                node = node.getLeft();
            }else{
                if (!stack.isEmpty())
                    node = stack.pop();
                else break;
            }
        }
    }

    //    Recursive Solution
    public void postOrderTraversal(TreeNode node){

        if (node == null)
            return;

        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getVal() + " ");
    }


    class Quad{
        TreeNode node;
        Boolean sd;
        Boolean ld;
        Boolean rd;

        public Quad(TreeNode node){
            this.node = node;
            this.sd = false;
            this.ld = false;
            this.rd = false;
        }
        public Quad(TreeNode node,Boolean sd,Boolean ld,Boolean rd){
            this.node = node;
            this.sd = sd;
            this.ld = ld;
            this.rd = rd;
        }
    }

    //    Iterative Solution
    public void postOrderTraversalI(TreeNode node){
        Stack<Quad> stack = new Stack();
        if (node == null)
            return;
        stack.push(new Quad(node));
        while (!stack.isEmpty()){
            Quad q = stack.peek();
            if (!q.ld){
                q.ld = true;
                if (q.node.getLeft() != null){
                    stack.push(new Quad(q.node.getLeft()));
                }
            }else if (!q.rd){
                q.rd = true;
                if (q.node.getRight() != null){
                    stack.push(new Quad(q.node.getRight()));
                }
            }else if (!q.sd){
                q.sd = true;
                System.out.print(q.node.getVal()+" ");
            }else{
                stack.pop();
            }
        }

    }

    // Recursive Solution

    public void inOrderTraversal(TreeNode node){
        if (node == null)
            return;

        inOrderTraversal(node.getLeft());
        System.out.print(node.getVal()+" ");
        inOrderTraversal(node.getRight());
    }

    //    Iterative Solution
    public void inOrderTraversalI(TreeNode node){
        Stack<Quad> stack = new Stack();
        if (node == null)
            return;
        stack.push(new Quad(node));
        while (!stack.isEmpty()){
            Quad q = stack.peek();
            if (!q.ld){
                q.ld = true;
                if (q.node.getLeft() != null){
                    stack.push(new Quad(q.node.getLeft()));
                }
            }else if (!q.sd){
                q.sd = true;
                System.out.print(q.node.getVal()+" ");
            }else if (!q.rd){
                q.rd = true;
                if (q.node.getRight() != null){
                    stack.push(new Quad(q.node.getRight()));
                }
            }else{
                stack.pop();
            }
        }

    }

}
