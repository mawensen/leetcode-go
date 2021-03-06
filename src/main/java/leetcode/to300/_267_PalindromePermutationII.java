package leetcode.to300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-permutation-ii/
 * Subject: Backtrack
 * #Medium
 */
public class _267_PalindromePermutationII {


    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }
        if (odd > 1) return res;

        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) mid += key;
            for (int i = 0; i < val / 2; i++) {
                list.add(key);
            }
        }
        helper(list, mid, new boolean[list.size()], new StringBuilder(), res);
        return res;
    }

    private void helper(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                helper(list, mid, used, sb, res);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    //Provide a second solution. (Preferred)
    public List<String> generatePalindromes2(String s) {
        List<String> res = new ArrayList<>();
        int[] table = new int[128];
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            table[s.charAt(i)]++;
            cnt = (table[s.charAt(i)] % 2 == 0) ? cnt - 1 : cnt + 1;
        }
        if(s.equals("") || cnt > 1){
            return res;
        }
        String temp = "";
        for(int i=0;i<128 && cnt == 1;i++){
            if(table[i] % 2 == 1){
                temp += (char) i;
                break;
            }
        }
        backtrackHelper(table,temp,res,s.length());

        return res;
    }

    public void backtrackHelper(int[] table,String curr,List<String> res,int l){
        if(curr.length() == l){
            res.add(curr);
            return;
        }
        for(int i=0;i<128;i++){
            if(table[i] > 1){
                table[i] -= 2;
                char c = (char) i;
                String temp = c + curr + c;
                backtrackHelper(table,temp,res,l);
                table[i] += 2;
            }
        }
    }
}
