#include <bits/stdc++.h>
using namespace std;

int people[500000];

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;

  stack<pair<int, int>> S;
  long long result = 0;
  for (int i = 0; i < N; i++)
  {
    cin >> people[i];
    int cnt = 1;
    while (!S.empty() && S.top().first <= people[i])
    {
      result += S.top().second;
      if(S.top().first == people[i])
        cnt += S.top().second;
      S.pop();
    }

    if(!S.empty())
      result++;
    S.push({people[i], cnt});
  }

  cout << result;
}
