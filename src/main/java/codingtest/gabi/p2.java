package codingtest.gabi;

import java.util.Arrays;

public class p2 {
    static boolean[] betCheck;
    static boolean[] dotCheck;
    static int [] sl;
    static int[] sd;
    static int[] betweenLen;
    static int answer;
    public int solution(int[] dots, int[] lines) {
        answer = Integer.MAX_VALUE;
        dotCheck=new boolean[dots.length];
        betCheck=new boolean[dots.length-1];
        betweenLen=new int[dots.length-1];
        sl=lines;
        sd=dots;
        //사잇값 초기화
        for(int i=0;i<dots.length-1;i++){
            betweenLen[i]=Math.abs(dots[i]-dots[i+1]);
        }

        for(int i=0;i<dots.length;i++){
            dotCheck= new boolean[dots.length];
            betCheck=new boolean[dots.length-1];
            dfs(i,0);
        }
        return answer;
    }
    public void dfs(int idx,int cnt){
        if(idx>sd.length-1){
            return;
        }
        if(check()){
            answer=Math.min(answer,cnt)+1;
            return;
        }
        for(int i=0;i< betweenLen.length;i++){
           if(betCheck[i]==true) continue;
            int centerIdx=0;
            int halfLen=betweenLen[i]/2;

            if((betweenLen[i]/2)%2==0){
                centerIdx=sd[idx]+ halfLen;
            }else{
                centerIdx=sd[idx]+ halfLen-1;
            }
            //덥히는 경우
            if(centerIdx-halfLen<=sd[idx]&&centerIdx+halfLen>=sd[idx+1]&&dotCheck.length>=idx+2){
                dotCheck[idx]=true;
                dotCheck[idx+1]=true;
                betCheck[i]=true;
                dfs(idx+2,cnt+1);
                dotCheck[idx]=false;
                dotCheck[idx+1]=false;
                betCheck[i]=false;
            }else{
                dotCheck[idx]=true;
                betCheck[i]=true;
                dfs(idx+1,cnt+1);
                dotCheck[idx]=false;
                betCheck[i]=false;
            }

        }
    }

    public boolean check(){
        for(int i=0;i<dotCheck.length-1;i++){
            if(dotCheck[i]!=true){
                return false;
            }
        }
        return true;
    }

}
