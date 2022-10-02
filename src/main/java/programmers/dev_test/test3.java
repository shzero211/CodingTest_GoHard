package programmers.dev_test;

public class test3 {
    int[] stick={6,2,5,5,4,5,6,3,7,6};
    boolean[] visited=new boolean[10];
    int cnt=0;
    public long solution(int k) {
        dfs(k,0,"");
        return cnt;
    }
    public void dfs(long stick_sum,long sum,String str){
        if(sum>=stick_sum){
            if(sum==stick_sum){
                if(str.equals("0 ")){
                    cnt++;
                    return;
                }
                if(str.startsWith("0 ")){
                    return;
                }
                cnt++;
            }
            return ;
        }
        for(int i=0;i<stick.length;i++){
            dfs(stick_sum,sum+stick[i],str+i+" ");
        }
        return;
    }
}
