import java.util.*;

public class JavaCollectionsHomeworkMain {
    public static void main(String[] args) {
        System.out.println("Java Collections Homework");

        //- cate un tip de colectie, unul din fiecare (list, set, map, queue)
        //- sa adaugati niste dummy values
        //- sa implementati cate un interator
        //- sa afisati acele dummy values folosind iterator-ul

        //list
        System.out.println("LIST");
        List<Integer> listaM = new ArrayList<Integer>();
        listaM.add(7);
        listaM.add(3);
        listaM.add(2);
        listaM.add(1);
        listaM.add(10);
        listaM.add(29);
        listaM.add(8);

        System.out.println("*** Iterator example - List ***");
        Iterator<Integer> myListIterator = listaM.iterator();
        while (myListIterator.hasNext()) {
            System.out.println(myListIterator.next());
        }

        System.out.println("\n*** Iterable.forEach() Example - List ***");
        listaM.forEach((temp) -> {
            System.out.println(temp);
        });

        //set
        System.out.println("\nSET");
        Set<String> setM = new HashSet<>();
        setM.add("practica");
        setM.add("de");
        setM.add("vara");
        setM.add("la");
        setM.add("msg");
        setM.add("practica"); //output: 1x practica pt ca set-ul nu admite duplicate

        System.out.println("*** Iterator example - Set ***");
        Iterator<String> mySetIterator = setM.iterator();
        while (mySetIterator.hasNext()) {
            System.out.println(mySetIterator.next());
        }

        System.out.println("\n*** Iterable.forEach() Example - Set ***");
        setM.forEach((temp) -> {
            System.out.println(temp);
        });

        //map
        System.out.println("\nMAP");
        Map<Integer, String> mapM = new HashMap<>();
        mapM.put(1,"Maria");
        mapM.put(2,"Rares");
        mapM.put(3,"Vlad");
        mapM.put(4,"Krisztian");
        mapM.put(5,"Alex");

        System.out.println("*** Iterator example - Map ***");
        Iterator<Map.Entry<Integer, String>> myMapIterator = mapM.entrySet().iterator();
        while(myMapIterator.hasNext())
        {
            Map.Entry<Integer, String> entry = myMapIterator.next();
            System.out.println("Key: " + entry.getKey() +
                    ", Value: " + entry.getValue());
        }

        System.out.println("\n*** Iterable.forEach() Example - Map ***");
        mapM.forEach((key, value)
                -> System.out.println(
                "Key: " + key
                        + ", Value: " + value));

        //queue
        System.out.println("\nQUEUE");
        Queue<Integer> queueM = new PriorityQueue<>();

        queueM.add(7);
        queueM.add(14);
        queueM.add(21);
        queueM.add(28);
        queueM.add(35);

        System.out.println("*** Iterator example - Queue ***");
        Iterator<Integer> myQueueIterator = queueM.iterator();
        while (myQueueIterator.hasNext()) {
            System.out.println(myQueueIterator.next());
        }

        System.out.println("\n*** Iterable.forEach() Example - Queue ***");
        queueM.forEach((temp) -> {
            System.out.println(temp);
        });
    }
}
