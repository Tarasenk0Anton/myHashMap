
public class RunHashMap {

    public static void main(String[] args) {

        myHashMap myNewHashMap = new myHashMap();
        myNewHashMap.put(12, "Hi");
        myNewHashMap.put(11, "ok");
        myNewHashMap.put(125, "no");
        myNewHashMap.put(12, "Why");
        System.out.println(myNewHashMap.get(12));
        System.out.println(myNewHashMap.get(123));
        System.out.println(myNewHashMap.size());
        System.out.println(myNewHashMap.containsKey(12));
        System.out.println(myNewHashMap.containsValue("Why"));


    }


}
