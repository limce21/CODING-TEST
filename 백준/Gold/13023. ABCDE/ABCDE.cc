#include <bits/stdc++.h>
using namespace std;

vector<int> arr[2000];
bool visited[2000];
int N, M;

void dfs(int v, int depth){
  if(depth == 4){
    cout << 1;
    exit(0);
  }
  for (int i = 0; i < arr[v].size(); i++){
    int idx = arr[v][i];
    if (visited[idx])
      continue;
    visited[idx] = true;
    dfs(idx, depth + 1);
    visited[idx] = false;
  }
}

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> N >> M;
  for (int i = 0; i < M; i++){
    int a, b;
    cin >> a >> b;
    arr[a].push_back(b);
    arr[b].push_back(a);
  }

  for (int i = 0; i < N; i++){
    visited[i] = true;
    dfs(i, 0);
    visited[i] = false;
  }

  cout << 0;
}
