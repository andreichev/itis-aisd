package brackets1;

public class Sandbox3 {
    static void func(String line, int open, int close, int target) {
        if(open == close && open + close == target) {
            System.out.println(line);
        }
        if(open + close >= target) { return; }
        func(line + "(", open + 1, close, target);
        if(open > close) {
            func(line + ")", open, close + 1, target);
        }
    }

    public static void main(String[] args) {
        func("", 0, 0, 6);
    }
}
