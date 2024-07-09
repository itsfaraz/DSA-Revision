package roadmap.dsa.graph;

import kotlin.Pair;

import java.util.*;

public class Graph {
    HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();

    public Graph(int vertices){
        for (int idx = 1; idx <= vertices; idx++){
            map.put(idx,new HashMap<>());
        }
    }

    public void addEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }

    public boolean containsEdge(int v1,int v2){
        return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
    }

    public int totalEdges(){
        Iterator<Integer> iterator = map.keySet().iterator();
        int total = 0;
        while (iterator.hasNext()){
            total += map.get(iterator.next()).size();
        }
        return total/2;
    }

    public boolean remove(int v1,int v2){
        if (this.containsEdge(v1,v2)){
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
            return true;
        }
        return false;
    }

    public void display(){
        for (Integer key : map.keySet()){
            System.out.println(key + " "+map.get(key));
        }
        System.out.println();
    }

    public boolean hasPath(int src,int dest){
        HashSet<Integer> set = new HashSet<>();
        return hasPath(src,dest,set);
    }

    private boolean hasPath(int src, int dest, HashSet<Integer> visited){
        if (map.get(src).containsKey(dest)){
            return true;
        }
        visited.add(src);
        boolean ans = false;
        for (int neighbour : map.get(src).keySet()){
            if (!visited.contains(neighbour)) {
                ans = hasPath(neighbour, dest, visited);
                if (ans)
                    return true;
            }
        }
        return ans;
    }

    public void printPaths(int src,int dest){
        printPaths(src,dest,new HashSet<Integer>(),src+" ");
    }
    private void printPaths(int src, int dest, HashSet<Integer> visited,String ans){
        visited.add(src);
        if (src == dest){
            System.out.println(ans);
            return;
        }

        for (int neighbour : map.get(src).keySet()){
            if (!visited.contains(neighbour)) {
                printPaths(neighbour, dest, visited,ans+neighbour+" ");
                visited.remove(neighbour);
            }

        }

    }

    public boolean bfs(int src,int dst){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(src);
        visited.add(src);
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            if (vertex == dst)
                return true;
            if (map.containsKey(vertex)){
                for (int key : map.get(vertex).keySet()){
                    if (!visited.contains(key)){
                        queue.add(key);
                    }
                }
            }

        }
        return false;
    }

    public boolean dfs(int src,int dst){
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        stack.add(src);
        visited.add(src);
        while (!stack.isEmpty()){
            int vertex = stack.pop();
            if (vertex == dst)
                return true;
            if (map.containsKey(vertex)){
                for (int key : map.get(vertex).keySet()){
                    if (!visited.contains(key)){
                        stack.add(key);
                    }
                }
            }

        }
        return false;
    }

    public void bft(){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int src : map.keySet()){
            if (visited.contains(src))
                continue;
            queue.add(src);
            while (!queue.isEmpty()){
                int value = queue.poll();
                if (visited.contains(value))
                    continue;
                visited.add(value);
                System.out.print(value+" ");
                queue.addAll(map.get(value).keySet());
            }
        }
        System.out.println();
    }

    public boolean isCyclic(){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int noOfComponent = 0;
        for (int src : map.keySet()){
            if (visited.contains(src)) {
                continue;
            }
            noOfComponent++;
            queue.add(src);
            while (!queue.isEmpty()){
                int value = queue.poll();
                if (visited.contains(value))
                    continue;
                visited.add(value);
                queue.addAll(map.get(value).keySet());
            }
        }
        if (noOfComponent > 1)
            return true;
        return false;
    }

    public boolean isConnected(){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int noOfComponent = 0;
        for (int src : map.keySet()){
            if (visited.contains(src)) {
                continue;
            }
            noOfComponent++;
            queue.add(src);
            while (!queue.isEmpty()){
                int value = queue.poll();
                if (visited.contains(value))
                    continue;
                visited.add(value);
                queue.addAll(map.get(value).keySet());
            }
        }
        if (noOfComponent > 1)
            return false;
        return true;
    }

    public boolean isTree(){
        return isConnected() && !isCyclic();
    }

    public LinkedList<LinkedList<Integer>> getConnectedGraph(){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        for (int src : map.keySet()){
            if (visited.contains(src))
                continue;
            LinkedList<Integer> list = new LinkedList<>();
            queue.add(src);
            while (!queue.isEmpty()){
                int value = queue.poll();
                if (visited.contains(value))
                    continue;
                list.add(value);
                visited.add(value);
                queue.addAll(map.get(value).keySet());
            }
            result.add(list);
        }
        return result;
    }

    public boolean isBipartite(){
        /*
            Pair
                first : vertex value
                second : color boolean
                true  =  red
                false = green
         */
        Queue<Pair<Integer,Boolean>> queue = new LinkedList<>();
        HashMap<Integer,Boolean> visited = new HashMap<>();
        for (int src : map.keySet()){
            if (visited.containsKey(src))
                continue;
            queue.add(new Pair<Integer,Boolean>(src,true));
            while (!queue.isEmpty()){
                Pair pair = queue.poll();
                if (visited.containsKey((int) pair.getFirst())){
                    if (visited.get(pair.getFirst()) != pair.getSecond())
                        return false;
                    continue;
                }

                visited.put((int)pair.getFirst(),(boolean)pair.getSecond());
                for (int key : map.get((int) pair.getFirst()).keySet()){
                    if ((boolean) pair.getSecond()){
                        queue.add(new Pair<>(key,false));
                    }else{
                        queue.add(new Pair<>(key,true));
                    }
                }
            }
        }
        return true;
    }
}
