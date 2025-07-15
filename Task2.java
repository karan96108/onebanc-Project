import java.util.Arrays;

public class Task2 {
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

    public static void main(String[] args) {
        String src1 = "kitten";
        String tar1 = "sitting";
        String src2 = "flaw";
        String tar2 = "lawn";

        String src3 = "algorithm";
        String tar3 = "logarithm";

        int ci1 = 1 , cd1 =2 , cs1 =3;
        int ci2 = 2 , cd2 =2 , cs2 =1;
        int ci3 = 1 , cd3 =3 , cs3 =2;

        System.out.println("Cost of kitten and sitting = "+ cost(src1,tar1,ci1,cd1,cs1));
        System.out.println("Cost of flaw and lawn = "+ cost(src2,tar2,ci2,cd2,cs2));
        System.out.println("Cost of algorithm and logarithm = "+ cost(src3,tar3,ci3,cd3,cs3));
    }
}
