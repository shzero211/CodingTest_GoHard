package 잡다한문제들;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 스티커_9465 {
    public static void main(String [] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());//행 개수

        //전체 반복 횟수
        for(int p=0;p<n;p++){
            int m=Integer.parseInt(br.readLine());//열 개수
            int[][] arr=new int[3][m+1];//스티커 배열

            //0번열 초기화
            for(int i=0;i<=2;i++){
                arr[i][0]=0;
            }

            //0번행 초기화
            for(int i=0;i<=m;i++){
                arr[0][i]=0;
            }

            //스티커 배열 입력
            for(int i=1;i<=2;i++){
                String numStr=br.readLine();
                String[] strs=numStr.split(" ");
                for(int j=1;j<=m;j++){
                    arr[i][j]=Integer.parseInt(strs[j-1]);
                }
            }

            for(int col=2;col<=m;col++){
                arr[1][col]=Math.max(arr[2][col-1],arr[2][col-2])+arr[1][col];
                arr[2][col]=Math.max(arr[1][col-1],arr[1][col-2])+arr[2][col];
            }
            System.out.println(Math.max(arr[1][m],arr[2][m]));
        }


    }
}
