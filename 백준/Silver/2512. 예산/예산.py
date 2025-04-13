N=int(input())
budgets=list(map(int,input().split()))
total=int(input())
if sum(budgets)<=total:
  print(max(budgets))
  exit()
# 예산 상한액을 "최대"로
# 파라메트릭 서치
start,end=1,max(budgets)
while start<=end:
  mid=(start+end)//2
  res=0
  for budget in budgets:
    res+=min(budget,mid)
  if res<=total:
    start=mid+1
  else:
    end=mid-1
print(end)