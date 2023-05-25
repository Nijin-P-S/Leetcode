class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        int p1 = a.length()-1, p2 = b.length()-1;
        
        while(p1>=0 && p2>=0){
            if(a.charAt(p1) == '1' && b.charAt(p2)=='1'){
                if(carry == 1){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                }
                carry = 1;
            }
            else if(a.charAt(p1) == '1' || b.charAt(p2)=='1'){
                if(carry == 1){
                    sb.append('0');
                    carry = 1;
                }
                else{
                    sb.append('1');
                    carry = 0;
                }    
            }
            else{
                if(carry == 1){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                }
                carry = 0;
            }
            p1--;
            p2--;
        }
        
        while(p1 >= 0){
            if(a.charAt(p1) == '1'){
                if(carry == 1){
                    sb.append('0');
                    carry = 1;
                }
                else{
                    sb.append('1');
                }
            }
            else{
                if(carry == 1){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                }
                carry = 0;
            }
            p1--;
        }
        
        while(p2 >= 0){
            if(b.charAt(p2) == '1'){
                if(carry == 1){
                    sb.append('0');
                    carry = 1;
                }
                else{
                    sb.append('1');
                }
            }
            else{
                if(carry == 1){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                }
                carry = 0;
            }
            p2--;
        }
        if(carry != 0){
            sb.append('1');
        }
        
        return sb.reverse().toString();
    }
}