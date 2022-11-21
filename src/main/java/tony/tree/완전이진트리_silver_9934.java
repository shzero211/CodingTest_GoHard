package tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 완전이진트리_silver_9934 {
    static int size;
    static int[] node;
    static ArrayList<Integer>[] nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        size=(int)Math.pow(2,k)-1;
        node=new int[size];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++){
            node[i]=Integer.parseInt(st.nextToken());
        }
        nodeList=new ArrayList[k];
        for(int i=0;i<k;i++){
            nodeList[i]=new ArrayList<>();
        }
        solve(0,size-1,0);
        for(int i=0;i<k;i++){
            for(int num:nodeList[i]){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    static void solve(int f,int e,int depth){
        if(f>e) return;
        int mid=(f+e)/2;
        nodeList[depth].add(node[mid]);
        solve(f,mid-1,depth+1);
        solve(mid+1,e,depth+1);
    }
}
