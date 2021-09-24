package array;

/**
 * @classname Array02
 * @description 买卖股票的最佳时机 II
 * {@link}  https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 * @author qkmango
 * @date: 2021-09-24 18:21
 * @version 1.0
 */
public class Array02 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min = -1;
        int max = -1;
        int count = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] <= prices[i]) {
                if (min == -1) {
                    min = i - 1;
                }
                if (max == -1 && i == prices.length - 1) {
                    max = i;
                }
            } else if (prices[i - 1] > prices[i] && min != -1 && max == -1) {
                max = i - 1;
            }

            if (min != -1 && max != -1) {
                count += prices[max] - prices[min];
                max = min = -1;
            }
        }

        return count;
    }
}
