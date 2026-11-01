class Solution {
    public int findMin(int[] nums) {
        int size = nums.length ;
        int low = 0 , high = size-1 ;
        int min = 0 ;

        while(low <= high){
            int mid = low + (high-low)/2 ;

            if(nums[mid] >= nums[high]){
                min = nums[low] ;
                low = mid+1 ;
            }
            else{
                high = mid ;
            }

        }

        return min ;
    }
}