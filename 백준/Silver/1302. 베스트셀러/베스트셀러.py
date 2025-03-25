N = int(input())
d = dict()
for _ in range(N):
  s = input()
  if d.get(s):
    d[s] += 1
  else:
    d[s] = 1

max_value = max(d.values())
best_seller = [i[0] for i in d.items() if i[1] == max_value]
print(sorted(best_seller)[0])