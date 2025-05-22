T=int(input())
for tc in range(1,T+1):
  data=input()
  i=0
  cards={
    'S':[],
    'D':[],
    'H':[],
    'C':[],
  }
  flag=True
  while i<len(data):
    T=data[i]
    XY=data[i+1:i+3]
    if XY in cards[T]:
      flag=False
    cards[T].append(XY)
    i+=3
  if not flag:
    print(f'#{tc} ERROR')
  else:
    result=[13-len(cards['S']), 13-len(cards['D']), 13-len(cards['H']), 13-len(cards['C'])]
    print(f'#{tc}',*result)
