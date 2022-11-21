package tony.string.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
/*
* 문제풀이
* 1.알파벳의 빈도수를 확인하는 문제이기때문에 알파벳 크기 만큼 배열만듬
* 2.배열 인덱스== 알파벳 ,배열 값= 빈도수
* 3. 중복시 ?출력되도록 체크
* */
public class 복호화_9046 {
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         int line=Integer.parseInt(br.readLine());

         for(int i=0;i<line;i++){
             int [] idxAlp=new int [26];
             char [] strs=br.readLine().toCharArray();
             for(char str:strs){
                 //알파벳 저장
                 if(!(str==' ')){
                     idxAlp[str-'a']++;
                 }
             }
             //알파벳,빈도수 체크
             int max=0;
             for(int j=0;j<26;j++){
                 if(max<idxAlp[j]){
                     max=idxAlp[j];
                 }
             }
             //중복 체크
             int maxCnt=0;
             int idx=0;
             for(int k=0;k<26;k++){
                 if(max==idxAlp[k]){
                     maxCnt++;
                     idx=k;
                 }
             }

             if(maxCnt>1){
                 System.out.println("?");
             }else {
                 System.out.println((char)(idx+'a'));
             }
         }

    }
    public static void main(String[] args) throws IOException {
    solution();
    }
}
