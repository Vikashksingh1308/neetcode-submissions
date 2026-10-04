class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Step 1. Create a variable to store answer
        List<List<Integer>> result = new ArrayList<>();

        // Step 2. Sort array
        Arrays.sort(nums);

        // Step 3. Interate over the array to get answer
        for(int i=0; i < nums.length; i++){
            // two pointers for interating
            int start = i+1;
            int end = nums.length-1;

            // Check the iterative value to previous value, if its same then continue without processing anything
            if(i > 0 && nums[i] == nums [i-1]){
                continue;
            }

            //inner loop for calculation check
            while(start < end){
                //Run calculation check
                int sum = nums[i] + nums[start] + nums[end];

                //if else for comparision check and adding list to result
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;

                    // check if the next value to previous start value, if same then increment again
                    while(start < end && nums[start] == nums[start-1]){
                        start++;
                    }

                    // check if the next value to previous end value, if same then decrement again
                    while(start < end && nums[end] == nums[end+1]){
                        end--;
                    }
                } else if(sum > 0){
                    end--;
                } else {
                    start++;
                }
            }
            
        }

        return result;
    }
}
