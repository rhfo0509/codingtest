import sys, heapq
input = sys.stdin.readline

N = int(input())

# 현재 시점 회의실 개수
cnt = 0
# N개의 회의를 모두 진행할 수 있는 최소 회의실 개수
result = 0

rooms = []

for _ in range(N):
  rooms.append(tuple(map(int, input().split())))

# 시작 시간을 기준으로 정렬
rooms.sort()

heap = []
for start, end in rooms:
  # 종료 시간이 짧은 회의가 우선순위가 높아야 함
  # 따라서 우선순위 큐 활용
  # 힙에는 (end, start) 순으로 들어가야 종료 시간 기준으로 정렬됨
  while heap and heap[0][0] <= start:
    heapq.heappop(heap)
    cnt -= 1
  heapq.heappush(heap, (end, start))
  cnt += 1
  # 현재 시점 회의실 개수와 최소 회의실 개수 비교
  result = max(result, cnt)

print(result)
