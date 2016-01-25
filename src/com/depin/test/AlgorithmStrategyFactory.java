package com.depin.test;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * 抽奖算法工厂类
 *
 * @author hudepin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AlgorithmStrategyFactory {
	private static AlgorithmStrategy algorithmStategy;
	
	private static Map<String,String> registMap= new HashMap<String,String>();
	
	static {
		registMap.put("TurnTable", "com.depin.test.TurnTableDrawLottery");
		registMap.put("Discrete", "com.depin.test.DiscreteDrawLottery");
		registMap.put("List", "com.depin.test.ListDrawLottery");
	}
	/**
	 * 
	 * 功能描述: <br>
	 * 初始化抽奖策略类，设置抽奖列表
	 *
	 * @param pairList 下标，概率的键值对列表
	 * @param algorithmStrategyType
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public static AlgorithmStrategy getAlgorithmStategyInstance(List<Pair> pairList,String algorithmStrategyType){
		
		try {
			Class c = Class.forName(registMap.get(algorithmStrategyType));
			 Constructor<?>[] constructorArray= c.getConstructors();
			 algorithmStategy = (AlgorithmStrategy) constructorArray[0].newInstance(pairList);
			 System.out.println("algorithmStategy:"+algorithmStategy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return algorithmStategy;
	}
}
