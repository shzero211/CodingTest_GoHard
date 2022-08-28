package baekjoon.tony.graph_traversal.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 봄버맨_16918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] inputs=br.readLine().split(" ");

        int a=Integer.parseInt(inputs[0]);
        int b=Integer.parseInt(inputs[1]);
        int c=Integer.parseInt(inputs[2]);

        char[][] map=new char[a][b];
        int[][] bombtime=new int[a][b];

        for(int i=0;i<a;i++){
            String tmp=br.readLine();
            for(int j=0;j<b;j++){
                map[i][j]=tmp.charAt(j);
                if(map[i][j]=='O')
                    bombtime[i][j]=3;
            }
        }

        int time=0;
        int[] mi={1,-1,0,0};
        int[] mj={0,0,1,-1};

        while(time++<c){

            if(time%2==0){
                for(int i=0;i<a;i++){
                    for(int j=0;j<b;j++){
                        if(map[i][j]=='.'){
                            map[i][j]='O';
                            bombtime[i][j]=time+3;
                        }
                    }
                }
            }else if(time%2==1){
                for(int i=0;i<a;i++){
                    for(int j=0;j<b;j++){
                        if(bombtime[i][j]==time){
                            map[i][j]='.';
                            for(int d=0;d<4;d++){
                                int ni=i+mi[d];
                                int nj=j+mj[d];
                                if(nj<0||ni<0||ni>=a||nj>=b)continue;
                                if(map[ni][nj]=='O'&&bombtime[ni][nj]!=time){
                                    map[ni][nj]='.';
                                    bombtime[ni][nj]=0;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < a; i++) {
            System.out.println(map[i]);
        }
    }
}
