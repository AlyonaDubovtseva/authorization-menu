package lab19;

public class Right extends BinaryTree {

    @Override
    public void traversalTree() {
        System.out.println("Обход справа: ");
        rightTraversal(root);
        System.out.println();
    }

    private void rightTraversal(ITree node){
        if(node == null) {return;}
        rightTraversal(node.left());
        rightTraversal(node.right());
        System.out.print(node.value() + ", ");
    }
}
