class Solution {
    public static boolean issafe(char[][] board,int row,int col){
        //horizantal
        for(int i=0;i<board.length;i++){
            if(board[row][i]=='Q')
            return false;
        }
        //vertical
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q')
            return false;
        }
        //upper left
        int r=row;
        for(int i=col;i>=0&r>=0;i--,r--){
            if(board[r][i]=='Q')
            return false;
        }
        //lower right
        r=row;
        for(int i=col;i<board.length&r<board.length;i++,r++){
            if(board[r][i]=='Q')
            return false;
        }
        //upper right
        r=row;
        for(int i=col;i<board.length&r>=0;i++,r--){
            if(board[r][i]=='Q')
            return false;
        }
        //lower left
        r=row;
        for(int i=col;i>=0&r<board.length;i--,r++){
            if(board[r][i]=='Q')
            return false;
        }
        return true;
    }
    public static void save(char[][] board,List<List<String>> allboard){
        String row="";
        List<String> n=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            row="";
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='Q'){
                   row+='Q';
                }
                else{
                   row+=".";
                }
            }
            n.add(row);
        }
        allboard.add(n);
    }
    public static void nqueen(char[][] board,List<List<String>> allboard,int col){
        if(col==board.length){
                save(board,allboard);
                return;
            }
        for(int i=0;i<board.length;i++){
            if(issafe(board,i,col)){
                board[i][col]='Q';
                nqueen(board,allboard,col+1);
                board[i][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoard=new ArrayList<>();
        char[][] board=new char[n][n];
        nqueen(board,allBoard,0);
        return allBoard;
    }
}