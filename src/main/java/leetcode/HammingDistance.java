package leetcode;

/**
 * description
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 2^31.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 * @author yuanjie 2020/02/27 15:30
 */
public class HammingDistance {

    private static int hammingDistance(int x, int y) {
//        return hammingDistanceByBinaryString(x, y);
//        return hammingDistanceByXORAndBinaryString(x, y);
//        return hammingDistanceByRightShift(x, y);
//        return hammingDistanceByInternalFunction(x, y);
        return hammingDistanceByBitAlgorithm(x, y);
    }

    // 快速计算二进制中1的个数: 每次移除等于1的最右比特位, 与右移依次计算相比，减少了迭代操作
    private static int hammingDistanceByBitAlgorithm(int x, int y) {
        int distance = 0;
        int xor = x ^ y;
        while (xor != 0) {
            distance++;
            xor = xor & (xor - 1); // 此操作可移除等于1的最右比特位
        }
        return distance;
    }

    // 调用内置函数计算
    private static int hammingDistanceByInternalFunction(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // 右移并计算每一位是否为1
    private static int hammingDistanceByRightShift(int x, int y) {
        int distance = 0;
        int xor = x ^ y;
        while(xor != 0) {
            if((xor & 1) == 1) { // 检查最右位是否为1可以使用 xor & 1
                distance ++;
            }
            xor = xor >> 1;
        }
        return distance;
    }

    // 两数异或后转成无符号二进制字符串并逐位判断1的数量
    private static int hammingDistanceByXORAndBinaryString(int x, int y) {
        String binaryStr = Integer.toBinaryString(x ^ y);
        int distance = 0;
        for(int i = 0, lenX = binaryStr.length(); i < lenX; i++) {
            if(binaryStr.charAt(i) == '1') {
                distance++;
            }
        }
        return distance;
    }

    // int转成无符号二进制字符串后进行从低位逐位比较，默认比较32位
    private static int hammingDistanceByBinaryString(int x, int y) {
        String binaryX = Integer.toBinaryString(x);
        String binaryY = Integer.toBinaryString(y);
        int distance = 0;
        int lenX = binaryX.length();
        int lenY = binaryY.length();
        for(int i = 0; i <= 31; i++) {
            char charX, charY;
            if(i > lenX - 1) {  // 位数超过数组长度默认置0
                charX = '0';
            } else { // 从低位逐位比较
                charX = binaryX.charAt(lenX - i - 1);
            }
            if(i > lenY - 1) {
                charY = '0';
            } else {
                charY = binaryY.charAt(lenY - i - 1);
            }
            if(charX != charY) {
                distance++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(121, 4341));
    }
}

