package com.example.leetcode_sha_2.jian_zhi_offer;

public class s43 {

    public static void main(String[] args) {

    }

//    输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
//    例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;

    }

}
