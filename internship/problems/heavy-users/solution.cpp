#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    unordered_map<int, vector<int>> userTransactions;
    
    for (int i = 0; i < n; i++) {
        int time, userId;
        cin >> time >> userId;
        userTransactions[userId].push_back(time);
    }
    
    vector<int> flaggedUsers;
    
    for (auto& entry : userTransactions) {
        int userId = entry.first;
        vector<int>& times = entry.second;
        
        if (times.size() < 3) continue;
        
        sort(times.begin(), times.end());
        
        int left = 0;
        bool isFlagged = false;
        
        for (int right = 0; right < times.size(); right++) {
            while (times[right] - times[left] > 60) {
                left++;
            }
            
            if (right - left + 1 >= 3) {
                isFlagged = true;
                break;
            }
        }
        
        if (isFlagged) {
            flaggedUsers.push_back(userId);
        }
    }
    
    sort(flaggedUsers.begin(), flaggedUsers.end());
    
    for (size_t i = 0; i < flaggedUsers.size(); i++) {
        if (i > 0) cout << " ";
        cout << flaggedUsers[i];
    }
    
    return 0;
}