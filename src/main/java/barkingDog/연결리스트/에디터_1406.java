package barkingDog.연결리스트;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class 에디터_1406 {
    //풀이 고민 과정
    //1. 자료가 수정,삭제가 빈번-> linkedList 사용하자
    //2.LinkedList 로 구현해보았지만 시간 초과발생
    //3.검색해보니 커서의 개념을 사용할수있는 listIterator 발견
    //4.적용
    private static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars=br.readLine().toCharArray();
        LinkedList<Character> linkedList=new LinkedList<>();
        for(char c:chars){
            linkedList.add(c);
        }

        ListIterator<Character> iter=linkedList.listIterator();
        while(iter.hasNext()){
            iter.next();
        }

        int line=Integer.parseInt(br.readLine());
        for(int i=0;i<line;i++){
            String str=br.readLine();
            char c=str.charAt(0);

            if(c=='L'){
                if(iter.hasPrevious()){
                    iter.previous();
                }
            }

            if(c=='D'){
                if(iter.hasNext()){
                    iter.next();
                }
            }

            if(c=='B'){
              if(iter.hasPrevious()){
                  iter.previous();
                  iter.remove();
              }
            }

            if(c=='P'){
                char nextC=str.charAt(2);
                iter.add(nextC);
            }
        }
        for(Character chr : linkedList) {
            bw.write(chr);
        }
        bw.flush();
        bw.close();
    }
    public static void main(String[] args) throws IOException {
    solution();
    }
}
