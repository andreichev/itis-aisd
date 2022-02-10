package greedy;

import java.util.Scanner;

// 4
// 11
// 0 1 2 3 4 7 8 12 13 14 15
// 3

// 10
// 10
// 0 1 2 3 4 5 6 7 8 9
// 0

// 5
// 10
// 0 1 2 3 4 5 6 7 8 9
// 1

public class Sandbox2 {
    // Greedy
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxFuel = scanner.nextInt();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int currentFuel = maxFuel;
        int result = 0;
        int i = 1;
        while (i < n) {
            int distance = array[i] - array[i - 1];
            currentFuel -= distance;
            i++;
            // Бензина не хватает - заправиться на предыдущей заправке
            if (currentFuel < 0) {
                i--;
                System.out.println("FUEL AT " + i);
                result++;
                currentFuel = maxFuel;
            }
        }
        System.out.println(result);
    }
}
