def pathHeight(root, current):
    if not root.left and not root.right:
        return current

    lh, rh = 999, 999
    if root.left:
        lh = pathHeight(root.left, current + 1)
    if root.right:
        rh = pathHeight(root.right, current + 1);

    return min(lh, rh)


from Node import Node

root = Node(1)
root.left = Node(2)
root.right = Node(3)

root.left.left = Node(4)
root.left.right = Node(5)

print pathHeight(root, 1)
