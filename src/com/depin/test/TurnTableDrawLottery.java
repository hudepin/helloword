package com.depin.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * 大转盘抽奖简单算法实现类
 *
 * @author hudepin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TurnTableDrawLottery extends AlgorithmStrategy {
	
	public TurnTableDrawLottery(List<Pair> pairList){
		super.pairList=pairList;
	}
	
	/**
	 * 计算,这是最简单的区间算法
	 * @return
	 */
	@Override
	protected int operation(){
		int hitOption=-1;
		long index=Math.round(Math.random()*areaMax);
		if(index==areaMax){
			index=index-1;
		}
		hitOption=grid.get((int)index);
		
		return hitOption;
	} 
	
	@Override
	protected void initOptionMap(List<Pair> pairList) {
		// TODO Auto-generated method stub
		optionMap = new HashMap<Integer, Integer>();
	    this.reCalculateProbability(pairList);
	    BigDecimal big = new BigDecimal(10000);
        for(Pair pair: pairList){
            if(pair.getLeft()!=null && pair.getRight()!=null){
                optionMap.put((Integer)pair.getLeft(), (int)(((BigDecimal)pair.getRight()).setScale(4, BigDecimal.ROUND_HALF_EVEN)).multiply(big).doubleValue());
            }
        }
	}

	@Override
	protected void initGrid() {
		// TODO Auto-generated method stub
		grid=new ArrayList<Integer>();
		Iterator<Integer> it=optionMap.keySet().iterator();
		int position=0;
		for(int i=0;i<areaMax;i++){
			grid.add(i, new Integer(-1));
		}
		int size = grid.size();
		while(it.hasNext()){
			Integer key=it.next();
			Integer value=optionMap.get(key);
			for(Integer i=0;i<value;i++)
			{
			    if(position>=size){
			        break;
			    }
				grid.set(position, key);
				position++;
			}			
		}
//		System.out.println("----start 输出grid");
//		for(int i=0;i<grid.size();i++){
//		    System.out.println(grid.get(i));
//		}
//		System.out.println("----end 输出grid");
		
	}
	
}
