public class IsADemo {
    public static void main(String[] args) {
        List61B<String> somelist = new SLList<>();
        somelist.addFirst("elk");
        somelist.addFirst("fx");
//        System.out.println(somelist.getFirst());
        System.out.println(somelist.getLast());
        System.out.println(somelist.get(0));
        System.out.println(somelist.removeLast());
        somelist.print();
    }
}
