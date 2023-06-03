class Solution {
    public int convertTime(String current, String correct) {
		String cur[] = current.split(":");
		String cor[] = correct.split(":");

		int totMins = (Math.abs(Integer.parseInt(cor[0])-Integer.parseInt(cur[0])))*60 + (Integer.parseInt(cor[1])-Integer.parseInt(cur[1]));

		int count = 0;
		while(totMins>0){
            int rem = 0;
			if(totMins>=60){
                rem=totMins%60;
				count+=(totMins/60);
                totMins = rem;
			}
			else if(totMins >= 15){
				rem=totMins%15;
				count+=(totMins/15);
                totMins = rem;
			}
			else if(totMins >= 5){
				rem=totMins%5;
				count+=(totMins/5);
                totMins = rem;
			}
			else{
				count+=totMins;
				totMins = 0;
			}
		}
		return count;
	}
}