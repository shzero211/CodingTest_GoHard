package tony.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 구간합구하기5_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());//표의크기
        int[][] arr=new int[n+1][n+1];
        int m=Integer.parseInt(st.nextToken());//합의개수
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
            list.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
        int[][] dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+arr[i][j];
            }
        }
        for(int i=0;i<m;i++){
            int x1=list.get(i*2)[0];
            int y1=list.get(i*2)[1];

            int x2=list.get(i*2+1)[0];
            int y2=list.get(i*2+1)[1];

            System.out.println(dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]);
        }
    }
}
