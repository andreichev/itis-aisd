package brackets2;

public class Brackets2 {
    static int minIncorrectBracketsCount(String line) {
        int[][] dp = new int[line.length()][line.length()];
        for (int r = 0; r < line.length(); r++) {
            for (int l = r; l >= 0; l--) {
                if (l == r) {
                    dp[l][r] = 1; // База динамики
                } else {
                    int best = 1000000;
                    if (line.charAt(l) == '(' && line.charAt(r) == ')' || line.charAt(l) == '[' &&
                            line.charAt(r) == ']' || line.charAt(l) == '{' && line.charAt(r) == '}') {
                        //Случай соответствующих скобок
                        best = dp[l + 1][r - 1];
                    }
                    //Общий случай правила перехода динамики
                    for (int k = l; k < r; k++) {
                        if (dp[l][k] + dp[k + 1][r] < best) {
                            best = dp[l][k] + dp[k + 1][r];
                        }
                    }
                    dp[l][r] = best;
                }
            }
        }
        return dp[0][line.length() - 1];
    }

    public static void main(String[] args) {
        // ({{)}}
        // 2
        // [{]}
        // 2
        // Сколько скобок минимум удалить, чтобы получилась правильная последовательность
        System.out.println(minIncorrectBracketsCount("[{]}"));

    }
}
