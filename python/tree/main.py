class Node: 
  def __init__(self, value):
    self.value = value
    self.left = None
    self.right = None
  
class BinaryTree:
  def __init__(self):
    self.root = None
  
  def insert(self, value):
    if self.root == None:
      self.root = Node(value)
    else:
       self.insert_recursive(self.root, value)
  
  def insert_recursive(self, current_node, value):
    if value < current_node.value:
      if current_node.left == None:
        current_node.left = Node(value)
      else:
        self.insert_recursive(current_node.left, value)
    elif value > current_node.value:
      if current_node.right == None:
        current_node.right = Node(value)
      else:
        self.insert_recursive(current_node.right, value)
  
  def pre_order(self):
    result = []
    self.pre_order_recursive(self.root, result)
    return result
  
  def pre_order_recursive(self, node, result):
    if node:
      result.append(node.value)
      self.pre_order_recursive(node.left, result)
      self.pre_order_recursive(node.right, result)

  def in_order(self):
    result = []
    self.in_order_recursive(self.root, result)
    return result
  
  def in_order_recursive(self, node, result):
    if node:
      self.in_order_recursive(node.left, result)
      result.append(node.value)
      self.in_order_recursive(node.right, result)

  def post_order(self):
        result = []
        self.post_order_recursive(self.root, result)
        return result

  def post_order_recursive(self, node, result):
    if node:
        self.post_order_recursive(node.left, result)  
        self.post_order_recursive(node.right, result) 
        result.append(node.value) 



if __name__ == "__main__":
  tree = BinaryTree()

  nodes_to_insert = [8, 3, 10, 1, 6, 14, 4, 7, 13]
  for node_value in nodes_to_insert:
      tree.insert(node_value)

  print("Percurso em Pré-Ordem (Raiz, Esquerda, Direita):")
  print(tree.pre_order())
  print("-" * 30)

  print("Percurso Em Ordem (Esquerda, Raiz, Direita):")
  print(tree.in_order())
  print("-" * 30)

  print("Percurso em Pós-Ordem (Esquerda, Direita, Raiz):")
  print(tree.post_order())
  print("-" * 30)
