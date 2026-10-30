class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high=0;
        for(int num: nums){
            high=Math.max(high,num);
        }
        int ans=0;
        while(low <= high){
            int mid=low+(high-low)/2;
            if(mid == 0){low=1;continue;}
            if(check(nums,threshold,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean check(int[] nums, int threshold, int mid){
        int sum=0;
        for(int num:nums){
            sum+=(num+mid-1)/mid;
        }
        if(sum <= threshold)return true;
        else return false;
    }
}