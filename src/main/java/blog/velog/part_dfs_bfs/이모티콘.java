package blog.velog.part_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘 {
    public static class Step{
        int emo_num;
        int clip_num;
        int time;
        public Step(int emo_num,int clip_num,int time){
            this.emo_num=emo_num;
            this.clip_num=clip_num;
            this.time=time;
        }
    }
    public static void main(String[] args) throws IOException {
        boolean[][] visited=new boolean[2001][2001];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int s=Integer.parseInt(br.readLine());
        Queue<Step> queue=new LinkedList<>();
        queue.add(new Step(1,0,0));
        while (!queue.isEmpty()){
            Step step=queue.poll();
            int emo_num= step.emo_num;
            int clip_num=step.clip_num;
            int time= step.time;
            if(emo_num==s){
                System.out.println(time);
                return;
            }
            if(emo_num>0&&emo_num<2000){
                //복사
                if(!visited[emo_num][emo_num]){
                    visited[emo_num][emo_num]=true;
                    queue.add(new Step(emo_num,emo_num,time+1));
                }
                //삭제
                if(!visited[emo_num-1][clip_num]){
                    visited[emo_num-1][clip_num]=true;
                    queue.offer(new Step(emo_num-1,clip_num,time+1));
                }
            }

            if(clip_num>0&&emo_num+clip_num<2000){
                if(!visited[emo_num+clip_num][clip_num]){
                    visited[emo_num+clip_num][clip_num]=true;
                    queue.offer(new Step(emo_num+clip_num,clip_num,time+1));
                }
            }
        }
    }
}
