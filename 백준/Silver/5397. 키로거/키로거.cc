#include <bits/stdc++.h>
using namespace std;

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int T;
  cin >> T;
  for (int i = 0; i < T; i++){
    string s;
    cin >> s;
    list<char> L;
    auto cursor = L.begin();
    for (auto c : s)
    {
      if(c == '<'){
        if(cursor != L.begin())
          cursor--;
        continue;
      }
      if(c == '>'){
        if(cursor != L.end())
          cursor++;
        continue;
      }
      if(c == '-'){
        if(cursor != L.begin()){
          cursor--;
          cursor = L.erase(cursor);
        }
        continue;
      }
      L.insert(cursor, c);
    }
    for(auto c:L){
      cout << c;
    }
    cout << '\n';
  }
}
