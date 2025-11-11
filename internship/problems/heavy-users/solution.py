def find_heavy_users():
    n = int(input())
    user_transactions = {}
    
    for _ in range(n):
        time, user_id = map(int, input().split())
        if user_id not in user_transactions:
            user_transactions[user_id] = []
        user_transactions[user_id].append(time)
    
    flagged_users = []
    
    for user_id, times in user_transactions.items():
        if len(times) < 3:
            continue
        
        times.sort()
        left = 0
        is_flagged = False
        
        for right in range(len(times)):
            while times[right] - times[left] > 60:
                left += 1
            
            if right - left + 1 >= 3:
                is_flagged = True
                break
        
        if is_flagged:
            flagged_users.append(user_id)
    
    flagged_users.sort()
    print(" ".join(map(str, flagged_users)))

if __name__ == "__main__":
    find_heavy_users()