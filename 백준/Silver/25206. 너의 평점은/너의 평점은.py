s1 = 0
s2 = 0

grade = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0.0}

for i in range(20):
  _, a, b = input().split()

  if b != 'P':
    s1 += float(a)*grade[b]
    s2 += float(a)

print(f"{s1/s2:.6f}")