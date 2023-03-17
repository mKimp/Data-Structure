import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class wordbreak {
    public static void main(String[] args) {

        HashSet<String> dic = new HashSet<>();
        dic.add("cats");
        dic.add("dog");
        dic.add("sand");
        dic.add("and");
        dic.add("cat");

        List<String> ans = wordBreak("catsandog", dic);

        for (String s : ans)
            System.out.println(s);
    }

    public static List<String> wordBreak(String s,  HashSet<String>  dic){
        if(s == null || s.isEmpty())
            return null;

        int[]memo = new int[s.length()];
        Arrays.fill(memo, 0);
        List<String> result = new ArrayList<>();
        if(helper(s, 0, memo, dic))
            return result;
        return null;
    }

    private static boolean helper(String s, int start, int[] memo, HashSet<String>  dic) {
        if(start == s.length())
            return true;
        if(memo[start] == -1)
            return false;

        for (int i = start; i < s.length(); ++i){
            String temp = s.substring(start, i + 1);
            if(dic.contains(temp)){
                boolean r = helper(s, i + 1, memo, dic);
                if(r){
                    return true;
                }
                else{
                    memo[start] = -1;
                }
            }
        }
        return false;

    }
}
