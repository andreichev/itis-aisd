package anagram;

class CheckForAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] count = new int[100];
        char a = 'A';
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - a]++;
            count[t.charAt(i) - a]--;
        }
        for(int i = 0; i < 100; i++) {
            if(count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("cat", "rat"));
    }
}
