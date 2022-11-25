package tony.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class 파일정리_20291 {
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map=new HashMap<>();
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String str=br.readLine().split("[.]")[1];
            map.put(str,map.getOrDefault(str,0)+1);
        }
        Object[] keys=map.keySet().toArray();
        Arrays.sort(keys);
        for(Object key:keys){
            String s=(String)key;
            System.out.printf(s+" "+map.get(s));
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
