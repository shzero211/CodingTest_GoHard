package tony.graph_traversal.silver.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//처음으로  이중 Array List로 풀어봄
//인덱스를 적게사용하니 읽기 쉬움
//이중배열 구현은 이게 훨씬좋은듯
public class 바이러스_re {
    static ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
    static boolean[] visited;
    static int virus=0;
    public static void solution() throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int cNum=Integer.parseInt(br.readLine());
    int iNum=Integer.parseInt(br.readLine());
    visited=new boolean[cNum+1];

    //컴퓨터 개수만큼 리스트 추가(0번 째 컴퓨터는 무시됨으로 <=cNum)
    for(int i=0;i<=cNum;i++){
        arr.add(new ArrayList<>());
    }

    //컴퓨터 연관 관계추가(그래프를 생성)
    for(int j=0;j<iNum;j++){
        String[] idx=br.readLine().split(" ");
        int a=Integer.parseInt(idx[0]);
        int b=Integer.parseInt(idx[1]);
        arr.get(a).add(b);
        arr.get(b).add(a);
    }

    //탐색 순서를 저장
    Queue<Integer> queue=new LinkedList<>();
    queue.add(1);
    visited[1]=true;
    while(!queue.isEmpty()){
        int com=queue.poll();

        //감염된 컴퓨터와 연결되어있는 연관관계
        ArrayList<Integer> arrayList=arr.get(com);

        //연관관계 순회하면서 방문 하지 않은곳 감염시키기
        for(int i=0;i<arrayList.size();i++){
            int idx=arrayList.get(i);
           if(!visited[idx]){
               visited[idx]=true;
               virus++;
               queue.add(idx);
           }
        }
    }
        System.out.println(virus);
    }
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
