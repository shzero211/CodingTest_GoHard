package blog.velog.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지능형기차2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int pNum=0;
        int max=0;
        for(int i=0;i<10;i++){
            st=new StringTokenizer(br.readLine());
            int out=Integer.parseInt(st.nextToken());
            int in=Integer.parseInt(st.nextToken());
            pNum-=out;
            pNum+=in;
            max=Math.max(max,pNum);
        }
        System.out.println(max);
    }
}
