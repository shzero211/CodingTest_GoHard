package blog.velog.part_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB {
    static long min=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        dfs(a,1,b);
        if(min==Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
    public static void dfs(long num,long cnt,long limit){
        if(num>=limit){
            if(num==limit) min=Math.min(min,cnt);
            return;
        }
        dfs(num*2,cnt+1,limit);
        dfs(num*10+1,cnt+1,limit);
    }
}
