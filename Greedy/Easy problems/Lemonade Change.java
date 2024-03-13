public class Solution {

    public static boolean lemonadeChange(int []bill) {
        int total10=0;
        int extra=0;
        if(bill[0]!=5){
            return false;
        }
        for(int i=0;i<bill.length;i++){
            if(bill[i]==5){
                extra+=5;
            }
            else if(bill[i]==10 && extra>=5){
                total10+=10;
                extra-=5;
            }
            else if(bill[i]==20 && extra>=5 && total10>=10){
                total10-=10;
                extra-=5;
            }
            else if(bill[i]==20 && extra>=15){
                extra-=15;
            }
            else{
                return false;
            }
        }
        return true;
    }
}