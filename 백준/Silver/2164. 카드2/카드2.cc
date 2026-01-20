#include <bits/stdc++.h>
using namespace std;

int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;

  queue<int> card;
  for (int i = 1; i <= N; i++)
  {
    card.push(i);
  }

  while (card.size() > 1)
  {
    card.pop(); // 제일 위에 있는 카드를 버린다.

    card.push(card.front());
    card.pop();
  }

  int answer = card.front();
  cout << answer;
}
