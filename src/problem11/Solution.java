package problem11;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,3,2,5,25,24,5}));
    }
    public static int maxArea(int[] height) {
        //keys are the heights of bars, values are the distance
        SortedMap<Double, Integer> heightsDistance = new TreeMap<Double, Integer>();
        List<Integer> distancesLeft = new ArrayList<Integer>();
        int maxVol = 0;
        for (int i = 1; i <= height.length; i++) {
            distancesLeft.add(i);
            //we add fractional parts so duplicate heights are counted as distinct, but when we do actual calculations, we round down
            heightsDistance.put(height[i-1] + (double) (i-1)/(height.length),i);
        }
        for (int i = 0; i < height.length -1; i++) {
            //the smaller height
            double firstHeight = heightsDistance.firstKey();
            int distanceFH = heightsDistance.get(firstHeight);

            distancesLeft.remove(Integer.valueOf(heightsDistance.get(firstHeight)));
            if (Math.floor(firstHeight)*Math.abs(distancesLeft.get(0)-heightsDistance.get(firstHeight)) >= Math.floor(firstHeight)*Math.abs(distancesLeft.get(distancesLeft.size()-1) - heightsDistance.get(firstHeight))) {
                maxVol = Math.max(maxVol,(int) Math.floor(firstHeight)*Math.abs(distancesLeft.get(0)-heightsDistance.get(firstHeight)));
            }
            else {
                maxVol = Math.max(maxVol,(int) Math.floor(firstHeight) * Math.abs(distancesLeft.get(distancesLeft.size() - 1) - heightsDistance.get(firstHeight)));
            }
            heightsDistance.remove(firstHeight);
        }
        return maxVol;


    }
}