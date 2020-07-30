package problem119;

class Solution {
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            ArrayList<Integer> lst = new ArrayList<>(1);
            lst.add(1);
            return lst;
        }

        if(rowIndex == 1){
            ArrayList<Integer> lst = new ArrayList<>(2);
            lst.add(1);
            lst.add(1);
            return lst;
        }

        Stack<Integer> currentStack = new Stack<Integer>();//121
        currentStack.push(1);
        currentStack.push(1);
        int item = 0;
        int temp = 0;
        Stack<Integer> computedStack = new Stack<Integer>();
        int i=0;
        while(i <= rowIndex-2){
            if(!currentStack.empty()){
                temp = currentStack.pop();
                if(item == 0){
                    item=temp;
                    computedStack.push(item);
                } else {
                    item +=temp;
                    computedStack.push(item);
                    item = temp;
                }
                continue;
            }
            computedStack.push(item);
            currentStack = computedStack;
            computedStack = new Stack<Integer>();
            item = 0;
            i++;
        }


        return currentStack;
    }
}