package baekjoon.문제집.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class p1_숫자야구 {
    static class Node{
        private String num;
        private int strike;
        private int ball;
        public Node(String num,int strike,int ball){
            this.num=num;
            this.strike=strike;
            this.ball=ball;
        }
    }
    public static void main(String[] args) throws IOException {
        int answer=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Node> list=new ArrayList<>();
            for(int i=0;i<n;i++) {
                String[] strs = br.readLine().split(" ");
                Node node=new Node(strs[0],Integer.parseInt(strs[1]),Integer.parseInt(strs[2]));
                list.add(node);
            }
                for(int num=111;num<=999;num++){
                    char[] callNumSplit=String.valueOf(num).toCharArray();
                    boolean[] passed=new boolean[list.size()];
                    if(callNumSplit[0]==callNumSplit[1]||callNumSplit[1]==callNumSplit[2]||callNumSplit[0]==callNumSplit[2]) continue;
                    if(callNumSplit[0]=='0'||callNumSplit[1]=='0'||callNumSplit[2]=='0') continue;
                    for(int i=0;i<list.size();i++){
                        boolean[] checked=new boolean[3];
                        Node node=list.get(i);
                        char[] resultNumSplit=node.num.toCharArray();
                        int strike=node.strike;
                        int ball=node.ball;
                        int sNum=0;
                        int bNum=0;

                        if(callNumSplit[0]==resultNumSplit[0]){
                            sNum++;
                            checked[0]=true;
                        }
                        if(callNumSplit[1]==resultNumSplit[1]){
                            sNum++;
                            checked[1]=true;
                        }
                        if(callNumSplit[2]==resultNumSplit[2]){
                            sNum++;
                            checked[2]=true;
                        }
                        if(node.num.contains(callNumSplit[0]+"")&&!checked[0]){
                            bNum++;
                        }
                        if(node.num.contains(callNumSplit[1]+"")&&!checked[1]){
                            bNum++;
                        }
                        if(node.num.contains(callNumSplit[2]+"")&&!checked[2]){
                            bNum++;
                        }
                        if(sNum==strike&&bNum==ball){
                            passed[i]=true;
                        }
                    }
                    for(int i=0;i<passed.length;i++){
                       if(passed[i]==false) break;
                       if(i== passed.length-1){
                           answer++;
                       }
                    }
                }
        System.out.println(answer);
    }
}
