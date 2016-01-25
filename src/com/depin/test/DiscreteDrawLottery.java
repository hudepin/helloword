/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: DiscreteDrawLottery.java
 * Author:   hudepin
 * Date:     2015年11月27日 下午3:41:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.depin.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 大转盘抽奖离散算法实现类
 *
 * @author hudepin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DiscreteDrawLottery extends AlgorithmStrategy {
    public DiscreteDrawLottery(List<Pair> pairList) {
        super.pairList = pairList;
    }

    @Override
    protected int operation() {
        int hitOption = -1;
        long indexValue = Math.round(Math.random() * areaMax);
        hitOption = getResultIndex(indexValue);
//        hitOption = getResultIndex(0,grid.size(),indexValue);
        return hitOption;
    }

    private int getResultIndex(long indexValue) {
        //System.out.println("indexValue:"+indexValue);
        int i = 0;
        int j = 0;
        for (i=0; i < grid.size(); i++) {
            //System.out.println("grid each value:" + grid.get(i));
            if (indexValue <= grid.get(i)) {
                j = i;
                break;
            }
        }
        
        
        return j;

    }
    private long getResultIndex(int low,int high,long key)  
    {  
        if (low<=high)  
        {  
            int mid = (low+high)/2;  
            if(key == grid.get(mid))  
                return mid;  
            else if(key<grid.get(mid))  
                //移动low和high  
                return getResultIndex(low,mid-1,key);  
            else if(key>grid.get(mid))  
                return getResultIndex(mid+1,high,key);  
        }  
        else  {
            return -1;  
        }
        return -1;
          
    }  

    @Override
    protected void initOptionMap(List<Pair> pairList) {
        optionMap = new HashMap<Integer, Integer>();
        this.reCalculateProbability(pairList);
        BigDecimal big = new BigDecimal(10000);
        for (Pair pair : pairList) {
            if (pair.getLeft() != null && pair.getRight() != null) {
                optionMap.put((Integer) pair.getLeft(),
                        (int) (((BigDecimal) pair.getRight()).setScale(4, BigDecimal.ROUND_HALF_EVEN)).multiply(big)
                                .doubleValue());
            }
        }

    }

    @Override
    protected void initGrid() {
        grid = new ArrayList<Integer>();
        Iterator<Integer> it = optionMap.keySet().iterator();
        for (int i = 0; i < optionMap.size(); i++) {
            grid.add(i, new Integer(-1));
        }
        int index = 0;
        int value = 0;
        while (it.hasNext()) {
            Integer key = it.next();
            value += optionMap.get(key);
            grid.set(index, value);
            index++;
        }

    }

}
