class Solution {
    public int sortableIntegers(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int N = nums.length;

        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= N / i; i++) {
            if (N % i == 0) {
                divisors.add(i);

                if (N / i != i) {
                    divisors.add(N / i);
                }
            }
        }

        int answer = 0;

        for (int d : divisors) {
            int r = 0;
            int l = 0;
            boolean valid = true;

            int prev_max = Integer.MIN_VALUE;

            while (r < N) {
                int start = r;
                r += d;

                int drops = 0;
                int curr_max = Integer.MIN_VALUE;
                int curr_min = Integer.MAX_VALUE;

                while (l < r) {
                    if (l + 1 < r && nums[l] > nums[l + 1]) {
                        if (drops < 1 && nums[start] >= nums[r - 1]) {
                            drops++;
                        } else {
                            valid = false;
                            break;
                        }
                    }

                    curr_min = Math.min(curr_min, nums[l]);
                    curr_max = Math.max(curr_max, nums[l]);
                    l++;
                }

                if (!valid) {
                    break;
                }

                if (curr_min < prev_max) {
                    valid = false;
                    break;
                }

                prev_max = curr_max;
            }

            if (valid) {
                answer += d;
            }
        }

        return answer;
    }
}
