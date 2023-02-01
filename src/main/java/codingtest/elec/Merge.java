package codingtest.elec;

import java.util.Arrays;
import java.util.HashSet;

public class Merge{

    public static String[] uniqNames(String[] names1, String[] names2) {
        /*
         * 답안 작성
         * 배열 합치기
         * 중복제거
         */
        //배열 합치기
        String[] newArray=new String[names1.length+names2.length];

        names1= Arrays.stream(names1).map(x->x.strip()).toArray(String[]::new);
        names2= Arrays.stream(names2).map(x->x.strip()).toArray(String[]::new);

        System.arraycopy(names1,0,newArray,0,names1.length);
        System.arraycopy(names2,0,newArray,names1.length,names2.length);

        //중복제거
        HashSet<String> set=new HashSet<>(Arrays.asList(newArray));

        // 순서보장
        String[] result=new String[set.size()];
        int idx=0;
        for(String str :newArray){
            if(set.contains(str)){
                set.remove(str);
                result[idx++]=str;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Seoul ", "Incheon", "Gyeonggi"};
        String[] names2 = new String[] {"Seoul", "Cheonan", "Busan"};
        /*
         * 답안 작성
         * 배열 합치기
         * 중복제거
         */
        Arrays.stream(uniqNames(names1, names2)).forEach(x-> System.out.println(x));
        // should print Seoul, Incheon, Gyeonggi, Cheonan, Busan
    }
}

