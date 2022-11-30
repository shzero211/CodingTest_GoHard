package tony.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 출석체크_20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int stuNum=Integer.parseInt(st.nextToken());
        int sleepStuNum=Integer.parseInt(st.nextToken());
        int checkStuNum=Integer.parseInt(st.nextToken());
        int line=Integer.parseInt(st.nextToken());
        int add,s,e=0;
        int[] dp=new int[stuNum+3];
        boolean[] sleep,chk;
        for(int i=3;i<=stuNum+2;i++){
            dp[i]=i;
        }
        sleep=new boolean[5005];
        chk=new boolean[5005];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<sleepStuNum;i++){
            int x=Integer.parseInt(st.nextToken());
            sleep[x]=true;
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<checkStuNum;i++){
            int x=Integer.parseInt(st.nextToken());
            if(sleep[x])continue;
            add=x;
            while(x<=stuNum+2){
                if(sleep[x]){
                    x+=add;
                }else{
                    chk[x]=true;
                    x+=add;
                }
            }
        }
        for(int i=3;i<=checkStuNum+2;i++){
            int a;
            if(!chk[i]){
                a=1;
            }else{
                a=0;
            }
            dp[i]=dp[i-1]+a;
        }
        for(int i=0;i<line;i++){
            st=new StringTokenizer(br.readLine());
            s=Integer.parseInt(st.nextToken());
            e=Integer.parseInt(st.nextToken());
            System.out.println(dp[e]-dp[s-1]);
        }

    }
}
