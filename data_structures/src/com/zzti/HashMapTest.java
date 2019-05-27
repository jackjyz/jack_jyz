package com.zzti;



import java.util.*;


public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1,new User(22,"哈"));
        users.put(3,new User(21,"离"));
        users.put(2,new User(26,"网"));
        System.out.println(users.toString());
        HashMap<Integer, User> integerUserHashMap = sortHashMap(users);
        System.out.println(integerUserHashMap);
    }
    private static HashMap<Integer,User> sortHashMap(HashMap<Integer, User> map){
        //首先拿到map集合
        Set<Map.Entry<Integer,User>> entrySet=map.entrySet();
        //System.out.println(entrySet.iterator());
        //将set转化为list（为了使用collections中的方法）
        List<Map.Entry<Integer,User>> list = new ArrayList<Map.Entry<Integer, User>>(entrySet);
        System.out.println(list.get(1).getValue().getName());
        Comparator<Map.Entry<Integer, User>> comparator = new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        };
        list.sort(comparator);
       /* Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                //根据user的age属性倒序进行排序
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });*/
         //创建一个新的有序HashMap的子类的集合
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
        //将list中的数据转存到linkedHashMap中
        for (Map.Entry<Integer, User> entry: list){
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
}
