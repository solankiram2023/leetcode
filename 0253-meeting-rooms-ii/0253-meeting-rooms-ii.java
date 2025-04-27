class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int[] interval : intervals){
            if(!p.isEmpty() && p.peek()<= interval[0]){
                p.poll();
            }
            p.add(interval[1]);
        }
        return p.size();
        
    }
}