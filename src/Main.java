import java.util.*;


public class Main{
    public static void main(String args[]){
        List<Integer>[] allLists = new List[]{new ArrayList<Integer>(), new Vector<Integer>(), new LinkedList<Integer>()};
        int objectCount = 100000;


        addObjectsTest(allLists, objectCount);
        iterateListTest(allLists);
        removeObjectsTest(allLists, objectCount);


        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
        }

    }

    private static void removeObjectsTest(List<Integer>[] allLists, int objectCount) {
        Random random = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        for (int i=0; i < objectCount/10; i++)
        {
            randomNumbers.add(random.nextInt(objectCount));
        }


        for (List<Integer> list : allLists) {
            long startTime = System.currentTimeMillis();

            for(Integer randomNumber : randomNumbers)
            {
                list.remove(randomNumber);
            }

            long endTime = System.currentTimeMillis();
            long duration = endTime-startTime;
            System.out.println("Removing objects from " + list.getClass().getName() + " took " + duration + "ms.");
        }
    }

    private static void iterateListTest(List<Integer>[] allLists) {
        for (List<Integer> list : allLists)
        {
            long startTime = System.currentTimeMillis();
            for (Integer integer : list)
            {
                integer++;
            }
            long endTime = System.currentTimeMillis();
            long duration = endTime-startTime;
            System.out.println("Iterating over " + list.getClass().getName() + " took " + duration + "ms.");
        }
    }

    private static void addObjectsTest(List<Integer>[] allLists, int objectCount) {
        for (List<Integer> list : allLists) {
            long startTime = System.currentTimeMillis();

            for (Integer i = 0; i < objectCount; i++) {
                list.add(i);
            }

            long endTime = System.currentTimeMillis();
            long duration = endTime-startTime;
            System.out.println("Adding objects to " + list.getClass().getName() + " took " + duration + "ms.");
        }
    }
}
