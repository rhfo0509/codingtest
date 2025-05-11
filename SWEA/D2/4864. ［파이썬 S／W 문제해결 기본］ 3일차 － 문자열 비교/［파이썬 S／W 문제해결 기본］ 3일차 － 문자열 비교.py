T=int(input())
for tc in range(1,T+1):
  str1=input()
  str2=input()
  print(f'#{tc}',end=' ')
  print(1) if str2.find(str1)!=-1 else print(0)
