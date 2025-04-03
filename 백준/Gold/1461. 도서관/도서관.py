N, M = map(int, input().split())
loc = list(map(int, input().split()))

# 양수와 음수를 분리하여 정렬
loc_p = sorted([x for x in loc if x > 0], reverse=True)
loc_n = sorted([x for x in loc if x < 0])

result = 0

def get_max(loc):
    """리스트에서 M개의 책을 옮길 때 최대 이동 거리 반환"""
    if not loc:
        return 0
    return abs(loc[0])

# 가장 먼 거리부터 먼저 옮기기 (처음 이동 후 돌아오지 않음)
first_max = max(get_max(loc_p), get_max(loc_n))
result += first_max

# 가장 먼 책이 있는 리스트에서 M개 삭제
if first_max in loc_p:
    del loc_p[:M]
else:
    del loc_n[:M]

# 남은 책들 옮기기 (왕복 필요)
while loc_p or loc_n:
    max_dist = max(get_max(loc_p), get_max(loc_n))
    result += 2 * max_dist

    if max_dist in loc_p:
        del loc_p[:M]
    else:
        del loc_n[:M]

print(result)