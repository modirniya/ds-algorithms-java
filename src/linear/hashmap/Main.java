package linear.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String expr = "a green apple";
        hashMapDriver();
    }

    private static void hashMapDriver() {
        final var hashmap = new HashTable(3);
        hashmap.put(1, "Parham");
        hashmap.put(2, "Ali");
        hashmap.put(12, "arghavan");
        System.out.println(hashmap.remove(2));
        System.out.println(hashmap.get(12));
    }

    private static void firstNoneRepeatedWithSetDriver(String expr) {
        Set<Character> set = new HashSet<>();
        final var chars = expr.toCharArray();
        for (Character ch : chars) {
            if (set.contains(ch)) {
                System.out.println("First char: '" + ch + "'");
                break;
            } else {
                set.add(ch);
            }
        }
    }

    private static void firstNoneRepeatedCharDriver(String expr) {
        if (expr == null) throw new IllegalArgumentException("Null value");
        Map<Character, Integer> dict = new HashMap<>();
        var chars = expr.toCharArray();
        for (char ch : chars) {
            var occurrence = dict.getOrDefault(ch, 0);
            dict.put(ch, ++occurrence);
            if (occurrence > 1) {
                System.out.println("Repeated character: '" + ch + "'");
            }
        }
        for (char ch : chars) {
            if (dict.get(ch) == 1) {
                System.out.println("None-repeated char: '" + ch + "'");
            }
        }
    }
}
