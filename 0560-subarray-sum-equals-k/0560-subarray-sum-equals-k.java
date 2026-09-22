class Solution {
    public int subarraySum(int[] nums, int k) {
        if( nums == null){
            return 0;
        }
        HashMap<Integer,Integer> prefixs=new HashMap<>();
        prefixs.put(0,1);
        int count=0;
        int currentsum=0;
        for(int num:nums){
            currentsum+=num;
            if(prefixs.containsKey(currentsum-k)){
                count += prefixs.get(currentsum-k);
            }
        
                prefixs.put(currentsum,prefixs.getOrDefault(currentsum,0)+1);
            
        }
        return count;


    }
}