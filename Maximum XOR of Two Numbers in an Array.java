class Solution {
    public int findMaximumXOR(int[] nums) {
        
        int xorMax = 0, bitMask = 0;
        for(int i = 31; i >= 0; i--){
            bitMask = bitMask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & bitMask);
            }
            int temp = xorMax | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    xorMax = temp;
                    break;
                }
            }
        }
        return xorMax;
    }
}