import java.util.HashSet;

public class LongestSubString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        if(s.length() == 0)
            return longest;
        if(s.length() == 1)
            return longest + 1;

        HashSet<Character> set = new HashSet<>();
        int start = 0; int e = 0;

        while (start < s.length()){
            if(start > e){
                e = start;
                longest = 0;
            }
            if(!set.contains(s.charAt(e))){
                set.add(s.charAt(e));
                ++e;
                longest = Math.max(longest, set.size());
                if(e == s.length())
                    break;

            }
            else{
                set.remove(s.charAt(start));
                ++start;
            }

        }
        return longest;
    }
}
