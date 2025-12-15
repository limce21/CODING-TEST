#include <bits/stdc++.h>
using namespace std;

bool occur[2000001];

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, x;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++){
    cin >> a[i];
  }
  cin >> x;

  int answer = 0;
  for (int i = 0; i < n; i++)
  {
    if(x - a[i] > 0 && occur[x-a[i]])
      answer++;
    occur[a[i]] = true;
  }
  cout << answer << '\n';
}
