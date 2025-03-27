from collections import deque
import copy

N = int(input())
indegree = [0] * (N + 1)
graph = [[] for _ in range(N + 1)]
time = [0] * (N + 1)

for i in range(1, N + 1):
  data = list(map(int, input().split()))
  time[i] = data[0]
  for j in data[1:-1]:
    # 선행 강의(j) → 후행 강의(i) 방향
    graph[j].append(i)
    indegree[i] += 1

def topology_sort():
  # 리스트의 경우, 단순히 대입 연산을 하면 값을 변경하는 데 문제 발생
  # 리스트의 값을 복제해야 할 경우 deepcopy() 함수를 사용한다.
  result = copy.deepcopy(time)
  q = deque()

  for i in range(1, N + 1):
    if indegree[i] == 0:
      q.append(i)

  while q:
    now = q.popleft()
    for i in graph[now]:
      # 인접한 노드에 대하여 현재보다 강의 시간이 더 긴 경우를 찾을 때
      # 더 오랜 시간이 걸리는 경우의 시간 값을 저장
      result[i] = max(result[i], result[now] + time[i])
      indegree[i] -= 1

      if indegree[i] == 0:
        q.append(i)

  for i in range(1, N + 1):
    print(result[i])

topology_sort()
