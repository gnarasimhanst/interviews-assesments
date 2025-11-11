import java.util.*;

public class FindHeavyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, List<Integer>> userTransactions = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int time = scanner.nextInt();
            int userId = scanner.nextInt();
            userTransactions.computeIfAbsent(userId, k -> new ArrayList<>()).add(time);
        }
        
        List<Integer> flaggedUsers = new ArrayList<>();
        
        for (Map.Entry<Integer, List<Integer>> entry : userTransactions.entrySet()) {
            int userId = entry.getKey();
            List<Integer> times = entry.getValue();
            
            if (times.size() < 3) continue;
            
            Collections.sort(times);
            
            int left = 0;
            boolean isFlagged = false;
            
            for (int right = 0; right < times.size(); right++) {
                while (times.get(right) - times.get(left) > 60) {
                    left++;
                }
                
                if (right - left + 1 >= 3) {
                    isFlagged = true;
                    break;
                }
            }
            
            if (isFlagged) {
                flaggedUsers.add(userId);
            }
        }
        
        Collections.sort(flaggedUsers);
        
        for (int i = 0; i < flaggedUsers.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(flaggedUsers.get(i));
        }
    }
}