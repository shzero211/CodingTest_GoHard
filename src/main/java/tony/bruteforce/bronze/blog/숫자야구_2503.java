package tony.bruteforce.bronze.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 숫자야구_2503 {
    static ArrayList<BaseBallData> arr=new ArrayList<>();
    static boolean[] find;
    static int resultNum=0;
    private static  class BaseBallData{
        int idx;
        int data;
        int strike;
        int ball;
        public BaseBallData(int idx,int data,int strike,int ball){
            this.idx=idx;
            this.data=data;
            this.strike=strike;
            this.ball=ball;
        }
        public boolean matchStrike(int num){
            String strData=String.valueOf(data);
            String strNum=String.valueOf(num);
            int numStrike=0;
            if(strData.charAt(0)==strNum.charAt(0)){
                numStrike++;
            }
            if(strData.charAt(1)==strNum.charAt(1)){
                numStrike++;
            }
            if(strData.charAt(2)==strNum.charAt(2)){
                numStrike++;
            }
            return strike== numStrike;
        }
        public boolean matchBall(int num){
            String strData=String.valueOf(data);
            String strNum=String.valueOf(num);
            int numBall=0;
            if(strData.contains(String.valueOf(strNum.charAt(0)))&&strData.charAt(0)!=strNum.charAt(0)){
                numBall++;
            }
            if(strData.contains(String.valueOf(strNum.charAt(1)))&&strData.charAt(1)!=strNum.charAt(1)){
             numBall++;
             }
            if(strData.contains(String.valueOf(strNum.charAt(2)))&&strData.charAt(2)!=strNum.charAt(2)){
                numBall++;
            }
            return numBall==ball;
        }
    }
    public static boolean checkNum(int num){
        String str=String.valueOf(num);
        if(str.charAt(0)==str.charAt(1)||str.charAt(1)==str.charAt(2)||str.charAt(2)==str.charAt(0)||str.charAt(0)=='0'||str.charAt(1)=='0'||str.charAt(0)=='0'){
            return true;
        }
        return false;
    }

    public static void solution() throws IOException {
        BufferedReader  br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            arr.add(new BaseBallData(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        for(int i=123;i<=987;i++){
            find=new boolean[n];
            if(checkNum(i)) continue;
           for(BaseBallData baseBallData:arr){
               if(!baseBallData.matchStrike(i))
                   break;
               if(!baseBallData.matchBall(i))
                   break;
               find[baseBallData.idx]=true;
               System.out.println(i+" "+baseBallData.data);
           }
           for(int j=0;j<n;j++){
               if(!find[j])
                   break;
               if(find[j]==true&&j==n-1)
                   resultNum++;
           }
        }
        System.out.println(resultNum);
    }
    public static void main(String[] args) throws IOException {
    solution();
    }
}
