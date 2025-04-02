import sys
input=sys.stdin.readline
N=int(input())
T=[]
for _ in range(N):
  T.append(int(input()))
T.sort(reverse=True)
print(sum([max(0, t-i) for i,t in enumerate(T)]))