import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[][] pre = {{0, 1}, {1,0}};

        System.out.println(canFinish(3, pre));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        State [] visited = new State[numCourses];

        //construct a graph
        for (int i = 0; i < prerequisites.length; ++i) {
            if(!map.containsKey(prerequisites[i][0])) {
                map.put(prerequisites[i][0], new ArrayList<Integer>());
            }

            map.get(prerequisites[i][0]).add(prerequisites[i][1]);

        }

        Arrays.fill(visited, State.UNVISITED);

        for (Map.Entry<Integer, List<Integer>>entry: map.entrySet()){
            int key = entry.getKey();
            if(visited[key] == State.UNVISITED && isCycle(visited, key, map)){
                return false;
            }
        }

        return true;
    }

    public static boolean isCycle(State[] visited, int c, HashMap<Integer, List<Integer>> map) {
        visited[c] = State.VISITING;

        //get adj neighbors
        List<Integer> l = map.get(c);
        if(l != null && l.size() > 0){
            for (int neighbor: l){
                if(visited[neighbor] == State.UNVISITED && isCycle(visited, neighbor, map)){
                    return true;
                }
                else if(visited[neighbor] == State.VISITING) return true;
            }
        }
        visited[c] = State.VISITED;
        return false;
    }

    public enum State {
        UNVISITED,
        VISITING,
        VISITED
    }

}