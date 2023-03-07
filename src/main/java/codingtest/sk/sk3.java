package codingtest.sk;

public class sk3 {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    String map[][];
    int n=0;
    public int[] solution(String[][] boards) {
        int[] answer = new int[boards.length];
        n=boards[0].length;
        for(int i=0;i<boards.length;i++){
            map=new String[n][n];
            int oneCnt=0;
            int threeCnt=0;
            for(int j=0;j<boards[i].length;j++){
               for(int k=0;k<boards[i][j].length();k++){
                   map[j][k]=boards[i][j].charAt(k)+"";
                   if(map[j][k].equals("1")) oneCnt++;
               }
            }

            for(int j=0;j<boards[i].length;j++){
                for(int k=0;k<boards[i][j].length();k++){
                    if(map[j][k].equals("2")){
                        for(int p=0;p<4;p++){
                            dfs(j,k,dx[p],dy[p]);
                        }
                    }
                }
            }

            for(int j=0;j<boards[i].length;j++){
                for(int k=0;k<boards[i][j].length();k++){
                    if(map[j][k].equals("3")) threeCnt++;
                }
            }

            if(oneCnt==threeCnt){
                answer[i]=1;
            }else{
                answer[i]=0;
            }

        }

        return answer;
    }
    public void dfs(int x,int y,int r,int c){
        map[x][y]="3";
        int mx=x+r;
        int my=y+c;
        if(mx<0||mx>=n||my<0||my>=n) return;
        if(map[mx][my].equals("2")||map[mx][my].equals("1")){
            dfs(mx,my,r,c);
        }

    }
}
