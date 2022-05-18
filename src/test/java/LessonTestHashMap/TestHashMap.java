package LessonTestHashMap;

import LessonHashMap.MyHashMap;
import org.junit.*;


public class TestHashMap {

    private final MyHashMap<Integer, String> tMap = new MyHashMap<>();


    @Test
    public void putTest() {

        tMap.put(1,"Hello");
        tMap.put(2,"Hello");
        tMap.put(1,"Hello");

        Assert.assertEquals(2, tMap.size());
    }

    @Test
    public void containsKeyTest() {

        tMap.put(1,"Hello");
        Assert.assertTrue(tMap.containsKey(1));
    }

    @Test
    public void containsValueTest(){

        tMap.put(1,"Hello");
        Assert.assertTrue(tMap.containsValue("Hello"));

    }

    @Test
    public void getTest(){
        tMap.put(1,"Hi");
        tMap.put(2,"Hello");
        tMap.put(1,"By");

        Assert.assertEquals("By", tMap.get(1));
    }

}
