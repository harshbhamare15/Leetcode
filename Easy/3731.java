class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        for (int x = nums[0]; x < nums[nums.length - 1]; x++) {
            if (Arrays.binarySearch(nums, x) < 0) {
                res.add(x);
            }
        }

        return res;
    }
}
