package conins1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandbox1 {
    // 1 5 10 20 25 50
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int[] coins = {1, 5, 10, 20, 25, 50};
        int coinIndex = coins.length - 1;
        List<Integer> result = new ArrayList<>();
        while(sum > 0) {
            if(coins[coinIndex] > sum && coinIndex > 0) {
                coinIndex--;
            } else {
                sum -= coins[coinIndex];
                result.add(coins[coinIndex]);
            }
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
