import sys
from collections import Counter
a = sys.stdin.read().splitlines()
for key, value in sorted(Counter(a).items()):
  print(f"{key} {(value / len(a)) * 100:.4f}")