package LeetCode.二分;

import java.util.Arrays;

public class 爱吃香蕉的珂珂 {
}
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int maxNum = piles[piles.length - 1];
        int minNum = 1;
        int k = maxNum;
        while (minNum < maxNum) {
            int speed = (maxNum - minNum) / 2 + minNum;
            long cnt = getTime(speed, piles);  // 返回当前速度吃完需要的时间
            if (cnt <= h) {
                k = speed;
                maxNum = speed;
            }
            if (cnt > h) minNum = speed + 1;
        }
        return k;
    }

    public long getTime(int speed, int[] piles) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }
}