class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int currMax = Integer.MIN_VALUE;

        
        for (int i = 0; i < n; i++) {
            currMax = Math.max(currMax, nums[i]);
            prefixGcd[i] = gcd(nums[i], currMax);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;
        int left = 0, right = n - 1;

        
        while (left < right) {
            ans += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return ans;
    }

    
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
