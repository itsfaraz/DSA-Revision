package dsa.graph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(1,2,10);
        graph.addEdge(1,4,6);
        graph.addEdge(2,3,30);
        graph.addEdge(3,4,20);
        graph.addEdge(4,5,5);
        graph.addEdge(5,6,4);
        graph.addEdge(5,7,8);
        graph.addEdge(6,7,9);
        System.out.println(graph.containsEdge(3,4));
        graph.display();
//        graph.remove(3,4);
        System.out.println(graph.containsEdge(3,4));
        graph.display();
//        System.out.println(graph.totalEdges());
//        graph.remove(4,5);
//        System.out.println(graph.hasPath(3,6));
        graph.printPaths(1,6);
//        System.out.println(graph.bfs(1,6));
//        System.out.println(graph.dfs(1,6));
        graph.bft();
        System.out.println("Is Tree : "+graph.isTree());
        System.out.println(graph.isCyclic());

        System.out.println(graph.isTree());
        System.out.println("Bipartite Graph : "+graph.isBipartite());
        System.out.println("Component List : "+graph.getConnectedGraph());
        Graph treeGraph = new Graph(7);
        treeGraph.addEdge(1,2,0);
        treeGraph.addEdge(2,5,0);
        treeGraph.addEdge(2,3,0);
        treeGraph.addEdge(3,4,0);
        treeGraph.addEdge(3,6,0);
        treeGraph.addEdge(6,7,0);
        System.out.println("Is Connected : "+treeGraph.isConnected());
        System.out.println("Is Tree : "+treeGraph.isTree());
        System.out.println("Component List : "+treeGraph.getConnectedGraph());
        System.out.println("Bipartite Graph : "+treeGraph.isBipartite());

    }

}
