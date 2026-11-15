class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            int prevIntervalEnd = result.get(result.size()-1)[1];
            if(prevIntervalEnd >= curr[0]){
                result.get(result.size()-1)[1] = Math.max(prevIntervalEnd, curr[1]);
            } else {
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
