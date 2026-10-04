class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> checked = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(checked.containsKey(diff)){
                return new int[] {checked.get(diff), i};
            }
            checked.put(nums[i], i);
        }
        return new int[0];
    
    }
}
