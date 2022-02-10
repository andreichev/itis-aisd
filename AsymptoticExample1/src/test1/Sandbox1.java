package test1;

public class Sandbox1 {
    // O(n)
    static int find(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // O(log n)
    static int findBinary(int[] array, int value) {
        int n = array.length;
        int cursor = n / 2;
        while (n > 0) {
            n /= 2;
            if(array[cursor] < value) {
                cursor += n;
            } else if(array[cursor] > value) {
                cursor -= n;
            } else {
                return cursor;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find(
                new int[] {1, 5, 3, 2, 5, 6},
                6
        ));

        System.out.println(findBinary(
                new int[] {1, 5, 7, 12, 15, 16},
                6
        ));
    }
}
