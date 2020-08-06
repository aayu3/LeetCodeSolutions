package Scratch;

public class tempStuff {
    public static void main(String[] args) {
        int[][] example = {{1,2,3},{4,5},{6,7,8,9}};
        System.out.println(countArrayLessThan(example,3));
    }
    public static int countArrayLessThan(int[][] arr, int num) {
        int count = 0;
        if (arr == null) {
            return count;
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                int[] curRow = arr[i];
                for (int j = 0; j < curRow.length; j++) {
                    if (curRow[j] < num) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
