class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=firstele(nums,target);
        if(first==-1){
            return new int[]{-1,-1};
        }
        int last=lastele(nums,target);
        return new int[]{first,last};
    }

    public int firstele(int[] nums,int target){
        int firstpos=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid] >= target){
                if(nums[mid]==target){
                    firstpos=mid;
                }
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return firstpos;
    }

    public int lastele(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int lastpos=-1;
        while(low<=high){
        int mid=low+(high-low)/2;
        if(nums[mid] <= target){
            if(nums[mid] == target){
                lastpos=mid;
            }
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
    return lastpos;
    }

}