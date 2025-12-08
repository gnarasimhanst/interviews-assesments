#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<pair<int, int>> intervals(n);
    
    for (int i = 0; i < n; i++) {
        cin >> intervals[i].first >> intervals[i].second;
    }
    
    sort(intervals.begin(), intervals.end());
    
    vector<pair<int, int>> merged;
    merged.push_back(intervals[0]);
    
    for (int i = 1; i < n; i++) {
        if (intervals[i].first <= merged.back().second) {
            merged.back().second = max(merged.back().second, intervals[i].second);
        } else {
            merged.push_back(intervals[i]);
        }
    }
    
    for (auto &interval : merged) {
        cout << interval.first << " " << interval.second << endl;
    }
    
    return 0;
}