class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Integer.MAX_VALUE;
        int high=0;
        for(int num:bloomDay){
            if(num < low)low = num;
            if(num > high)high = num;
        }
        int ans=-1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(check(mid,bloomDay,m,k)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }

    private boolean check(int days, int[] bloomDay, int m, int k){
        int currF=0;
        int currB=0;
        for(int day:bloomDay){
            if(day <= days){
                currF++;
            }
            else currF=0;
            if(currF == k){
                currB++;
                currF=0;
            }
        }
        return currB >= m;
    }
}