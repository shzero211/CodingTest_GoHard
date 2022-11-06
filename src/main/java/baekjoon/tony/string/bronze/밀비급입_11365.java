package baekjoon.tony.string.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 밀비급입_11365 {
    /*
    * 풀이과정
    * 1.입력된 문자열 확인
    * 2.문자열 toCharArray로 문자로 쪼개기
    * 3.역순으로 문자를 sb에 추가
    * 4.띄어쓰기 문자추가
    *
    * */
    public static void solution() throws IOException {
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line=br.readLine();
            if(line.equals("END")){
                break;
            }
           char[] cs=line.toCharArray();
            for(int i=cs.length-1;i>=0;i--){
                sb.append(cs[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
