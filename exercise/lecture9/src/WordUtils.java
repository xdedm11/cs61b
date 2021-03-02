public class WordUtils {
    public static String longest(List61B<String> list) {
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1) {
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if (thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static void main(String[] args) {
        AList<String> somelist = new AList<>();
        somelist.addLast("1");
        somelist.addLast("23");
        somelist.addLast("456");
        System.out.println(longest(somelist));
    }
}
