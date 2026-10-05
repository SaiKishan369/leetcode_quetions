class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstele=findfirst(nums,target);
        if (firstele == -1){
            return new int[]{-1,-1};
        }
        int lastele=findlast(nums,target);
        return new int[]{firstele,lastele};
    }

    public int findfirst(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low <= high){
            int mid=low+(high-low)/2;
            if(nums[mid] >= target){
                if(nums[mid] == target){
                    ans=mid;
                }
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

     public int findlast(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low <= high){
            int mid=low+(high-low)/2;
            if(nums[mid] <= target){
                if(nums[mid] == target){
                    ans=mid;
                }
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}