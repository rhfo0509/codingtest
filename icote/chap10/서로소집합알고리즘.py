# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
  # 루트 노드가 아니라면 루트 노드를 찾을 때까지 재귀적으로 호출
  if parent[x] != x:
    return find_parent(parent, parent[x])
  return x

# 경로 압축ver: 해당 노드의 루트 노드가 바로 부모 노드가 된다.
def find_parent(parent, x):
  # 노드:    1   2   3   4   5
  # 부모:    1   1   2   3   4  (초기 상태)
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]
  # 노드:    1   2   3   4   5
  # 부모:    1   1   1   1   1  (경로 압축 완료)

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  # 번호가 더 작은 원소가 부모 노드가 되도록 구현
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

# 노드의 개수와 간선(union 연산)의 개수 입력받기
v, e = map(int, input().split())
parent = [i for i in range(v + 1)]

# union 연산을 각각 수행
for i in range(e):
  a, b = map(int, input().split())
  union_parent(parent, a, b)

# 각 원소가 속한 집합 출력
print('각 원소가 속한 집합: ', end='')
for i in range(1, v + 1):
  print(find_parent(parent, i), end=' ')

print()

# 부모 테이블 내용 출력
print('부모 테이블: ', end='')
for i in range(1, v + 1):
  print(parent[i], end=' ')
