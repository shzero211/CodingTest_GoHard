package codingtest.naver_finance;

import java.util.HashMap;
import java.util.Map;

public class p1 {
    public static int[] solution(int[] periods,int[][] payments,int[] estimates){
        int[] answer=new int[2];
       int GtoV=0;
       int VtoG=0;
        for(int i=0;i<periods.length;i++){
            int period=periods[i];
            int sum=0;
            int nextSum=0;
            for(int j=0;j<payments[i].length;j++){
                sum+=payments[i][j];
            }

            //90만원이상
            if(sum>=900000){
                if(period+1==24){
                    GtoV++;
                }
            }

            //60이상~90미만
            if(sum>=600000&&sum<900000){
                if(period+1==60){
                    GtoV++;
                }
                if(sum+estimates[i]>=900000){
                    GtoV++;
                }
            }

        }
        answer[0]=GtoV;
        answer[1]=VtoG;
        return answer;
    }
    public static void main(String[] args) {
    }
}
