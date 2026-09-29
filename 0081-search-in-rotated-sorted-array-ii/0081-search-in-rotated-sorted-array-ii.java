class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return false;
        }

        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target)return true;
             if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            else if(nums[mid]>=nums[low]){
                if(nums[low]<=target && nums[mid]>target){
                    high=mid-1;
                }
                else low=mid+1;
            }
            else{
                if(nums[mid]<target && nums[high]>=target){
                    low=mid+1;
                }
                else high=mid-1;
            }
        }
        return false;
    }
}