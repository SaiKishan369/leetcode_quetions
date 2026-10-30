class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int num:piles){
            high=Math.max(high,num);
        }
        int ans=1;
        while(low <= high){
            int mid=low+(high-low)/2;
            if(possible(piles,h,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean possible(int[] piles,int h,int mid){
        long sum=0;
        for(int pile:piles){
            long val=(long)(pile+mid-1)/mid;
            sum+=val;
        }
        if(sum <= h)return true;
        else return false;

    }
}