package tony.graph_traversal.silver.blog;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹 {
    static ArrayList<ArrayList> arr=new ArrayList<>();
    static boolean[] visited;
    static int virusMax=0;//최대 해킹수
    static int cnt=0;//특정 인덱스 시작시 해킹수

    static int[] virusCnt;
    private static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        virusCnt=new int[n+1];

        for(int i=0;i<=n;i++){
            arr.add(new ArrayList());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(b).add(a);
        }

        //각 노드에서 시작할경우
        for(int i=1;i<=n;i++){
            visited=new boolean[n+1];
            cnt=0;
            bfs(i);
            virusCnt[i]=cnt;
            virusMax=Math.max(virusMax,cnt);
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=n;i++){
            if(virusCnt[i]==virusMax){
                bw.write(i+" ");
            }
        }
        bw.flush();
        bw.close();
    }
    private static void bfs(int start){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        while (!queue.isEmpty()){
            int nowNode=queue.poll();
            ArrayList<Integer> list=arr.get(nowNode);
            for(int i=0;i<list.size();i++){
                int nextNode=list.get(i);
                if(!visited[nextNode]){
                    visited[nextNode]=true;
                    queue.add(nextNode);
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
