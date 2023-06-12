class Solution {
    public String smallestString(String s) {
        int ind = 0;
		while(ind < s.length() && s.charAt(ind) == 'a')
			ind++;
		if(ind == s.length()){
			StringBuilder ans = new StringBuilder();
			for(int i=0; i<s.length()-1; i++)
				ans.append('a');
			ans.append('z');
			return ans.toString();
		}

		StringBuilder conv = new StringBuilder();

		int left = 0, right =-1;

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i) != 'a' ? (char) (s.charAt(i) - 1) : 'z';
			conv.append(c);
		}
		while(left < s.length() && s.charAt(left) < conv.charAt(left))
			left++;
		right = left;
		while(right < s.length() && s.charAt(right) > conv.charAt(right))
			right++;

		StringBuilder ans = new StringBuilder();

		for(int i=0; i<left; i++){
			ans.append(s.charAt(i));
		}
		for(int i=left; i<right; i++){
			ans.append(conv.charAt(i));
		}

		if(right != s.length()){
			for(int i=right; i<s.length(); i++){
				ans.append(s.charAt(i));
			}
		}

		return ans.toString();
    }
}