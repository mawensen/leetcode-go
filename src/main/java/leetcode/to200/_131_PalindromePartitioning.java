package leetcode.to200;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * Subject: Backtrack
 * #Medium
 */
public class _131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(res, new ArrayList<>(), s);
        return res;
    }

    public void helper(List<List<String>> res, List<String> list, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                helper(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //Provide a second solution (Preferred)
    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> list, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                backtrack(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
