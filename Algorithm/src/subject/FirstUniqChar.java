package subject;

/**
 * @program: FirstUniqChar
 * @description: 查找第一个只出现一次的字符
 * @author: liyifan
 * @create: 2021/08/14/21:37
 */

import java.util.HashMap;

/**
question:在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 示例:s = "abaccdeff"
 返回 "b"
 s = ""
 返回 " "

 思路:1.  使用hashmap 遍历字符串两遍，第一遍存 第二遍找
     2. 使用linkhashmap  遍历字符串一遍存，遍历map一遍找
 */
public class FirstUniqChar {
    public static char firstUniqChar(String s) {
    if (s.length()<=0){
        return ' ';
    }
    char[] chars = s.toCharArray();
    HashMap<Character, Boolean> map = new HashMap<>();
    for(char c:chars){
        map.put(c,!map.containsKey(c));
    }
    for(char c:chars){
        if(map.get(c)) return c;
    }
    return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
