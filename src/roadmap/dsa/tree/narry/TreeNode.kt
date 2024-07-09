package roadmap.dsa.tree.narry

data class TreeNode(
    var `val` : Int,
    var child : List<TreeNode>? = null
){
    companion object ConstructTree{
        private val node1 : TreeNode = TreeNode(10,null);
        private val node2 : TreeNode = TreeNode(20,null);
        private val node3 : TreeNode = TreeNode(30,null);
        private val node4 : TreeNode = TreeNode(40,null);
        private val node5 : TreeNode = TreeNode(50,null);
        private val node6 : TreeNode = TreeNode(60,null);
        private val node7 : TreeNode = TreeNode(70,null);
        private val node8 : TreeNode = TreeNode(80,null);
        private val node9 : TreeNode = TreeNode(90,null);
        private val node10 : TreeNode = TreeNode(100,null);
        private val node11 : TreeNode = TreeNode(110,null);
        private val node12 : TreeNode = TreeNode(120,null);
        fun getTree() : TreeNode{
            node1.child = mutableListOf(node2,node3,node4)
            node2.child = mutableListOf(node5,node6)
            node4.child = mutableListOf(node7,node8)
            node6.child = mutableListOf(node9,node10)
            node7.child = mutableListOf(node11,node12)
            return node1;
        }
    }
}