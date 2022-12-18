package blog.velog.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 멀티탭스케줄링_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] order=new int[k];//전자기기 사용순서 저장
        boolean[] isUsed=new boolean[k+1];//콘센트에 사용되었는지 확인하는 boolean
        int ans=0;
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            order[i]=Integer.parseInt(st.nextToken());
        }

        int put=0;
        for(int i=0;i<k;i++){
            int elect=order[i];//꽂을 전자기기

            if(!isUsed[elect]){ //안 꽂혀있으면
                if(put<n){ //콘센트가 꽉차있지 않다면
                    put++;
                    isUsed[elect]=true;
                }else{//콘센트가 꽉차 있는 경우
                    ArrayList<Integer> arr=new ArrayList();//나중에 다시 사용되는 콘센트 모음
                    for(int j=i+1;j<k;j++){
                        int electTemp=order[j];
                        if(isUsed[electTemp]&&!arr.contains(electTemp)){
                            arr.add(electTemp);
                        }
                    }
                    if(arr.size()<n){//나중에 사용되는 콘센트가 콘센트 개수보다 작다면
                        for(int j=0;j< isUsed.length;j++){
                            if(isUsed[j]&&!arr.contains(j)){//나중에 사용되지 않고 꽂혀있는것
                                isUsed[j]=false;//빼기
                                break;
                            }
                        }
                    }else{
                        int remove=arr.get(arr.size()-1);
                        isUsed[remove]=false;//뺴기
                    }
                    isUsed[elect]=true;//꽂기
                    ans++;//바뀐횟수 증가
                }
            }
        }
        System.out.println(ans);

    }
}
