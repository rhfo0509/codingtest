from collections import deque
import copy
N,M=map(int,input().split())
data=[list(map(int,input().split())) for _ in range(N)]
#  0: 빈 칸
blank_cnt=0
# -1: 벽
# -2: 비활성 바이러스
virus=[]
for i in range(N):
  for j in range(N):
    if data[i][j]==0:
      blank_cnt+=1
    elif data[i][j]==1:
      data[i][j]=-1
    else:
      data[i][j]=-2
      virus.append((i,j))

# case: 빈 칸이 없는 경우
if blank_cnt==0:
  print(0)
  exit()

# bfs: 바이러스 전파
dx=[-1,1,0,0]
dy=[0,0,-1,1]
visited=[[False]*N for _ in range(N)]
def bfs(selected):
  q=deque(selected)
  c_data=copy.deepcopy(data)
  c_visited=copy.deepcopy(visited)
  c_blank_cnt=blank_cnt
  for x,y in selected:
    c_data[x][y]=1
    c_visited[x][y]=True
  while q:
    px,py=q.popleft()
    for i in range(4):
      nx=px+dx[i]
      ny=py+dy[i]
      if 0<=nx<N and 0<=ny<N and c_data[nx][ny] in (0,-2) and not c_visited[nx][ny]:
        if c_data[nx][ny]==-2:
          c_blank_cnt+=1
        c_data[nx][ny]=c_data[px][py]+1
        c_visited[nx][ny]=True
        c_blank_cnt-=1
        # 더 이상 빈 방이 없다면
        if c_blank_cnt==0:
          return c_data[nx][ny]-1
        q.append((nx,ny))
  # 모든 바이러스가 전파 된 후에도 빈 방이 있다면
  return -1 

# dfs: 비활성 바이러스 중 활성화시킬 M개의 바이러스 선택
def dfs(start, selected):
  global result
  if len(selected)==M:
    tmp=bfs(selected)
    if tmp!=-1:
      result=min(result,tmp)
    return
  for i in range(start, len(virus)):
    dfs(i+1,selected+[virus[i]])

result=int(1e9)
dfs(0,[])
print(-1) if result==int(1e9) else print(result)