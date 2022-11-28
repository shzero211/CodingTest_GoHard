package tony.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원_배열의_합_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int line=Integer.parseInt(br.readLine());
        for(int i=0;i<line;i++){
            int sum=0;
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            for(int a=x1-1;a<x2;a++){
                for(int b=y1-1;b<y2;b++){
                    sum+=arr[a][b];
                }
            }
            System.out.println(sum);
        }

    }
}
