package blog.velog.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기 {
    static int[]table=new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int cnt=0;
        for(int i=2;i<=1000;i++){
            table[i]=i;
        }
        for(int i=2;i<=1000;i++){
            for(int j=i*2;j<=1000;j=j+i){
                table[j]=0;
            }
        }
        while(st.hasMoreTokens()){
            int num=Integer.parseInt(st.nextToken());
            if(table[num]!=0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
