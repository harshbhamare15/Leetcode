class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int s=nums[0];
        int l=nums[0];

        for(int i=0; i<nums.length; i++){
            if(nums[i]>l){
                l=nums[i];
            }
            else if(nums[i]<s){
                s=nums[i];
            }
        }
        int gcd=1;
        for(int i=1; i<=Math.min(l,s); i++){
            if(l%i==0 && s%i==0){
                gcd = i;
            }
        }
        return gcd;
    }
}
