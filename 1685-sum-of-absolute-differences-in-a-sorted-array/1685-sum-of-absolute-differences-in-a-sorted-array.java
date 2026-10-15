
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = i;
            int rightCount = n - i - 1;
            int rightSum = total - leftSum - nums[i];

            answer[i] =
                nums[i] * leftCount - leftSum
                + rightSum - nums[i] * rightCount;

            leftSum += nums[i];
        }

        return answer;
    }
}
