package codingtest.sk;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sk1 {
    class Node{
        int time;
        int cnt;
        Node(int time,int cnt){
            this.time=time;
            this.cnt=cnt;
        }
    }
    public Object[] toMinAndCnt(String timeStr){
        StringTokenizer st=new StringTokenizer(timeStr," ");
        StringTokenizer nextst=new StringTokenizer(st.nextToken(),":");
        int h=Integer.parseInt(nextst.nextToken())*60;
        int m=Integer.parseInt(nextst.nextToken());
        int time=h+m;
        return new Object[]{time,Integer.parseInt(st.nextToken())};
    }
    public int solution(String[] bakery_schedule, String current_time, int k) {
        int answer = -2;
        List<Node> list=new ArrayList<>();
        for(String str:bakery_schedule){
            Object[] objects=toMinAndCnt(str);
            list.add(new Node((int)objects[0],(int)objects[1]));
        }
        Object[] objects=current_time.split(":");
        int currentTime=Integer.parseInt((String)objects[0])*Integer.parseInt((String)objects[1]);
        for(Node n:list){
            if(n.time>=currentTime){
                k=k-n.cnt;
                answer+=n.time-currentTime;
            }
        }
        if(k>0){
            return -1;
        }
        return answer;
    }
}
