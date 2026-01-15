#include <bits/stdc++.h>
using namespace std;

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  stack<int> s;
  int now = 1;
  list<char> answer;
  while (n--)
  {
    int val;
    cin >> val;

    if(now <= val){
      while(now <= val){
        s.push(now++);
        answer.push_back('+');
        //cout << '+' << '\n';
      }
      if(s.top() == val){
        s.pop();
        answer.push_back('-');
        //cout << '-' << '\n';
      }
    } else if (now > val){
      if(s.top() > val){
        cout << "NO";
        exit(0);
      }
      while(!s.empty() && s.top() >= val){
        s.pop();
        answer.push_back('-');
        //cout << '-' << '\n';
      }
    }

  }

  for(auto c : answer){
    cout << c << '\n';
  }
}
 