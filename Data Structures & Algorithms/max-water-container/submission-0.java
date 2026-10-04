class Solution {
    public int maxArea(int[] heights) {
      int left = 0;
        int right = heights.length - 1;
        int area = 0;

        while(right > left){
            int currWidth = right - left;
            int currHeight = Math.min(heights[right], heights[left]);
            int currArea = currWidth *  currHeight;
            if(currArea > area) {
                area = currArea;
             } else area = area;
            
            if(heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }  

        return area;  
    }
}
