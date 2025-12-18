#include <bits/stdc++.h>
using namespace std;

int arr[6][2];

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, k;
  cin >> n >> k;
  int answer = 0;

  for (int i = 0; i < n; i++){
    int s, y;
    cin >> s >> y;
    if(arr[y - 1][s] % k == 0){
      answer++;
    }
    arr[y - 1][s]++;
  }

  cout << answer << '\n';
}
