package random_number;

public class RandomNumber {
    static int[] array;
    static int n;

    // Выдать следующее случайное число под индексом, который не был выбран прежде
    static int getNextRandomNumber() {
        int nextIndex = (int) (Math.random() * n);
        n--;
        if(n == 0) {
            n = array.length;
            return array[0];
        }
        int temp = array[n];
        array[n] = array[nextIndex];
        array[nextIndex] = temp;
        return array[n];
    }

    public static void main(String[] args) {
        array = new int[] {2, 3, 5, 8, 4, 1};
        n = array.length;

        for(int i = 0; i < 6; i++) {
            System.out.println(getNextRandomNumber());
        }
    }
}
