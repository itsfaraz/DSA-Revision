package roadmap.dsa.tree.binarytree.view;

import roadmap.dsa.tree.binarytree.TreeNode;

import java.util.*;

public class HorizontalViewOfTree {

    public static void main(String[] args) {
        TreeNode node = roadmap.dsa.tree.binarytree.TreeNode.BinaryTree.getTree();
        new HorizontalViewOfTree().differentView(node);
    }
    public void differentView(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> pQ = new LinkedList<>();
        Queue<TreeNode> hQ = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        pQ.add(root);
        int count = 0;
        while (!pQ.isEmpty()){
            TreeNode node = pQ.poll();
            if (map.containsKey(count)){
                List<Integer> list = map.get(count);
                list.add(node.getVal());
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(node.getVal());
                map.put(count,list);
            }
            if (node.getLeft() != null){
                hQ.add(node.getLeft());
            }
            if(node.getRight() != null){
                hQ.add(node.getRight());
            }
            if (pQ.isEmpty()){
                pQ = new LinkedList<>(hQ);
                hQ.clear();
                count+=1;
            }
        }
        printLeftView(map);
        printRightView(map);
    }

    private void printLeftView(HashMap<Integer, List<Integer>> map) {
        System.out.println("Left View : ");
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            System.out.print(map.get(iterator.next()).get(0)+" ");
        }
        System.out.println();
    }

    private void printRightView(HashMap<Integer, List<Integer>> map) {
        System.out.println("Right View : ");

        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            List<Integer> list = map.get(iterator.next());
            System.out.print(list.get(list.size()-1)+" ");
        }
        System.out.println();
    }
}
