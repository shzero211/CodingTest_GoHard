package baekjoon.tony.string.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
/*
* 풀이과정
* 1. 2개의 문자열 입력 받아서 시,분,초로 저장
* 2. 목표시간-현재시간 계산해서 -값이면 시는 +24,분초는 +60 하고 더큰시간 -1 하기
* */
public class 경고_3029 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] bt = br.readLine().split(":");
        String[] at = br.readLine().split(":");
        int h = Integer.parseInt(at[0]) - Integer.parseInt(bt[0]);
        int m = Integer.parseInt(at[1]) - Integer.parseInt(bt[1]);
        int s = Integer.parseInt(at[2]) - Integer.parseInt(bt[2]);

        if (s < 0) {
            s += 60;
            m--;
        }

        if (m < 0) {
            m += 60;
            h--;
        }

        if (h < 0) {
            h += 24;
        }
        if(h==0&&m==0&&s==0){
            System.out.println("24:00:00");
        }else{
            System.out.println(String.format("%02d:%02d:%02d",h,m,s));
        }
    }

    public static void main(String[] args) throws IOException {
    solution();
    }
}
