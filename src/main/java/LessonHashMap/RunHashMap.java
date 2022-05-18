package LessonHashMap;

public class RunHashMap {

    public static void main(String[] args) {

        MyHashMap myNewHashMap = new MyHashMap();
        myNewHashMap.put(12, "Hi");
        myNewHashMap.put(11, "ok");
        myNewHashMap.put(123, "no");
        myNewHashMap.put(127, "Why");
        System.out.println(myNewHashMap.get(12));
        System.out.println(myNewHashMap.get(123));
        System.out.println(myNewHashMap.size());
        System.out.println(myNewHashMap.containsKey(12));
        System.out.println(myNewHashMap.containsValue("Why"));


    }


}
