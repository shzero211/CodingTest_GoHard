package tony.bruteforce.bronze.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트래킹 사용
public class 블랙잭_2798 {
    static int[] arr;
    static boolean[] visited;
    static int result=0;
    static int abs=Integer.MAX_VALUE;
    static int m;
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n];
        visited=new boolean[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(result);
    }

    private static void dfs(int tempSum,int tempNum){
        if(tempNum==3){
            if(abs>m-tempSum&&m>=tempSum){
                abs=m-tempSum;
                result=tempSum;
            }
            return;
        }
        for(int i=0;i<arr.length;i++){
           if(!visited[i]){
               visited[i]=true;
               dfs(tempSum+arr[i],tempNum+1);
               visited[i]=false;
           }
        }
    }

    public static void main(String[] args) throws IOException {
    solution();
    }
}
