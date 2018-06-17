//https://leetcode.com/problems/subsets/description/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i =0 ; i < (1<<n); i++) {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0 ; j < n; j++) {
                if((1<<j & i) != 0)
                    list.add(nums[j]);
            }
            result.add(list);
        }
        return result;
    }
}