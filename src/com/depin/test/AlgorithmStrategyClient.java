package com.depin.test;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmStrategyClient {

    @SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
    public static void main(String[] args) {
        AlgorithmStrategyFactory algorithmStrategyFactory = new AlgorithmStrategyFactory();
//        List<Pair> pairList = new ArrayList<Pair>();
//        Pair pair = new Pair(0, 0.01);
//        Pair pair2 = new Pair(1, 0.25);
//        Pair pair3 = new Pair(2, 0.45);
//        Pair pair4 = new Pair(3, 0.29);
//        pairList.add(pair);
//        pairList.add(pair2);
//        pairList.add(pair3);
//        pairList.add(pair4);
//        System.out.println("before ");
//        AlgorithmStrategy algorithmStrategy = algorithmStrategyFactory.getAlgorithmStategyInstance(pairList,
//                "TurnTable");
//        long time1 = System.currentTimeMillis();
//        for (int i = 0; i < 100; i++) {
//            algorithmStrategy.doRun();
//        }
//        System.out.println("简单算法时间：" + (System.currentTimeMillis() - time1));
//        //algorithmStrategy.doRun();
//        System.out.println("after ");
//        //System.out.println(Math.random());

//        List<Pair> pairList2 = new ArrayList<Pair>();
//        Pair pair21 = new Pair(0, 0.01);
//        Pair pair22 = new Pair(1, 0.25);
//        Pair pair23 = new Pair(2, 0.45);
//        Pair pair24 = new Pair(3, 0.29);
//        pairList2.add(pair21);
//        pairList2.add(pair22);
//        pairList2.add(pair23);
//        pairList2.add(pair24);
//        System.out.println("before ");
//        AlgorithmStrategy algorithmStrategy2 = algorithmStrategyFactory.getAlgorithmStategyInstance(pairList2,
//                "Discrete");
//        long time2 = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            algorithmStrategy2.doRun();
//        }
//        System.out.println("离散算法时间：" + (System.currentTimeMillis() - time2));
//        //algorithmStrategy2.doRun();
//        System.out.println("after ");
        
        List<Pair> pairList2 = new ArrayList<Pair>();
        Pair pair21 = new Pair(0, 0.01);
        Pair pair22 = new Pair(1, 0.25);
        Pair pair23 = new Pair(2, 0.45);
        Pair pair24 = new Pair(3, 0.29);
        pairList2.add(pair21);
        pairList2.add(pair22);
        pairList2.add(pair23);
        pairList2.add(pair24);
        System.out.println("before ");
        AlgorithmStrategy algorithmStrategy3 = algorithmStrategyFactory.getAlgorithmStategyInstance(pairList2,
                "List");
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            algorithmStrategy3.doRun();
        }
        System.out.println("离散算法时间：" + (System.currentTimeMillis() - time2));
        //algorithmStrategy2.doRun();
        System.out.println("after ");
    }
}
