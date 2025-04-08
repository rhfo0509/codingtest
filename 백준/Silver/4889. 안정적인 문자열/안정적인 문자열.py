i=1
while True:
  s=input()
  if '-' in s:
    break
  cnt=0     # { 개수
  change=0  # 괄호 전환 횟수
  for c in s:
    if c=='}':
      if cnt==0:
        cnt+=1
        change+=1
      else:
        cnt-=1
    else:
      cnt+=1
  print(f'{i}. {change+(cnt//2)}')
  i+=1