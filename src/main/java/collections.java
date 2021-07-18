import java.util.*;

public class collections {

        public void printCollection(Collection<Integer> A){
            Iterator<Integer> iterator= A.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
//            for (String s : myList)
//                System.out.print(s);
        }
        public void printMap(Map<Integer,String> map){
            for (Map.Entry<Integer,String> mapElement : map.entrySet()) {
                int key = (int)mapElement.getKey();
                String value = (String)mapElement.getValue();
                System.out.println(key + ":" + value);
            }
        }
    public static void main(String[] args) {
        collections collection=new collections();
        Random r = new Random();
        List<Integer> myList = new ArrayList<>();
        System.out.println("List:");
        for (int i=0;i<5;i++) {
             myList.add(r.nextInt(100-1)+1);
        }
        collection.printCollection(myList);

        Set<Integer> mySet =new HashSet<>();
        System.out.println("Set:");
        mySet.add(22);
        mySet.add(10);
        mySet.add(1999);
        mySet.add(123);
        mySet.add(10);
        collection.printCollection(mySet);

        Queue<Integer> myQueue= new LinkedList<>();
        System.out.println("Queue:");
        for (int i=0;i<5;i++) {
            myQueue.add(r.nextInt(100-1)+1);
        }
        collection.printCollection(myQueue);

        Map<Integer, String> myMap = new HashMap<>();
        System.out.println("Map:");
        myMap.put(1,"Paine");
        myMap.put(2,"Lapte");
        myMap.put(5,"CocaCola");
        myMap.put(3,"Oua");
        myMap.put(4,"Apa");
        collection.printMap(myMap);

    }
}
