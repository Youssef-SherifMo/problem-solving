package slidingWindow;

import java.util.*;
public class LongestSubstringKDistinct {

    public static int findLength(String str,int k){
        if(str==null|| str.isEmpty() ||str.length()<k){
            throw new IllegalArgumentException();
        }
        int windowStart=0,maxLength=0;
        Map<Character,Integer>charFrequencyMap=new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar=str.charAt(windowEnd);
            charFrequencyMap.put(rightChar,charFrequencyMap.getOrDefault(rightChar,0)+1);
            while (charFrequencyMap.size()>k){
                char leftChar=str.charAt(windowStart);
                charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)-1);
                if (charFrequencyMap.get(leftChar)==0){
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength=Math.max(maxLength,windowEnd-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        /*
        * Given a string, find the length of the longest substring in it with no more than K distinct characters.
        * ex:
        * Input: String="araaci", K=2
        * Output: 4
        * Explanation: The longest substring with no more than '2' distinct characters is "araa".
        */
        int result = LongestSubstringKDistinct.findLength("araaci",2);
        System.out.printf("result equals: %s%n", result);
        result = LongestSubstringKDistinct.findLength("araaci",1);
        System.out.printf("result equals: %s%n", result);
        result = LongestSubstringKDistinct.findLength("cbbebi",3);
        System.out.printf("result equals: %s%n", result);
    }
}
