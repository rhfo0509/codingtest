N,M=map(int,input().split())
DNA=[]
for _ in range(N):
  DNA.append(input())

result=''
total=0
for i in range(M):
  tmp={}
  for j in range(N):
    c=DNA[j][i]
    if tmp.get(c) == None:
      tmp[c] = 1
    else:
      tmp[c] += 1
  selected = sorted(tmp.items(), key=lambda x: (-x[1], x[0]))[0]
  result += selected[0]
  total += N - selected[1]
print(result)
print(total)