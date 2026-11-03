class Solution {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length;
        int ans = 0;

        for(int i=0 ; i<size ; i++){
            int currSum = 0;
            for(int j=i ; j<size ; j++){
                currSum += nums[j];
                if(currSum == k) ans++;
            }
        }

        return ans;
    }
}