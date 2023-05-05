import java.util.HashSet;

public class AllUniqueStrings {
    public static void main(String[] args) {
        String input1 = "aab";
        int output1 = maxUniqueSplit(input1);
        System.out.println("maxUniqueSplit(" + input1 + ") = " + output1); //Expected: 4

    }
    public static int maxUniqueSplit(String s) {
        // TODO: Write your code here
        int unique = 0;
        HashSet<String> mySet = new HashSet<>();
        StringBuilder currentString = new StringBuilder();
        unique = backtrack(s, 0, mySet, unique, currentString);

        return unique;
    }

    public static int backtrack(String s, int startIndex, HashSet<String> mySet, int count, StringBuilder currentString ){
        //termination case
        if(startIndex == s.length()){
            if(allUnique(mySet, s)){
                return 1;
            }
            return 0;
        }

        for (int i = startIndex; i < s.length(); ++i){
            currentString.append(s.charAt(i));
            mySet.add(currentString.toString());
            count += backtrack(s, i + 1, mySet, count, currentString);
            mySet.remove(currentString.toString());
            currentString.deleteCharAt(currentString.length() - 1);
        }
        return count;
    }

    public static boolean allUnique(HashSet<String> mySet, String s){
        String compare = "";
        for (String myString: mySet){
            compare += myString;
        }
        if(compare.equals(s)){
            return true;
        }
        return false;

    }
}
