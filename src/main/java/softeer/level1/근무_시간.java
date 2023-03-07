package softeer.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 근무_시간 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        int time=0;
        for(int i=0;i<5;i++){
           st=new StringTokenizer(br.readLine()," ");
            int[] before= Arrays.stream(st.nextToken().split(":")).mapToInt(x-> Integer.parseInt(x)).toArray();
            int[] after= Arrays.stream(st.nextToken().split(":")).mapToInt(x-> Integer.parseInt(x)).toArray();
            int beforeTime=before[0]*60+before[1];
            int afterTime=after[0]*60+after[1];
            time+=afterTime-beforeTime;
        }
        System.out.println(time);
    }
}
