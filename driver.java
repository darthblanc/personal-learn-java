public class driver {
    public static void main(String[] args) {
        BetaList<Integer> list = new BetaList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        System.out.println(list);
        list.add(5, 1);
        list.remove(1);
//        list.remove(5);
        System.out.println(list.size());
        list.clear();
        System.out.println(list);

        BetaMap<Integer, Integer> map = new BetaMap<>();
        map.put(1, 5);
        map.put(2, 3);
        map.put(1, 3);
        map.remove(2);
        System.out.println(map);
    }
}
