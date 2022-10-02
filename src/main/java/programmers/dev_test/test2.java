package programmers.dev_test;

public class test2 {
    int[] dx={-1,0,1,0};
    int[]dy={0,1,0,-1};
    int[] dp=new int[26];
    int mx;
    int my;
    char[][] newmaps;
    public int solution(String[] maps) {
        mx= maps.length;
        my=maps[0].length();
        newmaps=new char[mx][my];
        for(int i=0;i<mx;i++){
            for(int j=0;j<my;j++){
                newmaps[i][j]=maps[i].charAt(j);
            }
        }
        for(int i=0;i<mx;i++){
            for(int j=0;j<my;j++){
                if(maps[i].charAt(j)!='.'){
                    dfs(i,j);
                }
            }
        }
        System.out.println(dp[0]);
        return 0;
    }
    public void dfs(int x,int y){
        if(newmaps[x][y]=='.'){
            return;
        }
        for(int i=0;i<4;i++){
            int moveX=x+dx[i];
            int moveY=y+dy[i];
            if(moveX>=0&&moveY>=0&&moveX<mx&&moveY<my){
                if(newmaps[x][y]!='.'){
                    int alphaNum=newmaps[x][y]-'A';
                    dp[alphaNum]++;
                    newmaps[x][y]='.';
                    dfs(moveX,moveY);
                }
            }
        }
    }
}
