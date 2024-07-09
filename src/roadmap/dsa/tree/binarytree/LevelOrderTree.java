package roadmap.dsa.tree.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10,null,null);
        TreeNode node2 = new TreeNode(20,null,null);
        TreeNode node3 = new TreeNode(30,null,null);
        TreeNode node4 = new TreeNode(40,null,null);
        TreeNode node5 = new TreeNode(50,null,null);
        TreeNode node6 = new TreeNode(60,null,null);
        TreeNode node7 = new TreeNode(70,null,null);
        TreeNode node8 = new TreeNode(80,null,null);
        TreeNode node9 = new TreeNode(90,null,null);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node7.setLeft(node8);
        node7.setRight(node9);
        new LevelOrderTree().levelOrder(node1);
    }

    List<Integer> getLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.getVal());
            if (node.getLeft() != null)
                queue.add(node.getLeft());
            if (node.getRight() != null)
                queue.add(node.getRight());
        }
        return result;
    }


    List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> list = new LinkedList();
        list.add(root.getVal());
        while (!queue.isEmpty()){
            if(!list.isEmpty()){
                result.add(new LinkedList<>(list));
            }
            list.clear();
            TreeNode node = queue.poll();;
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
                list.add(node.getLeft().getVal());
            }else {
                list.add(null);
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
                list.add(node.getRight().getVal());
            }else{
                list.add(null);
            }
        }

        System.out.println(result);
        return result;
    }
}
