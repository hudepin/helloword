package com.depin.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 抽奖策略抽象类
 *
 * @author hudepin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class AlgorithmStrategy {

    public AlgorithmStrategy() {

    }

    /**
     * 抽奖奖品<下标，概率的键值对列表>
     */
    protected List<Pair> pairList = null;
    protected List<Integer> grid = null;
    protected Map<Integer, Integer> optionMap = null;
    protected int areaMax=10000;
    

    public int getAreaMax() {
        return areaMax;
    }

    public void setAreaMax(int areaMax) {
        this.areaMax = areaMax;
    }

    /**
     * 算法入口
     * 
     * @return
     */
    public int doRun() {
        // 初始化抽奖区域
        this.initOptionMap(pairList);
        this.initGrid();
        int result = this.operation();
        System.out.println("result:" + result);
        return result;
    }

    /**
     * 计算
     * 
     * @return
     */
    protected abstract int operation();

    /**
     * 传入奖项
     * 
     * @param pairList
     */
    protected abstract void initOptionMap(List<Pair> pairList);

    /**
     * 初始化原始数据占位
     */
    protected abstract void initGrid();

    /**
     * 计算每项在总概率的基础下的概率
     */
    protected void reCalculateProbability(List<Pair> pairList) {
        // 计算总概率，这样可以保证不一定总概率是1
        BigDecimal sumRate = BigDecimal.ZERO;
        for (Pair pair : pairList) {
            if (pair.getRight() instanceof Double) {
                if ((Double) pair.getRight() < 0) {
                    pair.setRight(BigDecimal.ZERO);
                }
                sumRate = (BigDecimal.valueOf((Double) pair.getRight())).add(sumRate);
            } else if (pair.getRight() instanceof BigDecimal) {
                if (((BigDecimal) pair.getRight()).doubleValue() < 0) {
                    pair.setRight(BigDecimal.ZERO);
                }
                sumRate = ((BigDecimal) pair.getRight()).add(sumRate);
            }

        }

        for (Pair pair : pairList) {
            if (pair.getRight() instanceof Double) {
                pair.setRight(((BigDecimal.valueOf((Double) pair.getRight())).divide(sumRate)));
            } else if (pair.getRight() instanceof BigDecimal) {
                pair.setRight((((BigDecimal) pair.getRight()).divide(sumRate)));
            }
            
        }
    }

}
