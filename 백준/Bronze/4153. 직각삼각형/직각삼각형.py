while True:
    a,b,c=map(int,input().split())
    if a==0 and b==0 and c==0:
        break
    li=[a,b,c]
    li.sort()
    a,b,c=li
    print('right' if a**2+b**2==c**2 else 'wrong')
