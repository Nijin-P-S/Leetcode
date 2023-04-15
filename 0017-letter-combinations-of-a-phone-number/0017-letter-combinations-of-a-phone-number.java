class Solution {
    
    private void get(HashMap<Character, char[]> phone , List<String> ans, String digits, String cur, int ind){
        if(ind == digits.length()-1){
            for(char c : phone.get(digits.charAt(ind))){
                String now = cur+c;
                ans.add(now);
            }
            return;
        }
        
        for(char c : phone.get(digits.charAt(ind))){
            String now = cur+c;
            get(phone, ans, digits, now, ind+1);
        }
        
    }
    
    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> phone = new HashMap<>();
        phone.put('2', new char[]{'a','b','c'});
        phone.put('3', new char[]{'d','e','f'});
        phone.put('4', new char[]{'g','h','i'});
        phone.put('5', new char[]{'j','k','l'});
        phone.put('6', new char[]{'m','n','o'});
        phone.put('7', new char[]{'p','q','r','s'});
        phone.put('8', new char[]{'t','u','v'});
        phone.put('9', new char[]{'w','x','y','z'});
        
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        String cur = "";
        get(phone, ans, digits, cur, 0);
        return ans;
    }
}