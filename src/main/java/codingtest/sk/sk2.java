package codingtest.sk;

import java.util.ArrayList;
import java.util.List;

public class sk2 {
    public int[] solution(int[] p, int[] b) {
        int[] answer = {};
        int n=p.length;
        boolean[][] map=new boolean[n][n];
        int[] rowNum=new int[n];
        List<Integer> boss=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(p[i]==-1){
                boss.add(i);
            }
            else{
                map[p[i]][i]=true;
            }
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j< map.length;j++){
                if(map[i][j]==true) rowNum[i]++;
            }
        }

        for(int i=0;i<b.length;i++){
            if(boss.contains(b[i])){

            }else{
                answer[i]=0;
            }
        }
        return answer;
    }
}
