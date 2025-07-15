import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static int cost(String s1, String s2, int ci, int cd, int cs) {
        int m = s1.length();
        int n = s2.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            prev[j] = j * ci;
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = i * cd;
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int ins = curr[j - 1] + ci;
                    int del = prev[j] + cd;
                    int sub = prev[j - 1] + cs;

                    curr[j] = Math.min(ins, Math.min(del, sub));
                }
            }
            prev = Arrays.copyOf(curr, n + 1);
        }

        return curr[n];
    }

    public static List<String> getSuggestions(String input, List<String> dictionary, int Ci, int Cd, int Cs) {
        List<String> suggestions = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;

        for (String word : dictionary) {
            int dist = cost(input, word, Ci, Cd, Cs);
            if (dist < minDistance) {
                suggestions.clear();
                suggestions.add(word);
                minDistance = dist;
            } else if (dist == minDistance) {
                suggestions.add(word);
            }
        }

        return suggestions;
    }


    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cred", "bet", "shat", "that", "brad", "cart", "brat", "card");
        String input = "dat";
        int Ci = 1, Cd = 1, Cs = 1;

        List<String> result = getSuggestions(input, dictionary, Ci, Cd, Cs);
        System.out.println("Suggestions of dat: " + result);
    }
}