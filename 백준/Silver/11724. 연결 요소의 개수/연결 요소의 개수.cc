#include <bits/stdc++.h>
using namespace std;

vector<int> arr[1001];
bool visited[1001];
int N, M;

void bfs(int v){
  queue<int> Q;
  visited[v] = true;
  Q.push(v);

  while(!Q.empty()){
    int now = Q.front();
    Q.pop();
    for (int i = 0; i < arr[now].size(); i++)
    {
      int idx = arr[now][i];
      if (!visited[idx]){
        visited[idx] = true;
        Q.push(idx);
      }
    }
  }
}

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> N >> M;
  for (int i = 0; i < M; i++){
    int u, v;
    cin >> u >> v;
    arr[u].push_back(v);
    arr[v].push_back(u);
  }

  int answer = 0;
  for (int i = 1; i <= N; i++)
  {
    if(!visited[i]){
      bfs(i);
      answer++;
    }
  }

  cout << answer;
}
