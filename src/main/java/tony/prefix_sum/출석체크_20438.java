package tony.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 출석체크_20438 {
    public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    int stuN=Integer.parseInt(st.nextToken());//학생수
    int sleepN=Integer.parseInt(st.nextToken());//졸고있는 학생수
    int visitN=Integer.parseInt(st.nextToken());//출석코드 보낸수
    int lineN=Integer.parseInt(st.nextToken());//주어진 구간 수
        boolean[] v=new boolean[stuN+3];//출석 체크 표시
    List<Integer> sleepList=new ArrayList<>();
    st=new StringTokenizer(br.readLine());
    for(int i=0;i<sleepN;i++){
        sleepList.add(Integer.parseInt(st.nextToken()));
    }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<visitN;i++){
            int x=Integer.parseInt(st.nextToken());
            if(sleepList.contains(x)) continue;
            for(int j=x;j<stuN+3;j++){
                //배수이면
                if(j%x==0){
                    if(!sleepList.contains(j)){
                        v[j]=true;
                    }
                }
            }
        }
        int[] cumSum=new int[stuN+3];
        for(int i=3;i<cumSum.length;i++){
            cumSum[i]=cumSum[i-1]+(v[i]?0:1);
        }
        for(int i=0;i<lineN;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            System.out.println(cumSum[e]-cumSum[s-1]);
        }





    }
}
