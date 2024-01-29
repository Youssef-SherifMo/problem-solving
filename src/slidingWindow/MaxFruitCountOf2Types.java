package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findLength(char[]arr){
        int windowStart=0,maxLength=0;
        Map<Character,Integer>characterFrequencyMap=new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
           char rightChar = arr[windowEnd];
           characterFrequencyMap.put(rightChar,characterFrequencyMap.getOrDefault(rightChar,0)+1);
           while (characterFrequencyMap.size()>2){
               char leftChar= arr[windowStart];
               characterFrequencyMap.put(leftChar,characterFrequencyMap.get(leftChar)-1);
               if (characterFrequencyMap.get(leftChar)==0){
                   characterFrequencyMap.remove(leftChar);
               }
               windowStart++;
           }
           maxLength=Math.max(maxLength,windowEnd-windowStart+1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        /*
        * Given an array of characters where each character represents a fruit tree,
        * you are given two baskets and your goal is to put maximum number of fruits in each basket.
        * The only restriction is that each basket can have only one type of fruit.
        * You can start with any tree, but once you have started you can’t skip a tree.
        * You will pick one fruit from each tree until you cannot,
        * i.e., you will stop when you have to pick from a third fruit type.
        *
        * ex:
        * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
        * Output: 5
        * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
        * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
        */
        int result = MaxFruitCountOf2Types.findLength(new char[]{'A','B', 'C', 'B', 'B', 'C'});
        System.out.printf("result equals: %s%n", result);
    }
}
