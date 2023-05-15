class Solution {
    public int minFlips(String s) {
        String cur = s+""+s;
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        
        for(int i=0; i<=cur.length()+1; i+=2){
            first.append("10");
            second.append("01");
        }
        
        
        int ans = Integer.MAX_VALUE;
        String f = first.toString();
        String se = second.toString();
        int fir = 0, sec = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != f.charAt(i))
                fir++;
            if(s.charAt(i) != se.charAt(i))
                sec++;
        }
        ans = Math.min(fir, sec);

        for(int i=0; i<s.length(); i++){
            if(cur.charAt(i) != f.charAt(i))
                fir--;
            if(cur.charAt(i) != se.charAt(i))
                sec--;
            if(cur.charAt(s.length()+i) != f.charAt(s.length()+i))
                fir++;
            if(cur.charAt(s.length()+i) != se.charAt(s.length()+i))
                sec++;
            
            ans = Math.min(ans, Math.min(fir, sec));
        }
        return ans;
    }
}