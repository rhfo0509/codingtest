N, M = map(int, input().split())
A = list(map(int, input().split()))

# A.sort() 

# 절단기의 높이를 이진 탐색으로 정해보자 (파라메트릭 서치)
result = 0
while start <= end:
  total = 0
  mid = (start + end) // 2
  for x in mid:
    if x > mid:
      total += x - mid
  # 떡의 양이 부족하면 더 많이 자르기 (왼쪽 탐색)
  if total < M:
    end = mid - 1
  # 떡의 양이 충분하다면 덜 자르기 (오른쪽 탐색)
  else:
    result = mid
    start = mid + 1

print(result)