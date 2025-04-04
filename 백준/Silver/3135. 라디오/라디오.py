A,B=map(int,input().split())
N=int(input())
diff=abs(A-B)
for i in range(N):
  star=int(input())
  if abs(star-B)+1<diff:
    diff=abs(star-B)+1
print(diff)