package baekjoon.문제집.삼성SW_기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_3190 {
    private static int[] dx={0,1,0,-1};
    private static int[] dy={1,0,-1,0};
    private static int x=0;
    private static int y=0;
    private static Map<Integer,String> directMap=new HashMap<>();
    private static List<int[]> snake=new ArrayList<>();
    private static int nowDirect=0;
    private static int time=0;

    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        m=Integer.parseInt(br.readLine());
        int[][] map=new int[m][m];
        int appleCnt=Integer.parseInt(br.readLine());

        //사과 생성
        for(int i=0;i<appleCnt;i++){
            String str=br.readLine();
            String[] strNum=str.split(" ");
            int x=Integer.parseInt(strNum[0])-1;
            int y=Integer.parseInt(strNum[1])-1;
            map[x][y]=1;
        }

        int turnCnt=Integer.parseInt(br.readLine());
        for(int i=0;i<turnCnt;i++){
            String str=br.readLine();
            String[] strNum=str.split(" ");
            int cnt=Integer.parseInt(strNum[0]);
            String direct= strNum[1];
            directMap.put(cnt,direct);
        }

        snake.add(new int[]{0,0});

        while(true) {

            time++;

            int nx = x + dx[nowDirect];
            int ny = y + dy[nowDirect];

            //벽 만났을 때
            if (nx < 0 || ny < 0 || nx >= m || ny >= m) {
                break;
            }
            //이전 몸 만났을때
            for (int i = 0; i < snake.size(); i++) {
                int[] beforeS = snake.get(i);
                if (beforeS[0] == nx && beforeS[1] == ny) {
                    break;
                }
            }

            //이동한곳에 사과가 있을때
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new int[]{nx, ny});
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            //방향 전환 해야할때
            if (directMap.containsKey(time)) {
                if (directMap.get(time).equals("D")) {
                    nowDirect++;
                    if (nowDirect == 4) {
                        nowDirect = 0;
                    }
                }else{
                    nowDirect--;
                    if (nowDirect==-1) {
                        nowDirect = 3;
                    }
                }
            }

            x = nx;
            y = ny;

        }
        System.out.println(time);
    }

    public static boolean isFinish(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= m || ny >= m) {
            return true;
        }

        for (int i = 0; i < snake.size(); i++) {
            int[] t = snake.get(i);
            if (nx == t[0] && ny == t[1])
                return true;
        }
        return false;
    }
}
