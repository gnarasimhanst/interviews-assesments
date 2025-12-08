import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> intervals = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            intervals.add(new int[]{scanner.nextInt(), scanner.nextInt()});
        }
        
        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals.get(0));
        
        for (int i = 1; i < n; i++) {
            int[] current = intervals.get(i);
            int[] last = merged.get(merged.size() - 1);
            
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }
        
        for (int[] interval : merged) {
            System.out.println(interval[0] + " " + interval[1]);
        }
        
        scanner.close();
    }
}