#include <bits/stdc++.h>
using namespace std;

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  list<int> L;
  for (int i = 1; i <= n; i++){
    L.push_back(i);
  }
  auto cursor = L.begin();
  cout << '<';
  while(L.size() > 0){
    for (int i = 0; i < k - 1; i++)
    {
      cursor++;
      if(cursor == L.end()){
        cursor = L.begin();
      }
    }

    cout << *cursor;
    if(L.size() > 1)
      cout << ", ";
    cursor = L.erase(cursor);
    if(cursor == L.end()){
      cursor = L.begin();
    }
  }
  cout << '>';
}
 