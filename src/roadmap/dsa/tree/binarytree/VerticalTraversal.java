package roadmap.dsa.tree.binarytree;

import java.util.*;

public class VerticalTraversal {


    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        VerticalTraversal traversal = new VerticalTraversal();
        traversal.traverseVertically(roadmap.dsa.tree.binarytree.TreeNode.BinaryTree.getTree(),0,map);
        traversal.traverseVerticallyI(roadmap.dsa.tree.binarytree.TreeNode.BinaryTree.getTree());

        System.out.println(map);
    }

    public void traverseVertically(TreeNode node, int count, HashMap<Integer, ArrayList<Integer>> map){
        if (node == null)
            return;

        if (map.containsKey(count)){
            List<Integer> dataList = map.get(count);
            dataList.add(node.getVal());
        }else{
            ArrayList<Integer> list = new ArrayList(node.getVal());
                    list.add(node.getVal());
            map.put(count,list);
        }

        traverseVertically(node.getLeft(),count-1,map);
        traverseVertically(node.getRight(),count+1,map);
    }



    // Traverse Vertically Iterative
    public void traverseVerticallyI(TreeNode node){
        if (node == null) {
            return;
        }
        Queue<TreePair> queue = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int initCount = 0;
        queue.add(new TreePair(node,initCount));
        while (!queue.isEmpty()){
            TreePair pair = queue.poll();
            TreeNode treeNode = pair.first;
            int count = pair.second;

            if (map.containsKey(count)){
                List<Integer> list = map.get(count);
                list.add(treeNode.getVal());
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(treeNode.getVal());
                map.put(count,list);
            }

            if (treeNode.getLeft() != null){
                queue.add(new TreePair(treeNode.getLeft(),count-1));
            }

            if (treeNode.getRight() != null){
                queue.add(new TreePair(treeNode.getRight(),count+1));
            }
        }
        displayMap(map);
    }

    public void displayMap(HashMap<Integer,List<Integer>> map){
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            for (Integer val : map.get(iterator.next())){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

}
