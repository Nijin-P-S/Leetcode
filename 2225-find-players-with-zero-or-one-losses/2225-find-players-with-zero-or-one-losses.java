class Solution {
   public List<List<Integer>> findWinners(int[][] matches) {
		HashMap<Integer, Integer> lostCount = new HashMap<>();
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<>());
		ans.add(new ArrayList<>());
		for(int i=0; i<matches.length; i++){
			int won = matches[i][0];
			int lost = matches[i][1];

			lostCount.put(won, lostCount.getOrDefault(won, 0));
			lostCount.put(lost, lostCount.getOrDefault(lost, 0)+1);
		}

		for(int key : lostCount.keySet()){
			if(lostCount.get(key) == 0){
				ans.get(0).add(key);
			}
			else if(lostCount.get(key)==1){
				ans.get(1).add(key);
			}
		}
		Collections.sort(ans.get(0));
		Collections.sort(ans.get(1));
		return ans;
	}
}