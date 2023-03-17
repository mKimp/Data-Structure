import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class destCity {
    public static void main(String[] args) {
        List<List<String>> arg = new ArrayList<>();

        List<String>temp = new ArrayList<>();
        temp.add("London");
        temp.add("New York");

        List<String>temp1 = new ArrayList<>();
        temp1.add("Lima");
        temp1.add("New York");

        List<String>temp2 = new ArrayList<>();
        temp2.add("Lima");
        temp2.add("Sao Paulo");

        arg.add(temp);
        arg.add(temp1);
        arg.add(temp2);


       System.out.println (destCity(arg));
    }

public static String destCity(List<List<String>> paths) {

        HashMap<String, Integer> map = new HashMap<>();

        for (List<String> l : paths){
            for (String i : l){
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        for (String s : map.keySet()){
            if(map.get(s) == 1)
                return s;
        }
        return null;
    }
}