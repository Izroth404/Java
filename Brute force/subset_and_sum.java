/*
  Find all the subset of a given array
  int arr[] = {1,2 3}
  Find all its subset             = {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}
  Now AND the elemnts int subset  =   1,   2,   3,     0,     1,     2,      0
  Now Add the numbers found through the previous method   = 1+2+3+0+2+0 = 9 (Ans)

  INPUT : 
  1
  3
  1 2 3
  
  OUTPUT:
  9

*/

import java.util.*;
import java.io.*;
public class tcs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (System.getProperty("ONLINE_JUDGE") == null) {
            try {
                System.setOut(new PrintStream(
                    new FileOutputStream("output.txt")));
                sc = new Scanner(new File("input.txt"));
            }
            catch (Exception e) {
            }
        }
        
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int limit = (int)Math.pow(n,2)-1;
            int setlen = Integer.toBinaryString(limit-1).length();
            int f=0 ;
            for (int i = 1; i < limit; i++) {
                String str = Integer.toBinaryString(i);
                if(str.length()<setlen){
                    for (int j = 0; j <= setlen-str.length(); j++) {
                        str = "0" + str;
                    }
                }
                int x = str.indexOf('1');
                int s = arr[str.indexOf('1')];
                // System.out.println(str);
                if(x!=str.length()-1){
                    // System.out.println("x="+x);
                    for(int j = x+1;j<str.length(); j++ ){
                        // System.out.println("j:" +j);
                        if(str.charAt(j)=='1'){
                            s&=arr[j];
                            // System.out.println("a: "+arr[j]);
                        }
                        
                    }
                }
                // System.out.println((str));
                // System.out.println();
                // System.out.println("S:" + s);
                f+=s;
                // System.out.println(s);
            }
            System.out.println(f);
        }
    }
}
