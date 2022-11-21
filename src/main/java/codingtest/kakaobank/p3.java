package codingtest.kakaobank;

public class p3 {
    static  boolean[] visited;
    static int[] arr;
    static int answer=0;
    static int visi=0;
    static int min=Integer.MAX_VALUE;
    public static  int solution(int[] rooms) {
        arr=rooms;

        for(int i=0;i<rooms.length;i++){
                 visited=new boolean[rooms.length];
                 answer=1;
                visited[i]=true;
                search(i);
                visi++;
            if(min>answer){
                min=answer;
            }
        }
        return min-1;
    }
    public static void search(int idx){
        if(visi==arr.length){
            return;
        }
        if(!visited[idx]){
            visited[idx]=true;
            search(arr[idx]-1);
            visi++;
        }else{
            for(int i=0;i<arr.length;i++){
                if(!visited[i]){
                    visited[idx]=true;
                    search(i);
                    answer++;
                    visi++;
                }
            }
        }
    }
    public static void main(String[] args) {
        solution(new int[]{2,3,4,5,1});
    }
}
