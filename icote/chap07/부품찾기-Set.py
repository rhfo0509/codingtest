# 단순히 특정한 데이터가 존재하는지만 확인하고 싶다면
# set() 함수를 이용하자.

N = int(input())
NA = set(map(int, input().split()))
M = int(input())

for i in input().split():
  if int(i) in NA:
    print('yes', end=' ')
  else:
    print('no', end=' ')