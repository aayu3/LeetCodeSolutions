package problem60;

class Solution {
    public String getPermutation(int n, int k){
        int[] acc = new int[n];
        int[] numbers = new int[n];
        acc[0] = 1;
        int init = 1;
        for(int i=1; i<=n; i++){
            init *= i;
            acc[i-1] = init;
            numbers[i-1] = i;
        }

        _get(numbers, 0, k-1, acc);

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<n; i++){
            builder.append(numbers[i]);
        }
        return builder.toString();
    }

    private void _get(int[] numbers, int start, int k, int[] acc){
        int length = numbers.length;
        int count = length - start - 1;
        if(count < 1 || k<1){
            return;
        }
        int num = 0;
        while(k >= acc[count-1]){
            num++;
            k -= acc[count-1];
        }
        if(num > 0){
            int temp = numbers[start+num];
            for(int i=num+start; i>start; i--){
                numbers[i] = numbers[i-1];
            }
            numbers[start] = temp;
        }
        _get(numbers, start+1, k, acc);
    }
}