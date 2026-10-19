class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int wt:weights){
            low=Math.max(low,wt);
            high+=wt;
        }
        int mincapacity=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(weights,days,mid)){
                mincapacity=mid;
                high=mid-1;            }
            else{
                low=mid+1;
            }
        }
        return mincapacity;

    }
    private boolean check(int[] wts,int maxdays,int capacity ){
        int daysneeded=1;
        int currentwt=0;
        for(int wt:wts){
            if(currentwt + wt > capacity){
                daysneeded++;
                currentwt=wt;
            }
            else{
                currentwt+=wt;
            }
        }
        return daysneeded <= maxdays;
    }
}