# 퀵 정렬이란 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법이다.
# 일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘 중 하나로, 병합 정렬과 더불어 대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 되는 알고리즘이다.
# 가장 기본적인 퀵 정렬은 첫 번째 데이터를 기준 데이터(pivot)로 설정한다.

# 퀵 정렬은 평균적으로 O(NlogN)의 시간 복잡도를 가진다.
# 최선의 경우 -> 분할이 일어날 때마다 왼쪽과 오른쪽이 절반씩 분할되는 경우 -> 데이터의 개수(N) * 높이/횟수(logN)
# 최악의 경우 -> 데이터가 이미 정렬되어 있는 경우 -> O(N^2) -> 삽입 정렬과 반대되는 특성
# 퀵 정렬을 제공하는 라이브러리는 최악의 경우에도 시간 복잡도가 O(NlogN)이 되는 것을 보장할 수 있도록 피벗값을 설정할 때 추가적인 로직을 더해준다.

a = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(a, start, end):
  # 원소가 1개인 경우 종료
  if start >= end:
    return
  # 첫 원소를 pivot으로 설정정
  pivot = start
  left = start + 1
  right = end

  while left <= right:
    while left <= end and a[left] <= a[pivot]: left += 1
    while right > start and a[right] >= a[pivot]: right -= 1

    # 만약 위치가 엇갈렸다면 작은 데이터와 피벗을 교체
    if left > right:
      a[right], a[pivot] = a[pivot], a[right]
    # 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
    else:
      a[left], a[right] = a[right], a[left]
  
  # 분할 이후 왼쪽과 오른쪽 부분에서 재귀적으로 정렬 수행
  quick_sort(a, start, right - 1)
  quick_sort(a, right + 1, end)

quick_sort(a, 0, len(a) - 1)
print(a)