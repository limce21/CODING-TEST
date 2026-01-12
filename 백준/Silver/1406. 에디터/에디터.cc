#include <bits/stdc++.h>
using namespace std;

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  cin >> s;
  list<char> L;
  for(auto c: s)
    L.push_back(c);
  auto cursor = L.end();

  int n;
  cin >> n;
  for (int i = 0; i < n; i++){
    char op;
    cin >> op;
    if(op == 'L'){
      if(cursor != L.begin())
        cursor--;
      continue;
    }
    if(op == 'D'){
      if(cursor != L.end())
        cursor++;
      continue;
    }
    if(op == 'B'){
      if(cursor != L.begin()){
        cursor--;
        cursor = L.erase(cursor);
      }
      continue;
    }
    if(op == 'P'){
      char add;
      cin >> add;
      L.insert(cursor, add);
    }
  }

  for(auto c:L){
    cout << c;
  }
}
