import sys
input=sys.stdin.readline
K=int(input())
stk=[]
for _ in range(K):
  N=int(input())
  stk.pop() if N==0 else stk.append(N)
print(sum(stk))