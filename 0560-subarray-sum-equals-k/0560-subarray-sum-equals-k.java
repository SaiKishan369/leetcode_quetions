class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefix=new HashMap<>();
        prefix.put(0,1);
        int count=0;
        int currentsum=0;
        for(int num:nums){
            currentsum+=num;
            if(prefix.containsKey(currentsum-k)){
                count+=prefix.get(currentsum-k);
            }
            prefix.put(currentsum,prefix.getOrDefault(currentsum,0)+1);
        }
        return count;
    }
}