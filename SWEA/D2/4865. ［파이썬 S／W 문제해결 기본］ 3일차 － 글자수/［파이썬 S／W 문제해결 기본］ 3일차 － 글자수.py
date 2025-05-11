T=int(input())
for tc in range(1,T+1):
  str1=input()
  str2=input()
  D=dict()
  for c in str1:
    D[c]=0
  for c in str2:
    if D.get(c)!=None:
      D[c]+=1
  result=0
  for cnt in D.values():
    result=max(result,cnt)
  print(f'#{tc} {result}')