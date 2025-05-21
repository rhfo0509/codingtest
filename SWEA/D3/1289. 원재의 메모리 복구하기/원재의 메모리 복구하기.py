T=int(input())
for tc in range(1,T+1):
  data=input()
  result=0
  cur='0'
  for bit in data:
    if bit!=cur:
      result+=1
      cur=bit
  print(f'#{tc} {result}')
