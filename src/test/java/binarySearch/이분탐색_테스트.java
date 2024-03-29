package binarySearch;

import baekjoon.teamNote.binarySearch.Search;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class 이분탐색_테스트 {
    @Test
    public void t1(){
        List<Integer> arr= Arrays.asList(1,7,6,5,4);
           assertEquals(Search.binarySearch(arr,5),true);
    }
    @Test
    public void lambda(){
        String[] strs=new String[]{"pp.txt","kk.txt","p.png"};
        Stream.of(strs).filter(x->x.contains(".png")==false).map(x->x.substring(x.indexOf('.')+1)).forEach(x->System.out.printf(x+" "));
    }
}
