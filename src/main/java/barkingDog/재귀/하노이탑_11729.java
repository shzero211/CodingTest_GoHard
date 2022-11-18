package barkingDog.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑_11729 {
    public static StringBuilder sb = new StringBuilder();
    private static void hanoi(int a,int b,int num){
        if(num==1){
            sb.append(a+"  "+b+"\n");
            return;
        }
        //num-1개 다른위치로 이동
        hanoi(a,6-a-b,num-1);
        //원하는 위치로 원소이동
        hanoi(a,b,1);
        //다른위치에서 원하는 위치로 나머지 이동
        hanoi(6-a-b,b,num-1);
    }
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, num) - 1)).append('\n');
        hanoi(1,3,num);
        System.out.println(sb);
    }
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
