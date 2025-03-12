# 좌석의 수
n = int(input())  
s = input()

# 최대 사람의 수 (= 컵홀더 수)
cnt = s.count('LL') + s.count('S') + 1

print(n) if n < cnt else print(cnt)