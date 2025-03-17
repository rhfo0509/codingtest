# 입력 받기
N, M = map(int, input().split())
A = list(map(int, input().split()))

# 이진 탐색을 위한 시작점과 끝점 설정
start, end = 0, max(A)
result = 0

while start <= end:
    total = 0
    mid = (start + end) // 2

    # 잘린 떡의 총 길이 계산
    for x in A:
        if x > mid:
            total += x - mid

    # 떡의 길이가 부족하면 더 많이 자르기 (왼쪽 탐색)
    if total < M:
        end = mid - 1
    # 떡의 길이가 충분하면 덜 자르면서 최적 해 갱신 (오른쪽 탐색)
    else:
        # 조건을 만족했으니 일단 mid 값을 최적 해로 저장
        result = mid
        # 더 높은 값이 가능한지 확인하기 위해 오른쪽 탐색을 진행행
        start = mid + 1

print(result)
