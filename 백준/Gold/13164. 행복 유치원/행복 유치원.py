N,K=map(int, input().split())
A=list(map(int, input().split()))
A.sort()
diff = [A[i]-A[i-1] for i in range(1,N)]
diff.sort()
while K-1>0:
  diff.pop()
  K-=1
print(sum(diff))