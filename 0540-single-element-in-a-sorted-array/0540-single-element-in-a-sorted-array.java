class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)return nums[0];
        int n=nums.length;
        if(nums[0] != nums[1])return nums[0];
        if(nums[n-1] != nums[n-2])return nums[n-1];
        int low=1;
        int high=n-2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]){
                return nums[mid];
            }
            if(mid%2 == 0){
                if(nums[mid-1] == nums[mid]){
                    high=mid-1;
                }
                else low=mid+1;
            }
            else{
                if(nums[mid-1]==nums[mid]){
                    low=mid+1;
                }
                else high=mid-1;
            }
        }
        return -1;
    }
}