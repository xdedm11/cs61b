public class VengefulSLList<Item> extends SLList<Item>{
    SLList<Item> deletedItems;
    //SLList<Item> deletedItems = new SLList<Item>();
    public VengefulSLList() {
        super();
        deletedItems = new SLList<Item>();
    }

    public VengefulSLList(Item x) {
        super(x);   //构造函数带参数时，应显示调用superclass的带参构造函数/默认调用的是不带参的
        deletedItems = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addFirst(x);
        return x;
    }

    public void printLostItems(){
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>();
        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);
        vs1.removeLast();
        vs1.removeLast();
        System.out.println("The fallen are: ");
        vs1.printLostItems();

        VengefulSLList<Integer> vs2 = new VengefulSLList<>(9);
        SLList<Integer> s1 = vs2;
        s1.addLast(50);     //VengefulSLList doesn't override,uses SLList's.
        s1.removeLast();        //Uses VengefulSLList's

        ((VengefulSLList<Integer>)s1).printLostItems();
    }
}
