package com.example.leetcode_sha_2.wangyi_leihuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sha3 {

//    20 3
//I am coordinator of the Latin video games Federation. I'm born, member of the UWOOyan game Developers Association.



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        String s = in.nextLine();
        s = in.nextLine();

        char[] ss = s.toCharArray();
        int n = ss.length;

        List<String> res = new ArrayList<>();

        int left = 0;
        int right = 0;

        while(left<n){
            right = left + N - 1;
            if(right<n){
                if(ss[right]==' '){
                    // 如果是空格，直接删，前面无论是字母还是标点都可以
                    String cur = s.substring(left, right);
                    res.add(cur);
                    left = right+1;
                }else{
                    // 如果是字母或者标点（标点因为有I'm，所以也视作字母处理）
                    int origin_right = right;
                    right++;
                    while( right<n && ((ss[right]>='a' && ss[right]<='z') || (ss[right]>='A' && ss[right]<='Z') || ss[right]=='\'')){
                        right++;
                    }
                    // 别忘了减一
                    if(right-1-origin_right<=M){
                        if(right<n && ss[right]!=' '){
                            // 如果是标点的话
                            right++;
                            String cur = s.substring(left, right);
                            res.add(cur);
                            // 标点后面可能是空格，也可能是字母要分情况
                            if(right<n && ss[right]==' '){
                                left = right+1;
                            }else{
                                left = right;
                            }
                        }else{
                            // 如果是空格的话
                            String cur = s.substring(left, right);
                            res.add(cur);
                            // 空格后面应该不是标点，肯定是字母
                            left = right+1;
                        }
                    }else{
                        right = origin_right;
                        right--;
                        while(right>=0 && ((ss[right]>='a' && ss[right]<='z') || (ss[right]>='A' && ss[right]<='Z') || ss[right]!=' ') ){
                            right--;
                        }
                        // 出来一定是空格，空格前面无论是标点还是字母都ok
                        String cur = s.substring(left, right);
                        res.add(cur);
                        left = right + 1;
                    }
                }
            }else{
                String cur = s.substring(left, n);
                res.add(cur);
                left = n;
            }

        }

        System.out.println(res.size());

        for(String cur : res){
            System.out.println(cur);
        }

    }
}
