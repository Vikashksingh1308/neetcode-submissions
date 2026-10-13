class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums: number[], target: number): number[] {
        const seen = new Map<number, number>(); //k: value, v: index 
        for (let i = 0; i<nums.length; i++ ){
            const diff = target - nums[i];

            if(seen.has(diff)){
                return [seen.get(diff)!, i];
            }

            seen.set(nums[i], i);
        }

        return [];
    }
}
