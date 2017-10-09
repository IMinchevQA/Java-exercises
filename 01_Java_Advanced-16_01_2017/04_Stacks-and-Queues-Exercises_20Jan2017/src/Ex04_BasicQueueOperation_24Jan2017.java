import java.util.*;

public class Ex04_BasicQueueOperation_24Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);
        String[] NSX_nums = sc.nextLine().split("\\s+");
        int N = Integer.parseInt(NSX_nums[0]);
        int S = Integer.parseInt(NSX_nums[1]);
        int X = Integer.parseInt(NSX_nums[2]);
        String strNums = sc.nextLine();

        int[] arrNums = Arrays.stream(strNums.substring(0, strNums.length()).split("\\s+"))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> nums = stackAddNums(N, arrNums);
        nums = pollNumbers(S, nums);

        int minNum = nums.size() > 0 ? Integer.MAX_VALUE : 0;

        if(nums.contains(X)){
            System.out.println(true);
        } else {
            while (!nums.isEmpty()) {
                int currentNum = nums.poll();
                if(currentNum < minNum){
                    minNum = currentNum;
                }
            }
            System.out.println(minNum);
        }
    }

    private static ArrayDeque<Integer> pollNumbers(int countPollNums, ArrayDeque<Integer> nums) {
        ArrayDeque<Integer> outputStack = nums;
        for (int i = 0; i < countPollNums; i++) {
            outputStack.poll();
        }
        return outputStack;
    }

    private static ArrayDeque<Integer> stackAddNums(int n, int[] arrNums) {
        ArrayDeque<Integer> outputStack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            outputStack.add(arrNums[i]);
        }
        return outputStack;
    }
}


//Input
//5 2 32
//1 13 45 32 4

//4 1 666
//420 69 13 666

//Critical input
//3 3 90
//90 90 90