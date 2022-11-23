package tony.bruteforce.bronze.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합_2231 {
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        int result=0;
        for(int i=num;i>=0;i--){
            int temp=i;//자리수 연산을 위한 변수
            int sum=temp;//num과 비교하기 위한 sum
           while(temp!=0){
               sum+=temp%10;
               temp=temp/10;
           }
            if(sum==num){
                result=i;
            }
            System.out.println(i+" "+sum);
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
