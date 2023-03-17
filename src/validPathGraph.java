import java.util.*;

public class validPathGraph {
    public static void main(String[] args) {
        int edges [][] = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        System.out.println(validPath(10, edges, 5, 9));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        if(edges.length == 0 && source == 0 && destination == 0)
            return true;
        else if(n <= 1 || edges.length <= 0)
            return false;
        //construct the graph
        Graph myGraph = new Graph<Integer>();
        for (int[]edge: edges){
            myGraph.addEdge(edge[0], edge[1], true);
        }

        int[]visited = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(source);

        while(!stack.empty()){
            int current = stack.pop();

            if(visited[current] != 1){
                visited[current] = 1;
                List<Integer> list = myGraph.getNeighbors(current);
                for (int i : list){
                    if(i == destination) return true;
                    if(visited[i] != 1){
                        stack.push(i);
                    }
                }
            }
        }
        return false;
    }

    static class Graph<T> {
        private Map<T, List<T>> map = new HashMap<>();

        public void addVertex(T s){
            map.put(s, new LinkedList<T>());
        }

        public  List<T> getNeighbors(T node){
            if(map.containsKey(node)){
                return map.get(node);
            }
            return null;
        }

        public void addEdge(T source, T des, boolean bi){
            if(!map.containsKey(source))
                addVertex(source);
            if(!map.containsKey(des))
                addVertex(des);
            map.get(source).add(des);

            if(bi)
                map.get(des).add(source);
        }

        public boolean hasEdge(T s, T d){
            if(map.get(s).contains(d))
                return true;
            return false;
        }

    }


}
