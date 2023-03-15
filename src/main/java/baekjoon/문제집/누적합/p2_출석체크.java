package baekjoon.문제집.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p2_출석체크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        List<Integer> list=new ArrayList<>();
        int[] arr=new int[n+4];
        Arrays.fill(arr,1);

        int sleepN=Integer.parseInt(st.nextToken());
        int sendN=Integer.parseInt(st.nextToken());
        int len=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<sleepN;i++){
            int sleepIdx=Integer.parseInt(st.nextToken());
            list.add(sleepIdx);
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<sendN;i++){
            int idx=Integer.parseInt(st.nextToken());
                for(int j=idx;j<n+3;j=j+idx){
                    if(list.contains(j)){
                        continue;
                    }
                    arr[j]=0;
                }
        }

        for(int i=3;i<n+3;i++){
            arr[i+1]+=arr[i];
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            st=new StringTokenizer(br.readLine());
            int before=arr[Integer.parseInt(st.nextToken())];
            int after=arr[Integer.parseInt(st.nextToken())];
            sb.append((after-before)+"\n");
        }
        System.out.println(sb.toString());
    }
}
