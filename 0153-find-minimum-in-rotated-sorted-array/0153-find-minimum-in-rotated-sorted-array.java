class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int Min=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            int currL;
            if(nums[low]<=nums[mid]){
                currL=nums[low];
                low=mid+1;
            }
            else{
                currL=nums[mid];
                high=mid-1;
            }

            Min=Math.min(currL,Min);
        }
        return Min;
    }
}