package dsa.tree.binarytree

data class TreeNode constructor(
    val `val` : Int,
    var left : TreeNode? = null,
    var right : TreeNode? = null
){
    public constructor(`val` : Int) : this(`val`,null,null)
    companion object BinaryTree{
         private val node1 : TreeNode = TreeNode(10,null,null);
         private val node2 : TreeNode = TreeNode(20,null,null);
         private val node3 : TreeNode = TreeNode(30,null,null);
         private val node4 : TreeNode = TreeNode(40,null,null);
         private val node5 : TreeNode = TreeNode(50,null,null);
         private val node6 : TreeNode = TreeNode(60,null,null);
         private val node7 : TreeNode = TreeNode(70,null,null);
         private val node8 : TreeNode = TreeNode(80,null,null);
         private val node9 : TreeNode = TreeNode(90,null,null);
         private val node10 : TreeNode = TreeNode(100,null,null);
         private val node11 : TreeNode = TreeNode(110,null,null);

        public fun getBalancedTree() : TreeNode{
            node1.left = node2;
            node1.right = node3;
            node3.left = node4;
            node3.right = node5;
            return node1;
        }
        public fun getTree() : TreeNode{
            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node2.right = node5;
            node4.left = node6;
            node6.left = node8;
            node5.right = node7;
            node7.right = node9;
            node9.left = node10;
            node9.right = node11;
            return node1;
        }
    }
}