package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Questions {

    public static void basicFunctions() {

        HashMap<String, Integer> Corona = new HashMap<>();

        Corona.put("USA", 291545);
        Corona.put("SPAIN", 91545);
        Corona.put("INDIA", 1545);
        Corona.put("JAPAN", 295);

        System.out.println(Corona);

        System.out.println(Corona.get("USA"));
        System.out.println(Corona.get("USa"));
        Corona.put("JAPAN", 2955);
        System.out.println(Corona.get("JAPAN"));

        System.out.println(Corona.getOrDefault("USa", 100));
        System.out.println(Corona.keySet());

    }

    public static void freqMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // if(!map.containsKey(ch)){
            // map.put(ch, 1);
            // }
            // else {
            // map.put(ch,map.get(ch)+1);
            // }

            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }
        System.out.println(map);

        for (char ch : map.keySet()) {
            System.out.println(ch + "->" + map.get(ch));
        }

    }

    public static void freqMapOfIdx(String str) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!map.containsKey(ch))
                map.put(ch, new ArrayList<>());
            // ya fir ye use krlo

            // map.putIfAbsent(ch, new ArrayList<>()); ISKA MATLAB H KI
            // AGAR MILGYI TO KUCH MTT KRO AUR AGAR NA MILI TO PUT KRDO

            map.get(ch).add(i);
        }

        for (char ch : map.keySet()) {
            System.out.println(ch + "->" + map.get(ch));
        }
    }

    public static void intersection1(int[] one, int[] two) {

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < one.length; i++) {

            int a = one[i];
            map.put(a, map.getOrDefault(a, 0) + 1);

        }

        for (int i = 0; i < two.length; i++) {

            int a = two[i];
            map1.put(a, map1.getOrDefault(a, 0) + 1);

        }
        System.out.println(map);
        System.out.println(map1);

    }

    public static void main(String[] args) {
        // basicFunctions();
        String str = "hajdhsahahushshshshhshshsshjshddsajsisa";
        freqMap(str);
        // freqMapOfIdx(str);
        // int[] one = {2,3,2,4,6};
        // int[] two = {2,2,2,3,6,6,3};
        // intersection1(one, two);

    }

}