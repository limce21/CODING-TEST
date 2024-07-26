#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  cin >> s;
  
  int arr[26];
  fill(arr, arr+26, 0);

  for(int i=0; i<s.length(); i++){
    int idx = int(s[i]) - 97;
    arr[idx]++;
  }

  for(int i=0; i<26; i++) {
    cout << arr[i] << ' ';
  }
}