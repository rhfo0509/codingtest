def Z(N,x,y):
  if N==0:
    return 0
  # 총 방문횟수: 2**2N
  # 변의 길이: 2**N
  elif R<x+2**(N-1) and C<y+2**(N-1):
    return Z(N-1,x,y)
  elif R<x+2**(N-1) and C>=y+2**(N-1):
    return 2**(2*N-2)+Z(N-1,x,y+2**(N-1))
  elif R>=x+2**(N-1) and C<y+2**(N-1):
    return (2**(2*N-2))*2+Z(N-1,x+2**(N-1),y)
  else:
    return (2**(2*N-2))*3+Z(N-1,x+2**(N-1),y+2**(N-1))
N,R,C=map(int,input().split())
print(Z(N,0,0))