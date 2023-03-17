import java.util.*;

public class wordLadder {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        System.out.println(ladderLength("hit", "cog", list));
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Integer> visited = new HashMap<>();

        Set<String> set = new HashSet<>();
        wordList.add(beginWord);

        for (String word: wordList){
            char[]wordArray = word.toCharArray();

            for (int i = 0; i < wordArray.length; ++i){
                char temp = wordArray[i];
                wordArray[i] = '*';
                String newWordPattern = new String(wordArray);
                if(!map.containsKey(newWordPattern)){
                    map.put(newWordPattern, new ArrayList<>());
                }
                map.get(newWordPattern).add(word);
                wordArray[i] = temp;

            }
        }

        //BFS
        int level = 1;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.put(beginWord, 0);

        set.add(beginWord);

        while (!q.isEmpty()){
            String current = q.poll();
            System.out.println(current);

            if(current.equals(endWord)) return visited.get(current);

            char[]wordArray = current.toCharArray();

            int size = q.size();

                for (int i = 0; i < wordArray.length; ++i) {
                    char temp = wordArray[i];
                    wordArray[i] = '*';
                    String newWordPattern = new String(wordArray);
                    List<String> neighbor = map.get(newWordPattern);


                    if (neighbor != null && neighbor.size() > 0) {
                        for (String s : neighbor) {
                            if(!visited.containsKey(s)) {
                                q.add(s);
                                visited.put(s, visited.get(s) + 1);
                            }
                        }
                    }
                    wordArray[i] = temp;
                }

            level += 1;
        }
        return -1;

    }
}
