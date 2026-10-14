class KthLargest {
    /**
     * @param {number} k
     * @param {number[]} nums
     */
    k: number = 0;
    nums: number[];
    
    constructor(k: number, nums: number[]) {
        this.k = k;
        this.nums = nums;    
    }

    /**
     * @param {number} val
     * @return {number}
     */
    add(val: number): number {
        this.nums.push(val);
        this.nums.sort((a,b) => b - a);
        return this.nums.at(this.k-1);
    }
}
