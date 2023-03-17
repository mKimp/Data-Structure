import java.util.HashMap;

public class getHint {
    public static void main(String[] args) {
        getHint("1122", "1222");
    }

    public static String getHint(String secret, String guess) {

        HashMap<Character, Integer> map = new HashMap<>();
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); ++i) {
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        }

        for (int j = 0; j < guess.length(); ++j){
            if(map.containsKey(guess.charAt(j)) && secret.charAt(j) == guess.charAt(j) &&  map.get(guess.charAt(j)) > 0  ){
                ++bull;
            }
            else if (map.containsKey(guess.charAt(j)) && secret.charAt(j) != guess.charAt(j) &&  map.get(guess.charAt(j)) > 0 ) {
                ++cow;
            }

            if(map.containsKey(guess.charAt(j)) && map.get(guess.charAt(j)) > 0 ){
                System.out.println(guess.charAt(j));
                char current = guess.charAt(j);
                map.put(current, map.get(current) - 1);
            }
        }

        return bull+"A"+cow+"B";
    }
}
