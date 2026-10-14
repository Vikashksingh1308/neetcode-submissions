interface IMinHeap {
    size(): number;
    peek(): number;
    push(val: number): void;
    pop(): number | undefined;
}

class MinHeap implements IMinHeap{
    private heap: number[] = [];

    size(): number {
        return this.heap.length;
    }

    peek(): number {
        return this.heap[0];
    }

    push(val: number): void {
        this.heap.push(val);
        this.siftUp(this.heap.length - 1);
    }

    pop(): number | undefined {
        if(this.heap.length === 0) return undefined;

        const top = this.heap[0];
        const last = this.heap.pop()!;

        if(this.heap.length > 0){
            this.heap[0] = last;
            this.siftDown(0);
        }
        return top;
    }

    private siftUp(i: number): void {
        while(i > 0) {
            const parent = Math.floor((i-1)/2);
            if (this.heap[parent] <= this.heap[i]) break;
            [this.heap[parent], this.heap[i]] = [this.heap[i], this.heap[parent]];
            i = parent;
        }
    }

    private siftDown(i: number): void {
        const n = this.heap.length;
        while(true){
            let smallest = i;
            const left = 2 * i + 1;
            const right = 2 * i + 2;

            if(left < n && this.heap[left] < this.heap[smallest]) smallest = left;
            if(right < n && this.heap[right] < this.heap[smallest]) smallest = right;

            if(smallest === i) break;
            [this.heap[smallest], this.heap[i]] = [this.heap[i], this.heap[smallest]];
            i = smallest;
        }
    }
    
}

class KthLargest {
    private minHeap: IMinHeap;
    private k: number;
    /**
     * @param {number} k
     * @param {number[]} nums
     */
    constructor(k: number, nums: number[]) {
        this.k = k;
        this.minHeap = new MinHeap();

        for(const num of nums){
            this.minHeap.push(num);
        }

        while(this.minHeap.size() > k){
            this.minHeap.pop();
        }
    }

    /**
     * @param {number} val
     * @return {number}
     */
    add(val: number): number {
        if(this.minHeap.size() < this.k){
            this.minHeap.push(val);
        } else if(val > this.minHeap.peek()){
            this.minHeap.push(val);
            this.minHeap.pop();
        }
        return this.minHeap.peek();
    }
}