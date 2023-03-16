package codingtest.gabi;

import java.util.LinkedList;
import java.util.Queue;

public class p3 {
    class Task{
        private int idx;
        private int time;
        public Task(int idx,int time){
            this.idx=idx;
            this.time=time;
        }
        public int getIdx(){
            return idx;
        }
        public int getTime(){
            return time;
        }
    }
    public Integer[] solution(int N, int[] coffee_times) {
        int[] answer = {};
        Queue<Task> queue=new LinkedList<>();
        Queue<Integer> resultQ=new LinkedList<>();
        for(int i=1;i<=coffee_times.length;i++){
            queue.add(new Task(i,coffee_times[i]));
        }

        int currentTime=0;
        int tempIdx=0;
        while(!queue.isEmpty()){

            Task task=queue.poll();

            int idx =task.getIdx();

            int coffee_time=task.getTime();
            if(currentTime>=coffee_time){
                resultQ.add(idx);
                continue;
            }
            else{
                if(tempIdx!=0){
                    resultQ.add(tempIdx);
                }
                currentTime=coffee_time;
                tempIdx=idx;
            }
        }

        return resultQ.stream().toArray(Integer[]::new);
    }
}
