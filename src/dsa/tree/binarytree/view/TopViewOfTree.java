package dsa.tree.binarytree.view;

import dsa.tree.binarytree.TreeNode;
import dsa.tree.binarytree.TreePair;

import java.util.*;

public class TopViewOfTree {


    public static void main(String[] args) {
        TopViewOfTree topView = new TopViewOfTree();
        TreeNode root = dsa.tree.binarytree.TreeNode.BinaryTree.getTree();
        topView.topViewDisplay(root,true);
        System.out.println();
        topView.topViewDisplay(root,false);
    }



    public void topViewDisplay(TreeNode node,Boolean recursive){

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        if (recursive)
            topView(node,0,map);
        else topView(node,map);
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.print(map.get(iterator.next()).get(0)+" ");
        }
        System.out.println();
    }


//    Iterative
    private void topView(TreeNode node, HashMap<Integer, List<Integer>> map){
        Queue<TreePair> queue = new LinkedList<>();

        queue.add(new TreePair(node,0));
        while (!queue.isEmpty()){
            TreePair pair = queue.poll();
            TreeNode first = pair.first;
            Integer count = pair.second;
            if (map.containsKey(count)){
                List<Integer> list = map.get(count);
                list.add(first.getVal());
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(first.getVal());
                map.put(count,list);
            }
            if (first.getLeft() != null)
                queue.add(new TreePair(first.getLeft(),count-1));

            if (first.getRight() != null)
                queue.add(new TreePair(first.getRight(),count+1));
        }
    }

//    Recursive
    private void topView(TreeNode node, int count, HashMap<Integer, List<Integer>> map){
        if (node == null)
            return;

        if (map.containsKey(count)){
            List<Integer> list = map.get(count);
            list.add(node.getVal());
        }else {
            List<Integer> list = new ArrayList<>();
            list.add(node.getVal());
            map.put(count,list);
        }


        topView(node.getLeft(),count-1,map);
        topView(node.getRight(),count+1,map);
    }

}
