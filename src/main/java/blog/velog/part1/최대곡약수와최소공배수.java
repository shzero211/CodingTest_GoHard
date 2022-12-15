package blog.velog.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대곡약수와최소공배수 {
    static int findMx(int a,int b){
        if(b==0){
            return a;
        }
        return findMx(b,a%b);
    }
    static int findMn(int a,int b){
        return a*b/findMx(a,b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        System.out.println(findMx(a,b));
        System.out.println(findMn(a,b));
    }
}
