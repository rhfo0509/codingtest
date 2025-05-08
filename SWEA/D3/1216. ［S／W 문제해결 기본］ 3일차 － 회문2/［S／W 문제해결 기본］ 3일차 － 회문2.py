T=10
def is_palindrome(s):
  return s==s[::-1]
for tc in range(1,T+1):
  N=int(input())
  data=[list(input()) for _ in range(100)]
  length=100
  flag=False
  while length>0:
    # 오른쪽 방향으로 탐색
    for i in range(100):
      for j in range(101-length):
        # 팰린드롬 여부
        s=data[i][j:j+length]
        if is_palindrome(s):
          flag=True
          break
      if flag==True:
        break
    if flag==True:
      break
        
    # 아래쪽 방향으로 탐색
    for i in range(100):
      for j in range(101-length):
        # 팰린드롬 여부
        s=[data[k][i] for k in range(j, j+length)]
        if is_palindrome(s):
          flag=True
          break
      if flag==True:
        break
    if flag==True:
      break

    length -= 1
  
  print(f'#{N} {length}')
