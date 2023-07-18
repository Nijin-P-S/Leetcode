public class Codec {
    private final String ENCODE_STRING = "https://tinyUrl/";
    char[] alphanumericArray;
    HashMap<String, String> encodedMap ;
    HashMap<String, String> decodedMap ;
    public Codec(){
        encodedMap = new HashMap<>();
        decodedMap = new HashMap<>();
        
        alphanumericArray = new char[62]; // 26 lowercase + 26 uppercase + 10 digits = 62 elements
        
        int index = 0;

        // Add lowercase alphabets
        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphanumericArray[index] = ch;
            index++;
        }

        // Add uppercase alphabets
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            alphanumericArray[index] = ch;
            index++;
        }

        // Add digits
        for (char ch = '0'; ch <= '9'; ch++) {
            alphanumericArray[index] = ch;
            index++;
        }
    }
    
    private String findUniqueEncoded(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String ans = "";
        for(int i=0; i<9; i++){
             int randomIndex = random.nextInt(0, 62) ;
             sb.append(""+alphanumericArray[randomIndex]);
        }
        ans = sb.toString();
        return ans;   
    }
 
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encoded = findUniqueEncoded();
        encodedMap.put(encoded, longUrl);
        decodedMap.put(longUrl, encoded);
        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return encodedMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));