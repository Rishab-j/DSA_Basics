package LinkedListPractice;

public class Client {
    public static void main(String[] args) throws Exception {
        LinkedListPractice ll = new LinkedListPractice();
       
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(20);
        ll.addLast(10);
        ll.addLast(10);
        ll.display();
        ll.isPalindrome();
        
        LinkedListPractice ll2 = new LinkedListPractice();
        
        ll2.addLast(75);
        ll2.addLast(2);
        ll2.addLast(15);
        ll2.addLast(5);
        ll2.addLast(6);
        ll2.addLast(95);
        ll2.addLast(9);
        ll2.addLast(8);
        ll2.addLast(55);
        
        
        //ll2.display();

        //LinkedListPractice ans = LinkedListPractice.mergeSort(ll2);
        //ans.display();

        //LinkedListPractice merge = LinkedListPractice.merge(ll, ll2);
        //merge.display();

        //ll.reversePointIteraively();
        //ll.display();
        //ll.reverseDataRecursiveCorrect();
        //ll.display();
        //ll.isPalindrome();
        //ll.fold();
        //ll.display();
        //System.out.println(ll.KthFromLast(2));
        //System.out.println(ll.midNode_());
        
    }
}