class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length == 0){
            return 0;
        }

        HashMap<Integer, Integer> freq=new HashMap<>();
        freq.put(0,1);
        int count=0;
        int currentsum=0;
        for(int i=0;i<nums.length;i++){
            currentsum+=nums[i];
            if(freq.containsKey(currentsum - k)){
                count+=freq.get(currentsum-k);
            }
            freq.put(currentsum,freq.getOrDefault(currentsum,0)+1);
        }
        return count;
        
    }
}