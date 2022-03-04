package anagram;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAnagramInText {
    static class Solution {
        private boolean isEmpty(short[] array) {
            for (short value : array) {
                if (value != 0) {
                    return false;
                }
            }
            return true;
        }

        List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new LinkedList<>();
            if(s.length() < p.length()) {
                return result;
            }
            short[] pArray = new short[60];
            for (int i = 0; i < p.length(); i++) {
                pArray[p.charAt(i) - 'A']++;
                pArray[s.charAt(i) - 'A']--;
            }
            if(isEmpty(pArray)) {
                result.add(0);
            }
            for(int i = p.length(); i < s.length(); i++) {
                pArray[s.charAt(i) - 'A']--;
                pArray[s.charAt(i - p.length()) - 'A']++;
                if(isEmpty(pArray)) {
                    result.add(i - p.length() + 1);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }
}
