package org.echarts.producedata;

/**
 * @Description:
 */
public class Calculator {

	public static void main(String[] args) {
		//定投预算
		double total = 12*1000;
		//余额宝年化利率
		double yuEBaoRate = 2.287;
		//1.全部放入余额宝的话
		double result1 = total/100*2.287;
		System.out.println("资金全部放入余额宝的一年收益为："+result1);
		//2.拿出100元买指数基金，收益率超过5%卖出的话
		double result2 = (total-100)/100*2.87 + 5*365/7*5;
		System.out.println("拿出100元，超出5%则卖出的话"+result2);
	}
}
