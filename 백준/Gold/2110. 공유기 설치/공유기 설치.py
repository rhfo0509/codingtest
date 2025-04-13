import sys
input=sys.stdin.readline
N,C=map(int,input().split())
houses=[]
for _ in range(N):
  houses.append(int(input()))
houses.sort()

# 인접한 두 공유기 사이의 최대 거리
# 파라메트릭 서치
start,end=1,houses[-1]-houses[0]
res=0
while start<=end:
  mid=(start+end)//2
  cnt=1
  router=houses[0]
  for house in houses:
    if house>=router+mid:
      cnt+=1
      router=house
  # 조건 충족 시 최대 거리 늘리기
  if cnt>=C:
    res=mid
    start=mid+1
  # 조건 충족 안되면 최대 거리 줄이기
  else:
    end=mid-1
print(res)