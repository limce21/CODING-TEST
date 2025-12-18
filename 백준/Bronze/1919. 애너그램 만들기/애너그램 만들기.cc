#include <bits/stdc++.h>
using namespace std;

int arr[26];

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s1, s2;
  cin >> s1;
  cin >> s2;

  for (int i = 0; i < s1.size(); i++){
    int idx = s1[i] - 'a';
    arr[idx]++;
  }

  for (int i = 0; i < s2.size(); i++){
    int idx = s2[i] - 'a';
    arr[idx]--;
  }

  int answer = 0;
  for (int i : arr)
  {
    if(i != 0){
      answer += abs(i);
    }
  }
  cout << answer << '\n';
}
