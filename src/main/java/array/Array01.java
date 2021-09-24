package array;

/**
 * @className: Array01
 * @Description: 删除排序数组中的重复项
 * @link: https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * @author: qkmango
 * @date: 2021-09-24 17:47
 * @version: 1.0
 */
public class Array01 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        removeDuplicates(nums);

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int thisIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[thisIdx] != nums[i]) {
                thisIdx++;
                nums[thisIdx] = nums[i];
            }
        }

        return thisIdx + 1;
    }
}

