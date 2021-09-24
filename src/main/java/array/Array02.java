package array;

/**
 * @author qkmango
 * @version 1.0
 * @classname Array02
 * @description 买卖股票的最佳时机 II
 * {@link}  https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 * @date: 2021-09-24 18:21
 */
public class Array02 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2}));
    }

    /**
     * 求的是 只要 后一天比前一天高，就计算这两天的差，累加在count上
     * 计算递增段每天的差值
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        int count = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i]<prices[i+1]) {
                count += prices[i+1]-prices[i];
            }
        }
        return count;
    }

    /**
     * 求的是 最低点和最高点 之间的差
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {

        int min = -1;
        int count = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                if (min == -1) {
                    min = i - 1;
                }
                if (i == prices.length - 1) {
                    count += prices[i] - prices[min];
                    min = -1;
                }
            } else if (min != -1) {
                count += prices[i - 1] - prices[min];
                min = -1;
            }
        }

        return count;
    }


    /**
     * 最原始的
     * @param prices
     * @return
     */
    public int maxProfitOld(int[] prices) {
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
