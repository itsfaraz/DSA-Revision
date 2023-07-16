package dsa.tree.narry;

import dsa.tree.narry.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTree {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1,null);
        TreeNode node2 = new TreeNode(2,null);
        TreeNode node3 = new TreeNode(3,null);
        TreeNode node4 = new TreeNode(4,null);
        TreeNode node5 = new TreeNode(5,null);
        TreeNode node6 = new TreeNode(6,null);

        node1.setChild(List.of(node2,node3,node4));
        node2.setChild(List.of(node5,node6));
        new LevelOrderTree().levelOrder(node1);
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
            if (node.getChild() != null){
                List<TreeNode> children = node.getChild();
                for (TreeNode child : children){
                    queue.add(child);
                    list.add(child.getVal());
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
