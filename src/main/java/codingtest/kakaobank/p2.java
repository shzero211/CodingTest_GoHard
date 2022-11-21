package codingtest.kakaobank;

public class p2 {
    public static int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        double nowMoney=money;
        int month=1;
        double restMoney=0;

        while(nowMoney-(nowMoney%100)>=threshold&&month<=months){
            restMoney=(nowMoney%100);
            nowMoney=nowMoney-restMoney;
            int nowRank=0;
              for(int i=minratio;i<=maxratio;i++){
                  if(nowMoney>=(threshold+maxratio*ranksize)){
                      nowMoney=(nowMoney+restMoney)-(int)Math.round(nowMoney*((double) maxratio/100));
                      break;
                  }
                  if(threshold+(nowRank*ranksize)<=nowMoney&&nowMoney<=(threshold+(nowRank+1)*ranksize)-1){
                      System.out.println(i);
                      System.out.println((int)nowMoney);
                      System.out.println((int)(nowMoney*((double) i/100)));
                      System.out.println((int)nowMoney-(int)Math.round(nowMoney*((double) i/100)));
                      nowMoney=(nowMoney+restMoney)-(int)Math.round(nowMoney*((double) i/100));
                      break;
                  }
                  nowRank++;
              }
              month++;
        }
            return (int) nowMoney;
    }

    public static void main(String[] args) {
      // solution(12345678,10,20,250000,10000000,4);
        solution(1000000000,50,99,100000,0,6);
    }
}
