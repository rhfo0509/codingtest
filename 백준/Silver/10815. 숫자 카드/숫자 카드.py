N=int(input())
cards=set(map(int,input().split()))
M=int(input())
for target in map(int,input().split()):
  if target in cards:
    print(1, end=' ')
  else:
    print(0, end=' ')