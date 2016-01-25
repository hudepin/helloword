/*
 * Copyright (C), 2013-2014, 上汽集团
 * FileName: Pair.java
 * Author:   wangjiayan
 * Date:     2014年12月19日 上午9:56:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.depin.test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author hudepin
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Pair<Left, Right> {
    
    public Left left;
    public Right right;
   
    public Pair(Left left, Right right) {
      this.left = left;
      this.right = right;
    }
   
   
    public Left getLeft() {
        return left;
    }


    public Right getRight() {
        return right;
    }

    public void setLeft(Left left) {
		this.left = left;
	}


	public void setRight(Right right) {
		this.right = right;
	}


	public String toString() {
      return "Pair[" + left + "," + right + "]";
    }
   
    private static boolean equals(Object x, Object y) {
      return (x == null && y == null) || (x != null && x.equals(y));
    }
   
    public boolean equals(Object other) {
       return
        other instanceof Pair &&
        equals(left, ((Pair)other).left) &&
        equals(right, ((Pair)other).right);
    }
   
    public int hashCode() {
      if (left == null) return (right == null) ? 0 : right.hashCode() + 1;
      else if (right == null) return left.hashCode() + 2;
      else return left.hashCode() * 17 + right.hashCode();
    }
   
    public static <A,B> Pair<A,B> of(A a, B b) {
      return new Pair<A,B>(a,b);
    }
  }