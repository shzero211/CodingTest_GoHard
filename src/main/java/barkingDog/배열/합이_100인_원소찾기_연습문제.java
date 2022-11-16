package barkingDog.배열;

public class 합이_100인_원소찾기_연습문제 {
    public static boolean solution(int[] arr,int len){
        int[] numArr=new int[101];
        for(int i=0;i<arr.length;i++){
            if(numArr[100-arr[i]]==1){
                return true;
            }
            numArr[arr[i]]=1;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,67,33},3));
    }
}
