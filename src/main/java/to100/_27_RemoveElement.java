package to100;

import java.util.Arrays;


public class _27_RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 4};
        removeElement(nums, 3);
    }
}