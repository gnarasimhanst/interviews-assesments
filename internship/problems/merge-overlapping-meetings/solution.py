def merge_intervals():
    n = int(input())
    intervals = []
    
    for _ in range(n):
        start, end = map(int, input().split())
        intervals.append([start, end])
    
    intervals.sort()
    
    if not intervals:
        return
    
    merged = [intervals[0]]
    
    for current in intervals[1:]:
        if current[0] <= merged[-1][1]:
            merged[-1][1] = max(merged[-1][1], current[1])
        else:
            merged.append(current)
    
    for interval in merged:
        print(f"{interval[0]} {interval[1]}")

if __name__ == "__main__":
    merge_intervals()