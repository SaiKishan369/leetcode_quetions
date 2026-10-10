class Solution {
    public int smallestIndex(int[] nums) {
        if(nums == null || nums.length == 0)return -1;

        for(int i=0;i<=nums.length-1;i++){
            int num=nums[i];
            int sum=0;
            while(num>0){
                sum+=num%10;
                num=num/10;
            }
            if(sum == i){
                return i;
            }
        }
        return -1;
    }
}