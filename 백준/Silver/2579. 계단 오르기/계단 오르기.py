N=int(input())
li=[0]*(N+1)
for i in range(1,N+1):
  score=int(input())
  if i==1:
    li[1]=(score)
  elif i==2:
    li[2]=(score,li[1]+score)
  elif i==3:
    li[3]=(li[1]+score,li[2][0]+score)
  else:
    li[i]=(max(li[i-2])+score,li[i-1][0]+score)
print(li[N]) if N==1 else print(max(li[N]))