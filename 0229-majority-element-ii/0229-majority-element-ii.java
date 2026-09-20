class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        Integer candidate1 = null;
        Integer candidate2=null;
        int count1=0;
        int count2=0;

        for(int num:nums){
            if(candidate1 != null && candidate1 == num){
                count1++;
            }
            else if(candidate2 != null && candidate2 == num){
                count2++;
            }
            else if(count1 == 0){
                candidate1=num;
                count1=1;
            }
            else if(count2 == 0){
                candidate2=num;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        count1=0;
        count2=0;

        for(int num:nums){
            if(candidate1 != null && candidate1 == num){
                count1++;
            }
            if(candidate2 != null && candidate2 == num){
                count2++;
            }
        }

        int threshold=nums.length/3;

        if(candidate1 != null && count1 > threshold){
            result.add(candidate1);
        }

        if(candidate2 != null && candidate2 != candidate1){
            if(count2 > threshold){
                result.add(candidate2);
            }
        }

        return result;

    }
}