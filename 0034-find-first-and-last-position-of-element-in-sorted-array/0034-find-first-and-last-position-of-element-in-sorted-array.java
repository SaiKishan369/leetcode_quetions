class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstnum=findfirstnum(nums,target);
        if(firstnum == -1)return new int[]{-1,-1};
        int lastnum=findlastnum(nums,target);
        return new int[]{firstnum,lastnum};
    }
    public int findfirstnum(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while (low <= high){
            int mid=low+(high-low)/2;
            if(nums[mid] >= target){
                if(nums[mid] == target)ans=mid;
                    high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int findlastnum(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while (low <= high){
            int mid=low+(high-low)/2;
            if(nums[mid] <= target){
                if(nums[mid] == target)ans=mid;
                    low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}