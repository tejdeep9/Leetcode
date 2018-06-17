//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        List<Integer> result = new ArrayList<Integer>();
        
        int start = 0;
        int end  = n-1;
        while(start < end) {
            int sum = numbers[start]+numbers[end];
            if(sum == target) {
                result.add(start+1);
                result.add(end+1);
                start++;
                end--;
            } else if(sum < target) {
                start++;
            } else {
                end--;
            }
        }
        
        int[] arr = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            arr[i] = result.get(i);
        }
        
        return arr;
    }
}