package baekjoon.tony.brute_force.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피로도_22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
    int time=0;
    int work=0;
    int tired=0;
      while(time<=23){
          tired+=a;
          work+=b;
          if(tired>d){
              tired=tired-a-c;
              work=work-b;
          }
          if(tired<0){
              tired=0;
          }
          if(work<0){
              work=0;
          }
          time++;
      }
        System.out.println(work);
    }
}
