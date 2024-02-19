public class Solution {
    public static boolean rec(int[][] b){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(b[i][j]==0){
                    for(int k=1;k<=9;k++){
                        if (isvalid(b,i,j,k)){
                            b[i][j]=k;
                            if(rec(b)) return true;
                            else b[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isvalid(int[][] b,int i,int j,int c){
         for(int k=0;k<9;k++){
             if(b[k][j]==c) return false;
             if(b[i][k]==c) return false;
             if(b[(3*(i/3)+k/3)][(3*(j/3)+k/3)]==c) return false;
             
         }
         return true;
    }
    public static boolean sudokuSolver(int board[][]){
        return rec(board);
    }
}
