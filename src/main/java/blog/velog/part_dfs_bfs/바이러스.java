package blog.velog.part_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스 {
    static int c;
    static int l;
    static ArrayList<ArrayList<Integer>> arr;
    static int cnt=-1;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        c=Integer.parseInt(br.readLine());
        l=Integer.parseInt(br.readLine());
        visit=new boolean[c+1];
        arr=new ArrayList<>();
        for(int i=0;i<=c;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<l;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        dfs(1);
        System.out.println(cnt);
    }
    public static void dfs(int idx){
        if(visit[idx]){
            return;
        }

        visit[idx]=true;
        cnt++;

        for(int i=0;i<arr.get(idx).size();i++){
            int num=arr.get(idx).get(i);
            if(!visit[num]){
                dfs(num);
            }
        }
    }
}
