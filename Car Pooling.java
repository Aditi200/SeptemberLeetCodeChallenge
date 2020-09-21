class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> timestamp = new TreeMap<>();
        for (int[] trip : trips) {
            int start_passenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
            timestamp.put(trip[1], start_passenger);

            int end_passenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
            timestamp.put(trip[2], end_passenger);
        }
        int ued_capacity = 0;
        for (int passenger_change : timestamp.values()) {
            ued_capacity += passenger_change;
            if (ued_capacity > capacity) {
                return false;
            }
        }
        return true;
    }
}