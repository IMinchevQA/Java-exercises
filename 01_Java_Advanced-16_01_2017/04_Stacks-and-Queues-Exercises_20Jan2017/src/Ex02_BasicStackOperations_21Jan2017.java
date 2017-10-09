import java.lang.reflect.Array;
import java.util.*;

public class Ex02_BasicStackOperations_21Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);
        String[] NSXnums = scanner.nextLine().split("\\s+");
        String str = scanner.nextLine();
        //Nubers to be pushed in the stack
        int[] arrNums = Arrays.stream(str.substring(0, str.length()).split("\\s+"))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        //Number of elements to push onto the stack
        int N_num = Integer.parseInt(NSXnums[0]);
        //Number of elements to pop in the stack
        int S_num = Integer.parseInt(NSXnums[1]);
        //Number of elements to be checked in the stack
        int X_num = Integer.parseInt(NSXnums[2]);
        
        ArrayDeque<Integer> nums = stackPush(N_num, arrNums);
        //Pop S_num count of numbers;
        nums = popNumbers(S_num, nums);
        //minNum will be equal to 0 if nums.size() is 0;
        int minNum = nums.size() > 0 ? Integer.MAX_VALUE : 0;

        if(nums.contains(X_num)){
            System.out.println(true);
        } else {
            while (!nums.isEmpty()) {
                int currentNum = nums.pop();
                if(currentNum < minNum) {
                    minNum = currentNum;
                }
            }
            System.out.println(minNum);
        }
    }

    private static ArrayDeque<Integer> popNumbers(int countPopNums, ArrayDeque<Integer> nums) {
        ArrayDeque<Integer> outputStack = nums;
        for (int i = 0; i < countPopNums; i++) {
            outputStack.pop();
        }
        return outputStack;
    }


    private static ArrayDeque<Integer> stackPush(int countPushNums, int[] arrNums) {
        ArrayDeque<Integer> outputStack = new ArrayDeque<Integer>();
        for (int i = 0; i < countPushNums; i++) {
            outputStack.push(arrNums[i]);
        }
        return outputStack;
    }
}


//Input
//5 2 13
//1 13 45 32 4

//4 1 666
//420 69 13 666

//Critical input
//3 3 90
//90 90 90



