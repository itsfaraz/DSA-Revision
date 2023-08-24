package dsa.leetcode.sheet.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {
    // Cloning of graph from adjacency list

    private class Node{
        public int val;
        public List<Node> neighbors;
        public Node(int val){
            this.val = val;
        }

        public Node(int val,List<Node> neighbor){
            this.val = val;
            this.neighbors = neighbor;
        }

    }



}
