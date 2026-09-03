class Solution {
    public boolean uniformArray(int[] nums1) {
        int minNum = nums1[0];

        for (int n : nums1) {
            minNum = Math.min(minNum, n);
        }

        if ((minNum & 1) == 1) {
            return true;
        }

        for (int n : nums1) {
            if ((n & 1) == 1) {
                return false;
            }
        }

        return true;
    }
}
