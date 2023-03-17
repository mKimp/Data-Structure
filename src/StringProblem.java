public class StringProblem {
    public static void main(String[] args) {
        System.out.println(urlify("Mr Jon Smith", 12));
    }

    public static String urlify (String s, int n){
        char [] array = s.toCharArray();

        if (n < 1){
            return null;
        }
        int spaceCount = 0;

        for (int i = 0; i < n; ++i){
            if(array[i] == ' '){
                ++spaceCount;
            }
        }

        int newLength = (n-1)  + (spaceCount * 2);

        for (int i = 0; i < n; ++i){
            if(array[i] == ' '){
                array[newLength] = '0';
                array[newLength - 1] = '2';
                array[newLength - 2] = '%';
                newLength -= 3;
            }
            else{
                array[newLength] = array[i];
                --newLength;
            }
        }
        /*
        StringBuffer result = new StringBuffer(n);

        for (int i = 0; i < n; i++){
            char curr = s.charAt(i);
            if(curr == ' '){
                result.append("%20");
            }
            else{
                result.append(curr);
            }
        }
        System.out.println(s.length()); */

        return array.toString();
    }
}
