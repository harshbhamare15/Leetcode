class Solution {
    public int maxProduct(int[] nums) {
        int d1 = 0, d2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (d1 <= a) {
                d2 = d1;
                d1 = a;
            } else if (d2 < a) {
                d2 = a;
            }
        }
        return (d1 - 1) * (d2 - 1);
    }
}
