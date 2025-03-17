N = int(input())
NA = list(map(int, input().split()))
M = int(input())
MA = list(map(int, input().split()))

# 이진탐색을 위해 정렬 수행
NA.sort()

# 이진탐색 함수 (반복)
def binary_search(array, target, start, end):
  while start <= end:
    mid = (start + end) // 2
    if array[mid] == target:
      return 'yes'
    elif array[mid] < target:
      start = mid + 1
    else:
      end = mid - 1
  return 'no'


for data in MA:
  print(binary_search(NA, data, 0, N-1), end=' ')
