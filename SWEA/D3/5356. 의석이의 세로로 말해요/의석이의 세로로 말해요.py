T=int(input())
for tc in range(1,T+1):
  data=[[] * 5 for _ in range(15)]
  for i in range(5):
    s=input()
    for j in range(len(s)):
      data[j].append(s[j])
  result=''
  for i in range(15):
    result+=''.join(data[i])
  print(f'#{tc} {result}')
