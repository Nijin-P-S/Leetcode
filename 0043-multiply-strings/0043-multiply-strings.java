class Solution {
    public String multiply(String num1, String num2) {
        if(num1== null || num1.length() == 0 )
            return num2;
        if(num2 == null || num2.length() == 0 )
            return num1;
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        List<String> toBeAdded = new ArrayList<>();
        
        int p2 = num2.length()-1;
        
        while(p2 >= 0){
            StringBuilder curr = new StringBuilder();
            int carry = 0;
            for(int i=num1.length()-1; i>=0; i--){
                int pro = ((num2.charAt(p2) - '0')* (num1.charAt(i) - '0') ) + carry;
                curr.append(pro%10);
                carry = pro/10;
            }
            
            if(carry != 0)
                curr.append(carry);
            curr = curr.reverse();
            for(int i=0 ; i< (num2.length()-1-p2); i++){
                curr.append('0');
            }
            toBeAdded.add(curr.toString());
            p2--;
        }

        for(String s : toBeAdded)
            System.out.println(s);
        
        int loop = toBeAdded.get(toBeAdded.size()-1).length()-1;
        int i = 0;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while(loop-- >= 0){
            int sum = 0;
            for(String s : toBeAdded){
                if(s.length()-i-1 < 0)
                    continue;
                sum+=(s.charAt(s.length()-i-1) - '0');
            }
            sum+=carry;
            carry = sum/10;
            ans.append(sum%10);
            i++;
        }
        if(carry != 0)
            ans.append(carry);
        
        return ans.reverse().toString();
    }
}