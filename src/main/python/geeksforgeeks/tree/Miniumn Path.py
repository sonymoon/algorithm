def pathHeight(root, current):
    if not root.left and not root.right:
        return current

    lh, rh = 999, 999
    if root.left:
        lh = pathHeight(root.left, current + 1)
    if root.right:
        rh = pathHeight(root.right, current + 1);

    return min(lh, rh)


from TreeNode import TreeNode

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)

root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

print pathHeight(root, 1)
