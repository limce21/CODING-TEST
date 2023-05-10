import math
import sys


def isPrime(n):
  if n==2:
    return True
  if n<2 or n%2==0:
    return False
  m= int(n**0.5)+1
  for i in range(3,m,2):
    if n%i == 0:
      return False
    i+=2
  return True


n = sys.stdin.readline().rstrip()
if not isPrime(int(n)):
  print("no")
else:
  result = ""
  isPossible = True
  for num in n:
    if num == '1' or num == '2' or num == '5' or num == '8' or num == '0':
      result += num
    elif num == '6':
      result += '9'
    elif num == '9':
      result += '6'
    else:
      isPossible = False
      break
  if isPossible:
    result = result[::-1]
    if isPrime(int(result)):
      print("yes")
    else:
      print("no")
  else:
    print("no")
