package tony.bruteforce.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수학은_비대면강의입니다_19532 {
    private  static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int a=Integer.parseInt(str[0]);
        int b=Integer.parseInt(str[1]);
        int c=Integer.parseInt(str[2]);
        int d=Integer.parseInt(str[3]);
        int e=Integer.parseInt(str[4]);
        int f=Integer.parseInt(str[5]);
        for(int i=-999;i<=999;i++){
            for(int j=-999;j<=999;j++){
                if(a*i+b*j==c&&d*i+e*j==f){
                    System.out.println(i+" "+j);
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
    solution();
    }
}
