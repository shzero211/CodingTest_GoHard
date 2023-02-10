package blog.velog.part_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨박꼭질2 {
    static int a,b,cnt=0,time;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());

        if (a >= b) {
            System.out.println((a-b) + "\n1");
            return;
        }
        bfs();
        System.out.println(time);
        System.out.println(cnt);
    }
    public static void bfs(){
        int visit[]=new int[100001];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(a);
        visit[a]=1;
        while(!queue.isEmpty()){
            int now=queue.poll();
            for(int i=0;i<3;i++){
                int next=0;
                if(i==0)    next=now+1;
                if(i==1)    next=now-1;
                if(i==2)    next=now*2;
                if(next<0||next>100000) continue;
                if(next==b) {
                    time=visit[now];
                    cnt++;
                }
                if(visit[next]==0||visit[next]==visit[now]+1){
                    queue.add(next);
                    visit[next]=visit[now]+1;
                }
            }
        }

    }

}
