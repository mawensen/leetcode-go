package leetcode.to300;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/flip-game-ii/
 * Subject: Recursion
 * #Medium
 */
public class _294_FlipGameII {

    public boolean canWin(String s) {
        if (s == null || s.length() == 0) return false;
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }

    private boolean helper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(opponent, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    //Provide a second solution.
    public boolean canWin2(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String nextState = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin2(nextState)) {
                    return true;
                }
            }
        }
        return false;
    }
}

