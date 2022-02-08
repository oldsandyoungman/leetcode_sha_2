package com.example.leetcode_sha_2.leetcode_origin;

public class s43 {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

//    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
//    注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/multiply-strings
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String multiply(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();

        int n1 = s1.length;
        int n2 = s2.length;
        int[] res = new int[n1+n2];

        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                // int t1 = s1[i] - '0';
                // int t2 = s2[j] - '0';
                // int tmp = t1*t2;
                // res[i+j] += tmp/10;
                // res[i+j+1] += tmp%10;
                // if(res[i+j+1]>9){
                //     res[i+j]++;
                //     res[i+j+1] -= 10;
                // }
                // if(res[i+j]>9){
                //     res[i+j-1]++;
                //     res[i+j] -= 10;
                // }


                int t1 = s1[i] - '0';
                int t2 = s2[j] - '0';
                int tmp = t1*t2 + res[i+j+1];
                res[i+j] += tmp/10;
                res[i+j+1] = tmp%10;


            }
        }

        int i=0;
        while(i<n1+n2 && res[i]==0){
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(;i<n1+n2;i++){
            sb.append(res[i]);
        }

        return sb.length()==0?"0":sb.toString();

    }

}
