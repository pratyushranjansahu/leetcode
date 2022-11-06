package practiceinorder.p_41;

import java.util.HashMap;
import java.util.Map;
/*
    https://leetcode.com/problems/encode-and-decode-tinyurl/
    https://www.youtube.com/watch?v=EPD3Or5xtNg
 */
public class EncodeAndDecodeTinyURL {
    static Map<String,String> map = new HashMap<>();
    public static void main(String[] args) {
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = encode(longUrl);
        System.out.println("Map is : "+map);
        System.out.println(shortUrl);
        System.out.println(decode(shortUrl));
    }
    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((char)(Math.floor(Math.random()*100)));//length 1
        while (map.containsKey(stringBuilder.toString())) {
            stringBuilder.append((char)(Math.floor(Math.random()*100)));//length 2 3 4.... It has to be shorter
        }
        map.put(stringBuilder.toString(),longUrl);
        return stringBuilder.toString();
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
