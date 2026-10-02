class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            int curM;
            if(nums[low] <= nums[mid]){
                curM=nums[low];
                low=mid+1;
            }
            else{
                curM=nums[mid];
                high=mid-1;
            }

            ans=Math.min(ans,curM);
        }
        return ans;
    }
}