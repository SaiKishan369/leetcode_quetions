class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Integer candidate1=null;
        Integer candidate2=null;
        int count1=0;
        int count2=0;
        for(int num:nums){
            if(candidate1 != null && candidate1 == num){
                count1++;
            }
            else if(candidate2 != null && candidate2 == num ){
                count2++;
            }
            else if(count1==0){
                candidate1=num;
                count1=1;
            }
            else if(count2==0){
                candidate2=num;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1=0;count2=0;
        for(int num:nums){
            if(candidate1 != null && candidate1 == num)count1++;
            else if(candidate2 != null && candidate2 == num)count2++;
        }

        List<Integer> result=new ArrayList<>();
        int threshold=nums.length/3;

        if(candidate1 != null && count1 > threshold)result.add(candidate1);
        if(candidate2 != null && count2 > threshold){
            if(candidate2 != candidate1)result.add(candidate2);
        }

        return result;

    }
}