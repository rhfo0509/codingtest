while True:
  c1=c2=c3=c4=0
  try:
    s=input()
    for c in s:
      if c.islower(): c1+=1
      elif c.isupper(): c2+=1
      elif c.isnumeric(): c3+=1
      else: c4+=1
    print(c1, c2, c3, c4)
  except:
    break