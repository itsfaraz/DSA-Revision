package roadmap.dsa.customdatastructure;

import roadmap.dsa.customdatastructure.tree.BST;

public class Main {

    public static void main(String[] args) {

        int []inOrder = {5,10,12,15,18,20,25};
        BST bst = new BST(inOrder);
        System.out.println(bst.max());
    }

}
