package org.echarts.producedata;

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
}
