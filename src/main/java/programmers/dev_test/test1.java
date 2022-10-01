package programmers.dev_test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1 {
    public String solution(String[] registered_list, String new_id) {
        String answer = "";
        List<String> arr =Arrays.asList(registered_list);
        String temp=new_id;

        while(true){
            StringBuilder sb=new StringBuilder();
            if(!arr.contains(temp)){
                return temp;
            }else{
                String S=temp.replaceAll("[^a-z]","");
                String N=temp.replaceAll("[^0-9]","");
               if(!N.equals("")){
                   String N1=String.valueOf(Integer.parseInt(N)+1);
                   sb.append(S);
                   sb.append(N1);
                   temp=sb.toString();
                   continue;
               }else{
                   String N1="1";
                   sb.append(S);
                   sb.append(N1);
                   temp=sb.toString();
                   continue;
               }
            }
        }
    }
}
