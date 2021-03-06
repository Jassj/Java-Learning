package leetcode;

/**
 * description：
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @author yuanjie 2020/02/13 14:23
 */
public class BestTimeToBuyAndSellStock {

    private static int maxProfit(int[] prices) {
//        return maxProfitByIteration(prices);
        return maxProfitByIterationOptimization(prices);
    }

    // 一层循环遍历，从左往右记录最大利润和当前最小值
    private static int maxProfitByIterationOptimization(int[] prices) {
        int len = prices.length;
        int maxProfit = 0, curMinimum = Integer.MAX_VALUE;
        for(int i = 0 ; i <= len-1; i++) {
//            ①.plan1
//            curMinimum = Math.min(curMinimum, prices[i]);
//            maxProfit = Math.max(maxProfit, prices[i] - curMinimum);
//            ②.plan2
            if(prices[i] < curMinimum) {
                curMinimum = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - curMinimum);
            }
        }
        return maxProfit;
    }

    // 两层循环迭代获取所有可能情况，选取最大利润
    private static int maxProfitByIteration(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for(int i = 0 ; i <= len-1; i++) {
            for(int j = i; j <= len-1; j++) {
                maxProfit = Math.max(maxProfit, prices[j] > prices[i] ? prices[j] - prices[i] : 0);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int a[] = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
