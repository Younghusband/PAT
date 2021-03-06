package yangfan.yi;

import java.io.BufferedInputStream;
import java.util.Scanner;

/*********************************************
 * PAT1003.java
 * Author: Vermouth.yf
 * Created on: 2017-10-19
 *
 * Details:  
 * 1003. 我要通过！(20)
 * 
 * “答案正确”是自动判题系统给出的最令人欢喜的回复。本题属于PAT的“答案正确”大派送 —— 只要读入的字符串满足下列条件，系统就输出“答案正确”，否则输出“答案错误”。

	得到“答案正确”的条件是：
	
	1. 字符串中必须仅有P, A, T这三种字符，不可以包含其它字符；
	2. 任意形如 xPATx 的字符串都可以获得“答案正确”，其中 x 或者是空字符串，或者是仅由字母 A 组成的字符串；
	3. 如果 aPbTc 是正确的，那么 aPbATca 也是正确的，其中 a, b, c 均或者是空字符串，或者是仅由字母 A 组成的字符串。
	现在就请你为PAT写一个自动裁判程序，判定哪些字符串是可以获得“答案正确”的。
	
	输入格式： 每个测试输入包含1个测试用例。第1行给出一个自然数n (<10)，是需要检测的字符串个数。接下来每个字符串占一行，字符串长度不超过100，且不包含空格。
	
	输出格式：每个字符串的检测结果占一行，如果该字符串可以获得“答案正确”，则输出YES，否则输出NO。
	
	输入样例：

		8
		PAT
		PAAT
		AAPATAA
		AAPAATAAAA
		xPATx
		PT
		Whatever
		APAAATAA
		
		输出样例：
		
		YES
		YES
		YES
		YES
		NO
		NO
		NO
		NO
	
	规律是   aPAAAAA...Taaaaa...
	      P之前的A的个数乘以 P与T之间的A的个数等于T之后的A的个数。
	      
	      提交后有两个测试点过不去... 烦   修改初校验规则后，依旧还有一个测试点过不去
 * 
 * 
 ********************************************/

public class PAT1003 {
	
      public static void main(String[] args) {
    	  Scanner scan = new Scanner(new BufferedInputStream(System.in));
    	  int lineNums = scan.nextInt();
    	  boolean [] flags = new boolean[lineNums];
    	  for(int i=0;i<lineNums;i++){
    		  String line = scan.next();
    		  flags[i]=judge(line);
    	  }
    	  
    	  for(int i=0;i<lineNums;i++){
    		  print(flags[i]);
    	  }
		
	}
      
      public static boolean judge(String xxx){
    	  int beforeP = 0;
    	  int beforeT = 0;
    	  int afterT = 0;       // afterT = beforeP * beforeT
    	  boolean flagP = false;
    	  boolean flagT = false;
    	  char [] charArr = xxx.toCharArray();
    	  for(int i=0;i<charArr.length;i++){
    		  if(charArr[i]!='P'&&charArr[i]!='T'&&charArr[i]!='A'){
                    return false;		  
    		  }else if(!flagP&&(charArr[i]!='A'&&charArr[i]!='P')){  //...x... P not as top
    			    return false;
    		  }else if(flagP&&beforeT==0&&charArr[i]!='A'){  // ...Px  x is not A
    			    return false;
    		  }else if(flagT&&charArr[i]!='A'){  // ..PA..T..  after T is only A or nothing
    			    return false;
    		  }
    			  
    		  //count A nums from different rigion
    		  if(charArr[i]=='A'){
    			  if(flagT){  
    				  afterT++;
    			  }
    			  else{
    				  if(flagP)
    					  beforeT++;
    				  else
    					  beforeP++;
    			  }
    		  }else {
    			  if(charArr[i]=='P')
    				  flagP = true;
    			  else
    				  flagT = true;
    		  }
    	  }
    	  if((afterT==beforeP*beforeT)&&beforeT!=0)
    		  return true;
    	  else
    		  return false;
    	  
      }
      
      public static void print(boolean flag){
    	  if(flag)
    		  System.out.println("YES");
    	  else
    		  System.out.println("NO");
      }
}
