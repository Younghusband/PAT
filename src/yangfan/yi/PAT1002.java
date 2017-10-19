package yangfan.yi;

import java.util.Scanner;

/*********************************************
 * PAT1002.java
 * Author: Vermouth.yf
 * Created on: 2017-10-19
 *
 * 1002. 写出这个数 (20)
		时间限制
		400 ms
		内存限制
		65536 kB
		代码长度限制
		8000 B
		判题程序
		Standard
		作者
		CHEN, Yue
		
		读入一个自然数n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
		
		输入格式：每个测试输入包含1个测试用例，即给出自然数n的值。这里保证n小于10100。
		
		输出格式：在一行内输出n的各位数字之和的每一位，拼音数字间有1 空格，但一行中最后一个拼音数字后没有空格。
		输入样例：
		
		1234567890987654321123456789
		
		输出样例：

		yi san wu

                       测试点1 无法通过。。。  不知道啥原因
 ********************************************/

public class PAT1002 {
	
	public static void main(String[] args) {
		
		String src = "";
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		src = scan.next();
		char [] cArr = src.toCharArray();
		
		for(int i=0;i<cArr.length;i++){
			int temp = Integer.parseInt(cArr[i]+"");
			sum+=temp;
		}
		printPinyin(sum);
	}
	
	public static void printPinyin(int n){
		
		String x = String.valueOf(n);
		char [] c = x.toCharArray();   // {'1','3','5'}
		
		for(int i=0;i<c.length;i++){
			
			switch(c[i]) {
			case '1':
				System.out.print("yi");
			break;
			case '2':
				System.out.print("er");
			break;
			case '3':
				System.out.print("san");
			break;
			case '4':
				System.out.print("si");
			break;
			case '5':
				System.out.print("wu");
			break;
			case '6':
				System.out.print("liu");
			break;
			case '7':
				System.out.print("qi");
			break;
			case '8':
				System.out.print("ba");
			break;
			case '9':
				System.out.print("jiu");
			break;
			default :
				System.out.print("lin");
			break;
			
			}
			if(i!=c.length-1){
				System.out.print(" ");
			}
			
		}
		
	}
}
