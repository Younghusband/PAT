package yangfan.yi;

import java.util.Scanner;

/*********************************************
 * Question1001.java
 * Author: Vermouth.yf
 * Created on: 2017-10-19
 *
 * Details:
 * 
 * 
	卡拉兹(Callatz)猜想：
	
	对任何一个自然数n，如果它是偶数，那么把它砍掉一半；如果它是奇数，那么把(3n+1)砍掉一半。这样一直反复砍下去，最后一定在某一步得到n=1。卡拉兹在1950年的世界数学家大会上公布了这个猜想，传说当时耶鲁大学师生齐动员，拼命想证明这个貌似很傻很天真的命题，结果闹得学生们无心学业，一心只证(3n+1)，以至于有人说这是一个阴谋，卡拉兹是在蓄意延缓美国数学界教学与科研的进展……
	我们今天的题目不是证明卡拉兹猜想，而是对给定的任一不超过1000的正整数n，简单地数一下，需要多少步（砍几下）才能得到n=1？
	
	输入格式：每个测试输入包含1个测试用例，即给出自然数n的值。
	输出格式：输出从n计算到1需要的步数。
	输入样例：
	3
	输出样例：
	5
 * 
 * 
 * 
 ********************************************/

public class PAT1001 {

	/**
	 * Author: Vermouth.yf 
	 * Date: 2017-10-19 
	 * @param args
	 * 
	 * 这题过于简单啊... 有没有办法在效率上进行优化呢？
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int n =0;
		
		while(num!=1){
			
			if(num%2==0){
				num/=2;
			}else{
				num = (3*num+1)/2;
			}
			n++;
		}
		
		System.out.println(n);

	}

}
