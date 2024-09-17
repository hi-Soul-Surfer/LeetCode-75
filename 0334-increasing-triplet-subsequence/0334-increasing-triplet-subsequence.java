public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // check for increasing triplet
        if(nums == null || nums.length < 3)
            return false;
            
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= min){ // update min if current element is less than or equal to min
                min = nums[i];
            }else if(nums[i] <= secondMin){ // update secondMin only if current element is greater than min but less than or equal to secondMin
                secondMin = nums[i];
            }else{ // found increasing triplet since current element is greater than both min and secondMin
                return true;
            }
        }
        
        return false; // no increasing triplet found
    }
}