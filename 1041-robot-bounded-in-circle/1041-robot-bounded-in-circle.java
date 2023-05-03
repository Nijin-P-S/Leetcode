class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int dirX = 0, dirY = 1;
        char[] instr = instructions.toCharArray();
        for(char c : instr){
            if(c == 'G'){
                x = x+dirX;
                y = y+dirY;
            }
            else if(c == 'L'){
                int temp = dirX;
                dirX = -1*dirY;
                dirY = temp;
            }
            else{
                int temp = dirX;
                dirX = dirY;
                dirY = -1*temp;
            }
        }
        return (x == 0 && y==0) || !(dirX==0 && dirY==1);
    }
}