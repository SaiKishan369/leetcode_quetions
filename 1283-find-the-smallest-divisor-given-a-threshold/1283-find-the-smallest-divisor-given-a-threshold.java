class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int num:nums){
            high=Math.max(num,high);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid == 0){low=1;continue;}
            long sum=0;

            for(int num:nums){
                sum+=(num+mid-1)/mid;
            }
            if(sum <= threshold){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}