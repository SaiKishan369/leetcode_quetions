class Solution {
    public int maxProduct(int[] nums) {
        int maxp=Integer.MIN_VALUE;
        int n=nums.length;
        int prefix=0;
        int suffix=0;
        for(int i=0;i<nums.length;i++){
            if(prefix==0)prefix=1;
            if(suffix==0)suffix=1;
           suffix=suffix*nums[i];
            prefix=prefix*nums[n-i-1];
            maxp=Math.max(maxp,Math.max(suffix,prefix));

        }
        return maxp;
    }
}