import java.util.HashMap;
import java.util.Map;

public class logestSubStringWithSameChar {
    public static void main(String[] args) {

        characterReplacement("AABABBA", 1);
    }

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;

        int l = 0;
        int r = 0;

        while (r < s.length()) {
            char current = s.charAt(r);
            map.put(current, map.getOrDefault(current, 0) + 1);

            int mostFrequent = getMostFrequent(map);
            if ((r - l + 1) - mostFrequent > k) {
                char removedChar = s.charAt(l);
                map.put(removedChar, map.get(removedChar) - 1);
                ++l;
            }

            result = Math.max(result, r - l + 1);
            ++r;


        }

        return result;
    }

    public static int getMostFrequent(HashMap<Character, Integer> map) {
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();


            }
        }
        return max;
    }
}
