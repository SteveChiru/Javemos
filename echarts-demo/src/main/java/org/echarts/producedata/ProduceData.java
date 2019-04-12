package org.echarts.producedata;

import org.junit.Test;

/**
 * @Description:
 */
public class ProduceData {

	public static void main(String[] args) {
		//定义复利利率
		//double[] cr = {1.05,1.1,1.15,1.2,1.25,1.3};
		double[] cr = {1.05,1.06,1.07,1.08,1.09,1.1};
		int[] years = {0,5,10,15,20,25,30,35,40,45,50};
		String data = new String();
		for (int i=0;i<cr.length;i++){
			for (int j=0;j<years.length;j++){
				if (j==0){
					data = "["+String.format("%.2f",Math.pow(cr[i],j*5)).toString()+",";
				}else if (j==years.length - 1){
					data += String.format("%.2f",Math.pow(cr[i],j*5)).toString()+"]";
				}else {
					data += String.format("%.2f",Math.pow(cr[i],j*5)).toString()+",";
				}
			}
			System.out.println("复利利率是"+cr[i]+"时的数据为"+data);
		}
	}

	/**
	 * 生产净资产收益率数据
	 */
	@Test
	public void produceRoe(){
		//市盈率PE
		double[] pe = {32.13,28.17,19.07,27.27,30.85,28.86,44.26,21.19,23.40,36.54,21.57,39.21,30.67,22.52,36.07,51.20,21.59,2304.71};
		//市净率PB
		double[] pb = {10.04,5.93,5.32,6.16,7.21,8.12,4.91,5.58,5.37,12.96,3.53,4.37,4.17,3.48,3.65,2.48,2.79,1.78};
		//净资产收益率ROE
		String roe = new String();
		//判断pe的个数和pb的个数是一致的
		if (pe.length == pb.length){
			for (int i=0;i<pe.length;i++){
				if (i==0){
					roe = "["+String.format("%.2f",pb[i]/pe[i]*100).toString()+",";
				}else if (i==pe.length - 1){
					roe += String.format("%.2f",pb[i]/pe[i]*100).toString()+"]";
				}else {
					roe += String.format("%.2f",pb[i]/pe[i]*100).toString()+",";
				}
			}
		}

		System.out.println("净资产收益率ROE是"+roe);
	}
}
