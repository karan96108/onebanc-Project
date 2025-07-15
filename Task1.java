class Task1 {

    public static int minDistance(String src, String tar) {

        if (src == null || src.length() == 0) return (tar == null) ? 0 : tar.length();
        if (tar == null || tar.length() == 0) return src.length();

        int m = src.length();
        int n = tar.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            char ch1 = src.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                char ch2 = tar.charAt(j - 1);

                if (ch1 == ch2) {
                    curr[j] = prev[j - 1];
                } else {
                    int ins = curr[j - 1];
                    int del = prev[j];
                    int rep = prev[j - 1];

                    curr[j] = 1 + Math.min(ins, Math.min(del, rep));
                }
            }

            for (int k = 0; k <= n; k++) {
                prev[k] = curr[k];
            }
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

        System.out.println("kitten and sitting "+ minDistance(src1,tar1));
        System.out.println("flaw and lawn "+ minDistance(src2,tar2));
        System.out.println("algorithm and logarithm "+ minDistance(src3,tar3));
    }
}
