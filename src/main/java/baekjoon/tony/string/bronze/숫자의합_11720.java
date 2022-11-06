package baekjoon.tony.string.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합_11720 {
    /*
    * 구현과정
    * 1.입력받기
    * 2.숫자문자열을 쪼개서 문자배열에 넣기
    * 3.sum 구하기
    * 4.sum 출력
    * */
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] strs=br.readLine().split("");
        int sum=0;
        if(n==strs.length){
            for(String str:strs){
                sum+=Integer.parseInt(str);
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
