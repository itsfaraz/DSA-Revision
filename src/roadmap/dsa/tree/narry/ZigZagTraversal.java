package roadmap.dsa.tree.narry;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {

    public static void main(String[] args) {
        new ZigZagTraversal().zigZagTravel(TreeNode.ConstructTree.getTree());
    }

    public LinkedList<LinkedList<Integer>> zigZagTravel(TreeNode root){
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;

        Stack<TreeNode> primaryStack = new Stack<>();
        Stack<TreeNode> helperStack = new Stack<>();

        primaryStack.add(root);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(root.getVal());
        boolean order = true;
        while (!primaryStack.isEmpty()){
            if (!list.isEmpty()){
                result.add(new LinkedList<>(list));
            }
            list.clear();
            TreeNode node = primaryStack.pop();
            if (node.getChild() != null){
                List<TreeNode> childrens = node.getChild();
                if (order){
                    for (int i = childrens.size()-1; i >= 0; i--){
                        helperStack.add(childrens.get(i));
                        list.add(childrens.get(i).getVal());
                    }

                }else{
                    for (int i = 0; i <= childrens.size()-1; i++){
                        helperStack.add(childrens.get(i));
                        list.add(childrens.get(i).getVal());
                    }

                }
            }

            if (primaryStack.isEmpty()){
                primaryStack = helperStack;
                helperStack = new Stack<>();
                order = !order;
            }

        }
        System.out.println(result);
        return result;
    }

}