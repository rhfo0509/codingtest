T=int(input())
def is_palindrome(s):
  return s==s[::-1]
for tc in range(1,T+1):
  N,M=map(int,input().split())
  data=[list(input()) for _ in range(N)]
  result=''
  for i in range(N):
    for j in range(N-M+1):
      s1=data[i][j:j+M]
      if is_palindrome(s1):
        result=''.join(s1)
        break
      s2=[data[k][i] for k in range(j, j+M)]
      if is_palindrome(s2):
        result=''.join(s2)
        break
    if result!='':
      break
  print(f'#{tc} {result}')
