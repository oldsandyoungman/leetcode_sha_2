package com.example.leetcode_sha_2.grammar_test;

import java.util.ArrayList;
import java.util.List;

public class test_generics {

    public static void main(String[] args) {

//        List<String> stringArrayList = new ArrayList<String>();
//        List<Integer> integerArrayList = new ArrayList<Integer>();
//
//        Class classStringArrayList = stringArrayList.getClass();
//        Class classIntegerArrayList = integerArrayList.getClass();
//
//        if(classStringArrayList.equals(classIntegerArrayList)){
//            System.out.println("泛型测试，类型相同");
//        }

//        List<String>[] lsa = new List<String>[10]; // Not really allowed.
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li; // Unsound, but passes run time store check
//        String s = lsa[1].get(0); // Run-time error: ClassCastException.


//        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(3);
//        oa[1] = li; // Correct.
//
//        List<String> lli = new ArrayList<String>();
//        lli.add("13");
//        oa[2] = lli; // Correct.
//
//        Integer i = (Integer) lsa[1].get(0); // OK
//        String ii = (String) lsa[2].get(0);


        test1(123);
        test1("123");


    }

    public static <T> void test1(T a) {
        Class<?> aClass = a.getClass();
        System.out.println(aClass);

    }


}
