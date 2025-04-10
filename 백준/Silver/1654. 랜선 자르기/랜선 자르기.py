import sys
input=sys.stdin.readline
K,N=map(int,input().split())
A=[]
for i in range(K):
  A.append(int(input()))

# 파라메트릭 서치
start,end=1,(2**31)-1
res=0
while start<=end:
  mid=(start+end)//2
  cnt=0
  for i in A:
    cnt+=i//mid
  # K로 N을 만들 수 있다면
  if cnt>=N:
    # 일단 저장해두고
    res=mid
    # 랜선의 길이가 더 길어도 되는지 확인
    start=mid+1
  # N보다 더 적게 만들었다면
  else:
    # 랜선의 길이를 더 짧게 해야 함
    end=mid-1
print(res)