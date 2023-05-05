class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int totSum1 = 0, totSum2 = 0;
        for(int i=0; i<player1.length; i++){
            if(i>0 && (player1[i-1] == 10 || (i>1 && player1[i-2] == 10)))
                totSum1+=(2*player1[i]);
            else
                totSum1+=player1[i];
        }

        for(int i=0; i<player2.length; i++){
            if(i>0 && (player2[i-1] == 10 || (i>1 && player2[i-2] == 10)))
                totSum2+=(2*player2[i]);
            else
                totSum2+=player2[i];
        }
        return totSum1==totSum2 ? 0 : (totSum1>totSum2) ? 1 : 2;
    }
}