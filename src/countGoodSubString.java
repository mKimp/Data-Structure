import java.util.HashSet;

public class countGoodSubString {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aababcabc"));
    }
    public static int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;

        HashSet<Character> set = new HashSet<>();
        int counter = 0;

        for (int i = 0; i < s.length() - 2; ++i){
            String subString= s.substring(i, i + 3);

            for (char c: subString.toCharArray()){
                set.add(c);
            }

            if(set.size() == 3) ++counter;

            set.clear();
        }

        return counter;
    }
}
