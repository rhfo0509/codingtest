N=int(input())
S=[]
for _ in range(N):
  S.append(int(input()))
result=0
for i in range(N-2,-1,-1):
  if S[i]>=S[i+1]:
    result+=S[i]-S[i+1]+1
    S[i]=S[i+1]-1
print(result)