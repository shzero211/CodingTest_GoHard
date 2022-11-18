package barkingDog.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//문제풀이
//1.연산의 과정에서 나누기를 빠르게 해줘야 long 의 범위를 넘지 않는다.
//2.모듈러 연산과 지수 법칙을 사용해서 점화식으로 찾고자하는 값을 분해 할수있다.
public class 곱셈_1629 {
    private static long powAndMod(long a,long b,long c){
        if(b<=1){
            return a%c;
        }
        long temp=powAndMod(a,b/2,c);
        if(b%2==0){
            return temp*temp%c;
        }
        return (temp*temp%c)*a%c;
    }
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] num=br.readLine().split(" ");
        int a=Integer.parseInt(num[0]);
        int b=Integer.parseInt(num[1]);
        int c=Integer.parseInt(num[2]);
        System.out.println(  powAndMod(a,b,c));
    }
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
