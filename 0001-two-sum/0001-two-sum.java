class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        int size = nums.length;

        for(int i=0 ; i<size ; i++){
            int complement = target - nums[i];

            if(indices.containsKey(complement)){
                return new int[]{indices.get(complement), i};
            }

            indices.put(nums[i], i);
        }
        return new int[0];
    }
}