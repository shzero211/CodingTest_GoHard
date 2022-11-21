package tony.bruteforce.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 블랙잭_2798 {
        static int hap;
        static int n;
        static int max=0;
        static Integer[] cardNum;
        static  boolean visited[];
    private static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] num=br.readLine().split(" ");
         n=Integer.parseInt(num[0]);
        hap=Integer.parseInt(num[1]);
        cardNum= Arrays.stream(br.readLine().split(" ")).map(x->Integer.parseInt(x)).toArray(Integer[]::new);
        visited=new boolean[n];
        dfs(0,0,0);
        System.out.println(max);
    }
    private static void dfs(int idx,int dHap,int cnt){
        if(cnt==3){
            if(max<dHap&&dHap<=hap){
                max=dHap;
            }
            return;
        }
        for(int i=idx;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(i,dHap+cardNum[i],cnt+1);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
