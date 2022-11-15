package barkingDog.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳갯수_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] chars= br.readLine().toCharArray();
        int[] arr=new int[26];
        for(int i=0;i<chars.length;i++){
            arr[chars[i]-'a']++;
        }
        for(int i=0;i<26;i++){
            System.out.printf(arr[i]+" ");
        }

    }
}
