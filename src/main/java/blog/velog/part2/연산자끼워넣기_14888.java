package blog.velog.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {
    static int n;
    static int[] nums;
    static int[] op;
    static int  max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        nums=new int[n];
        op=new int[4];

        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            op[i]=Integer.parseInt(st.nextToken());
        }

        insert(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
    public static void insert(int num,int idx){
        if(idx==n){
            max=Math.max(max,num);
            min=Math.min(min,num);
            return;
        }
        for(int i=0;i<4;i++){
            if(op[i]!=0){
                op[i]--;
                if(i==0) insert(num+nums[idx],idx+1);
                if(i==1) insert(num-nums[idx],idx+1);
                if(i==2) insert(num*nums[idx],idx+1);
                if(i==3) insert(num/nums[idx],idx+1);
                op[i]++;
            }
        }
    }
}
