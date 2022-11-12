package baekjoon.teamNote.binarySearch;

import java.util.ArrayList;
import java.util.List;

public  class Search {
    //이분탐색으로 특정수가 있는지 확인
    public static boolean binarySearch(List<Integer> arr, int num){
        int start=0;
        int end=arr.size()-1;
        int mid=0;
        while(start<=end){
            mid=(start+end)/2;
            if(arr.get(mid)==num){
                return true;
            }
            if(arr.get(mid)<num){
                end=mid-1;
            }
            if(arr.get(mid)>num){
                start=mid+1;
            }
        }
        return false;
    }
}
