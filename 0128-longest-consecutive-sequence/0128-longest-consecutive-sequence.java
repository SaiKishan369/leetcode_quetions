class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int maxL=1;
        for(int key:map.keySet()){
            int cur=key;
            int curL=1;
            if(!map.containsKey(cur-1)){
                while(map.containsKey(cur+1)){
                    curL++;
                    cur++;
                    maxL=Math.max(maxL,curL);
                }
            }
        }
        return maxL;

    }
}