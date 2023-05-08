import sys

def preorder(tree, node):
  print(node, end='')
  for v in tree[node]:
    if v != '.':
      preorder(tree, v)

def inorder(tree, node):
  ln, rn = tree[node]
  if ln != '.':
    inorder(tree, ln)
  print(node, end='')
  if rn != '.':
    inorder(tree, rn)

def postorder(tree, node):
  ln, rn = tree[node]
  if ln != '.':
    postorder(tree, ln)
  if rn != '.':
    postorder(tree, rn)
  print(node, end='')
  

n = int(sys.stdin.readline())
tree = {}

for _ in range(n):
  pn, ln, rn = sys.stdin.readline().rstrip().split()
  tree[pn] = [ln, rn]

preorder(tree, 'A')
print()
inorder(tree,'A')
print()
postorder(tree, 'A')