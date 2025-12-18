#include <bits/stdc++.h>
using namespace std;

int arr[26];

void judge() {
  for (int idx : arr){
    if(idx != 0){
      cout << "Impossible" << '\n';
      return;
    }
  }
  cout << "Possible" << '\n';
}

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  for (int t = 0; t < n; t++){
    fill(arr, arr + 26, 0);
    string s1, s2;
    cin >> s1 >> s2;

    for (int i = 0; i < s1.size(); i++){
      int idx1 = s1[i] - 'a';
      arr[idx1]++;
      int idx2 = s2[i] - 'a';
      arr[idx2]--;
    }

    judge();
  }
}
