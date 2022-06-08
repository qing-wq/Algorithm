package LeetCode;

import java.util.Arrays;

class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] letter = text.toCharArray();
        int[] arr = new int[5];

        for (int i = 0; i < letter.length; i++) {
            if(letter[i] == 'b'){
                arr[0]++;
            }else if(letter[i] == 'a'){
                arr[1]++;
            }else if(letter[i] == 'l'){
                arr[2]++;
            }else if(letter[i] == 'o'){
                arr[3]++;
            }else if(letter[i] == 'n'){
                arr[4]++;
            }
        }
        arr[3] = arr[3]/2;
        arr[2] = arr[2]/2;
        Arrays.sort(arr);
        return arr[0];
    }
}
