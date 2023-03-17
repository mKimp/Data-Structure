public class StringReverse {

    public static void main(String[] args) {
        System.out.println(reverse("I live in the house"));
    }

    public static String reverse (String s){
        StringBuilder builder = new StringBuilder();
        int currentWordEnd = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (builder.length() > 0) // not empty, add a space
                    builder.append(' ');
                builder.append(s.substring(i+1, currentWordEnd));
                currentWordEnd = i;
            }
        }
// add first word
        String firstWord = s.substring(0, currentWordEnd);
        if (builder.length() > 0)
            builder.append(' ');
        builder.append(firstWord);
        return builder.toString();
    }
}
