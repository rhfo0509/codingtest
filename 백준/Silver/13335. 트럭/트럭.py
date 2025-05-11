from collections import deque
n,w,L=map(int,input().split())
trucks=deque(map(int,input().split()))
bridge=deque([0]*w)
# 현재 다리에 있는 트럭들의 무게의 합
cur_w=0
# 현재 소요시간
time=0
while True:
  time+=1
  cur_w-=bridge.popleft()
  if len(trucks)>=1 and cur_w+trucks[0]<=L:
    truck=trucks.popleft()
    cur_w+=truck
    bridge.append(truck)
  else:
    bridge.append(0)
    # 더 이상 남아있는 트럭이 없다면 끝
    if cur_w==0 and len(trucks)==0:
      break
print(time)