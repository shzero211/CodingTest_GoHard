package codingtest.sk;

import java.util.ArrayList;

public class sk2r {
    class Node{
        int idx;
        ArrayList<Node> inlist;

        Node(int idx){
            this.idx=idx;
            inlist=new ArrayList<>();
        }
        public int search(int num){

            for(Node node:inlist){
                num=node.search(num+1);
            }
            return num;
        }
    }
    public int[] solution(int[] p, int[] b) {
        int[] answer = new int[b.length];
        ArrayList boss=new ArrayList<>();
        ArrayList<Node> list = new ArrayList<>();
        for(int i=0;i<p.length;i++){
            list.add(new Node(i));
        }
        for(int i=0;i<p.length;i++){
            if(p[i]!=-1){
                list.get(p[i]).inlist.add(list.get(i));
            }else{
                boss.add(i);
            }
        }
        for(int i=0;i<b.length;i++){
            if(boss.contains(b[i])){
                answer[i]=list.get(b[i]).search(0)+1;
            }else{
                answer[i]=0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        sk2r sk2r=new sk2r();
        int[] arr=sk2r.solution(new int[]{-1,-1,-1,1,3,3,5,6,6},new int[]{0,1,2});
        for(int i=0;i<3;i++){
            System.out.println(arr[i]);
        }
    }
}
