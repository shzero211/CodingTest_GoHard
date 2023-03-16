package codingtest.gabi;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;

public class p1 {
    class Student implements Comparable<Student>{
        private String name;
        private int score;
        public Student(String name,int score){
            this.name=name;
            this.score=score;
        }
        public int getScore(){
            return score;
        }
        public String getName(){
            return name;
        }
        public void setScore(int score){
            this.score=score;
        }
        //내림차순
        //같으면 들어온 순서
        @Override
        public int compareTo(Student s) {
            int order= s.score-this.score;
            return order;
        }
    }
    public int solution(int K, String[] user_scores) {

        int answer = 0;
        ArrayList<Student> list=new ArrayList<>();

        for(int i=0;i<user_scores.length;i++){
            //넣고 정렬 자르고
            String str=user_scores[i];
            String[] info=str.split(" ");
            String name=info[0];
            int score=Integer.parseInt(info[1]);
            Student newStu=new Student(name,score);

            //바뀐지 확인을 위한 복사 list
            ArrayList<Student> copyList=new ArrayList<>();
            copyList.addAll(list);

            //랭킹에 추가 되어야 하는지
            boolean addFlag=true;

            //랭킹 리스트 조건별 비교
            for(int j=0;j<list.size();j++){
                Student listStu=list.get(j);

                //같은 학생이 이전보다 좋지 않은성적내면 무시
                if(listStu.getName().equals(newStu.getName())&&newStu.getScore()<=listStu.getScore()){
                    addFlag=false;
                    break;
                }

                //같은 학생이 이전보다 좋은 성적내면 점수 업데이트
                if(listStu.getName().equals(newStu.getName())&&newStu.getScore()>listStu.getScore()){
                    addFlag=false;
                    listStu.setScore(newStu.getScore());
                    break;
                }
            }

            //같은 학생이 아니라면
            if(addFlag==true){
                list.add(newStu);
            }

            //정렬
            Collections.sort(list);

            //리스트가 조건보다 크면 자르기
            if(K<list.size()){
                list.remove(list.size()-1);
            }

            //랭킹이 바뀐지 확인
            boolean flag=false;

            //리스트 일치 확인
            for(int k=0;k<copyList.size();k++){
                if( !list.get(k).getName().equals(copyList.get(k).getName())){
                    flag=true;
                    break;
                }
            }
            //K개 이하인 상황에서 사이즈 변동시
            if(copyList.size()!=list.size()){
                answer++;
                continue;
            }

            //변경 되었다면
            if(flag){
                answer++;
            }

        }
        return answer;
    }
}
