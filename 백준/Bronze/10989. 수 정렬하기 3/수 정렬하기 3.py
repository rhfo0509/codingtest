import sys
input=sys.stdin.readline
N=int(input())
D=dict()
for i in range(1,10001):
    D[i]=0
for _ in range(N):
    D[int(input())]+=1
for i in range(1,10001):
    for j in range(D[i]):
        print(i)