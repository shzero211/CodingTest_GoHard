package codingtest.kakaobank;

public class p1 {
    public static int[] solution(String logs) {
        String[] logArr=logs.split("\n");
        int[] times=new int[24];
        for(String log:logArr){
            String str=log.split(" ")[1];
            Integer hour=Integer.parseInt(str.split(":")[0]);
            Integer koreaHour=hour+9;
            if(koreaHour>=24){
                koreaHour=koreaHour%24;
            }
            times[koreaHour]++;
        }
        return times;
    }
    public static void main(String[] args) {
                int[] times=solution("""
                2019/05/01 00:59:19
                2019/06/01 01:35:20
                """);
    }
}
