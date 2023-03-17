import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAnagram {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));

    }
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        if(p.length() > s.length())
            return result;

        for (int i = 0; i < p.length(); ++i){
            char current = p.charAt(i);
            if(pMap.containsKey(current)){
                pMap.put(current, pMap.get(current) + 1);
            }
            else {
                pMap.put(current, 1);
            }
        }

        //create the first p window size for string s
        int l = 0; int r = 0;

        while (r < p.length()){
            char current = s.charAt(r);
            if(sMap.containsKey(current)){
                sMap.put(current, sMap.get(current) + 1);
            }
            else {
                sMap.put(current, 1);
            }
            ++r;
        }

        //we want r is smaller than p size
        r -= 1;

        while (r < s.length()){
            if(sMap.equals(pMap)){
                result.add(l);
            }
            char removedChar = s.charAt((l));
            sMap.remove(removedChar);
            ++l;
            ++r;

            if(r < s.length()){
                char current = s.charAt(r);

                if(sMap.containsKey(current)){
                    sMap.put(current, sMap.get(current) + 1);
                }
                else {
                    sMap.put(current, 1);
                }
            }
        }
        return result;
    }
}
