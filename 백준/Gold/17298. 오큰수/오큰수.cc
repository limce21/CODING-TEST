#include <bits/stdc++.h>
using namespace std;

int A[1000000];
int result[1000000];

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;
  stack<pair<int, int>> S;
  for (int i = 0; i < N; i++)
  {
    cin >> A[i];
    while(!S.empty() && S.top().first < A[i]){
      int idx = S.top().second;
      result[idx] = A[i];
      S.pop();
    }
    result[i] = -1;
    S.push({A[i], i});
  }
  for (int i = 0; i < N; i++){
    cout << result[i] << " ";
  }
}
