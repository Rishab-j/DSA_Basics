package HashMap;

public class Client {
    public static void main(String[] args){
        Hashmap map=new Hashmap();
        map.put(10,100);
        map.put(20,200);
        map.put(30,300);
        map.put(40,400);
        map.put(50,500);

        map.display();
        System.out.println(map.keySet());
    }
}