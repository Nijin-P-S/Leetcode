class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniEmails = new HashSet<>();
        
        for(String em : emails){
            StringBuilder s = new StringBuilder();
            
            int i=0;
            for(i=0; i<em.length(); i++){
                if(em.charAt(i) == '+' || em.charAt(i) == '@')
                    break;
                else if(em.charAt(i) == '.')
                    continue;
                else
                    s.append(em.charAt(i));
            }
            
            while(em.charAt(i) != '@')
                i++;
            
            for(; i<em.length(); i++){
                s.append(em.charAt(i));
            }
        
            uniEmails.add(s.toString());
        }
        
        return uniEmails.size();
    }
}