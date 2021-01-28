public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
        /*
        * Java里面对处在在-128~127之间的Integer值，用的是原生数据类型int，
        * 此时调用的是Integer.valueOf()方法，会在内存里供重用，
        * 也就是说这之间的Integer值进行==比较时只是进行int原生数据类型的数值比较，
        * 而超出-128~127的范围，进行==比较时是进行地址及数值比较。*/
    }
}
