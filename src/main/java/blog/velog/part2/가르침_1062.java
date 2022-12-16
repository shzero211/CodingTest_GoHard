package blog.velog.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침_1062 {
    static String[] words;
    static boolean[] visited;
    static int max=0;
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        words=new String[n];
        for(int i=0;i<n;i++){
            String str=br.readLine();
            str.replace("anta","");
            str.replace("tica","");
            words[i]=str;
        }
        if(k<5){
            System.out.println("0");
            return;
        }
        if(k==26){
            System.out.println(n);
            return;
        }
        visited=new boolean[26];
        visited['a'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;
        visited['i'-'a']=true;
        visited['c'-'a']=true;
        dfs(0,0);
        System.out.println(max);
    }
    public static void dfs(int alpha,int len){
        if(len==k-5){
            int cnt=0;
            for(int i=0;i<n;i++){//단언 순회
                boolean able=true;
                for(int j=0;j<words[i].length();j++){//단어 글자 한글자씩 순회
                    if(!visited[words[i].charAt(j)-'a']){
                        able=false;
                        break;
                    }
                }
                if(able)cnt++;
            }
            max=Math.max(max,cnt);
            return;
        }
        for(int i=alpha;i<26;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(i,len+1);
                visited[i]=false;
            }
        }
    }
}
