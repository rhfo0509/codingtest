N=int(input())
A=list(map(int,input().split()))
T,P=map(int,input().split())
r=0
for a in A:
  r+=a//T+1 if a%T else a//T
print(r)
print(N//P,N%P)