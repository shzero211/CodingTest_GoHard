package baekjoon.tony.brute_force.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭_2798 {
    static int[] arr;
    static int n;
    static int max;
    static int maxhap;
    static int gap=Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        max= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
       arr=new int[n];
       visited=new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        bfs(0,0);
        System.out.println(maxhap);
    }
    public static void bfs(int cnt,int hap){
        if(cnt==3){
            if(gap>Math.abs(max-hap)&&hap<=max){
                gap=Math.abs(max-hap);
                maxhap=hap;
            }
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                bfs(cnt+1,hap+arr[i]);
                visited[i]=false;
            }
        }

    }
}
