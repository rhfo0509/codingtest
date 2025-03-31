N=int(input())
seq_p=[]
seq_n=[]
zero_cnt=0
for _ in range(N):
  n=int(input())
  if n==0:
    zero_cnt+=1
  elif n>0:
    seq_p.append(n)
  else:
    seq_n.append(n)
seq_p.sort()
seq_n.sort(reverse=True)

res=0
while len(seq_p) > 1:
  a=seq_p.pop()
  b=seq_p.pop()
  if a>=1 and b==1:
    res+=a+b
  else:
    res+=a*b
  
while len(seq_n) > 1:
  a=seq_n.pop()
  b=seq_n.pop()
  res+=a*b

if seq_n and zero_cnt==0:
  res+=seq_n[0]
if seq_p:
  res+=seq_p[0]

print(res)