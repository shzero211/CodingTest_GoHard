package blog.velog.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
          int num=  Integer.parseInt(br.readLine());
          String binary=Integer.toBinaryString(num);
          int idx=0;
          for(int j=binary.length()-1;j>=0;j--){
              if(binary.charAt(j)=='1'){
                  System.out.print(idx+" ");
              }
              idx++;
          }
        }
    }
}
