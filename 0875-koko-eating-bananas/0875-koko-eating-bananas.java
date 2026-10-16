class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile:piles){
            high=Math.max(high,pile);
        }
        while(low<=high){
            long sol=0;
            int mid=low+(high-low)/2;
            for(int pile:piles){
                sol+=(long) (pile+mid-1)/mid;
            }
            if(sol<=h){
                high=mid-1;
            }
            else if(sol>h){
                low=mid+1;
            }
        }
        return low;
    }
}