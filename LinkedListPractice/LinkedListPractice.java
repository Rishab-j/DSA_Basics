package LinkedListPractice;

public class LinkedListPractice {
    // A LinkedList contain a node,it's head and tail

    private class Node {
        int data;
        Node next = null;
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // ADD -----------------------------------------

    public void addLast(int data) {
        Node node = new Node();
        node.data = data;

        if (size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            tail.next = node;
            // node.next=null;
            this.tail = node;
        }
        this.size++;
    }

    public void addFirst(int data) {
        Node node = new Node();
        node.data = data;

        if (size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = head;// node ab head ko point krrr rha h
            this.head = node;
        }

        this.size++;
    }

    public void addNodeAt(int idx, int data) throws Exception {
        if (idx < 0 || idx > this.size) {
            throw new Exception("Invalid");
        } else if (idx == 0) {
            addFirst(data);
        } else if (idx == this.size) {
            addLast(data);
        } else {
            Node prevNode = getAtNode(idx - 1);
            Node forwNode = prevNode.next;
            Node node = new Node();
            node.data = data;
            // always keep in mind that the list should not get displaced
            node.next = forwNode;
            prevNode.next = node;
            this.size++;

        }
    }

    // Remove ---------------------------------------------------

    public int removeFirst() throws Exception {
        // removeFirst means remove the head

        if (this.size == 0) {
            throw new Exception("List is empty");
        }

        int rv = this.head.data;

        if (size == 1) {
            head = null;
            tail = null;
            this.size--;
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
            this.size--;
        }
        return rv;
    }

    public int removeLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("List is empty");
        }
        int rv = this.tail.data;
        if (size == 1) {
            head = null;
            tail = null;
            this.size--;
        } else {
            Node secondLast = getAtNode(this.size - 2);
            secondLast.next = null;
            tail = secondLast;
            this.size--;
        }
        return rv;
    }

    public int removeNodeAt(int idx) throws Exception {
        if (idx < 0 || idx > this.size) {
            throw new Exception("Invalid");
        } else if (idx == 0) {
            return removeFirst();
        } else if (idx == this.size) {
            return removeLast();
        } else {

            // Steps:
            // 1. get the prev node
            // 2. the node you want to delete is next of prev node
            // 3. make next of prev equal to next of node you want to delete
            // 4. make next of node equal to null (so here the prev is not pointing to the
            // node and node's next is not poiting to any node hence deleted)

            Node prev = getAtNode(idx - 1);
            Node node = prev.next;
            // Node temp = forw.next;
            prev.next = node.next;
            node.next = null;
            // prev.next=temp;
            size--;

            return node.data;
        }
    }
    // Dispay ---------------------------------------------------

    public void display() {
        Node curr = this.head;

        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public void displayReverse() {
        displayReverse(this.head);
    }

    private void displayReverse(Node node) {
        if (node == null) {
            return;
        }
        displayReverse(node.next);
        System.out.print(node.data + "->");
    }

    // Get ------------------------------------------------------

    public Node getFirstNode() throws Exception {
        if (head == null) {
            throw new Exception("List is Empty:");
        }
        return head;
    }

    public Node getLastNode() throws Exception {
        if (head == null) {
            throw new Exception("List is Empty:");
        }
        return tail;
    }

    public Node getAtNode(int idx) throws Exception {
        if (this.size == 0) {
            throw new Exception("List is Empty");
        } else if (idx < 0 || idx > this.size) {
            throw new Exception("Invalid Input");
        } else {
            Node node = this.head;// agr 0 input aaega to loop ni chlega aur ye node hi return hojaaega
            for (int i = 0; i < idx; i++) {
                node = node.next;
            }
            return node;
        }
    }

    public int getFirst() throws Exception {
        Node node = getFirstNode();
        return node.data;
    }

    public int getLast() throws Exception {
        Node node = getLastNode();
        return node.data;
    }

    public int getAt(int idx) throws Exception {
        Node node = getAtNode(idx);
        return node.data;
    }

    // Reverse the linked list ----------------------------

    public void reverseIterative() throws Exception {
        // in this function we are just changing the data
        int left = 0;
        int right = this.size - 1;
        while (left < right) {
            Node lNode = this.getAtNode(left);
            Node rNode = this.getAtNode(right);
            int temp = lNode.data;
            lNode.data = rNode.data;
            rNode.data = temp;
            left++;
            right--;
        }

    }

    public void reversePointIteratively() {
        Node prev = this.head;
        Node curr = head.next;

        while (curr != null) {
            // aate hi curr ki next position store krli
            Node next = curr.next;
            // reverse krna
            curr.next = prev;
            // update
            prev = curr;
            curr = next;
        }

        Node temp = this.tail; // tail ko store kra jo reverse list ka head h
        tail = head; // tail ko shi kra
        head = temp; // head to shi kra
        tail.next = null;// tail ke next ko shi kra (or) first node ka next ko shi kra

    }

    public void reverseRecursively() {

        reverseRecursively(this.head);

        Node temp = head;
        head = tail;// agr head seeddha tail ko point krne lgta to tail correct head ko point ni krr
                    // pata islie upar preserve krr lia
        tail = temp;
        tail.next = null;

    }

    private void reverseRecursively(Node node) {

        if (node == tail) { // node == tail pe hi islie base case lgaya quki hum node ke next ke next ko
                            // node
                            // prr point krr rhe h but "null" ka next kuch hota hi ni error aa jata to hume
                            // ye casse alg se handle krna pdta
            return;
        }

        reverseRecursively(node.next); // going deep in the recursion reaching towards the last node
        // end pe pohoch gye ab reverse krna start kra
        // node ke next ka next aur aage point krr rha tha but ab wo dobara usi pe point
        // krr rha h
        node.next.next = node;

    }

    // this code has a fatal flaw

    public void reverseDataRecursive(Node left, Node right, int floor) {

        if (right == null) {
            return;
        }
        // we do not change the left in the parameters,only changed the right
        // so at the the top of recursion stack the right would point to the last node
        // and left would still point to our first node
        // that's what we want for our swapping of data (as like in our iterative
        // function)
        // floor variable is keeping count of the nodes
        reverseDataRecursive(left, right.next, floor + 1);
        // we will just swap half way
        if (floor >= size / 2) {
            // swaping of data
            int data = right.data;
            right.data = left.data;
            left.data = data;
            // updating the left

            // here is the flaw
            // we only update the left in that particular level of stack
            // so it does not reflect back to the lower level
            // in the lower level the left is still pointing to the first node
            // so the last swap would occur between the mid node and first node only

            left = left.next;
            // jbb ye saare kaam khtm ho jaaega apne aap neeche wale level pe chla jaaega
        }
    }

    // so to solve this issue we could make our left variable global as we did with
    // head and tail but then our linked list would not look good
    // so instead we make a Class to store the left pointer
    class HeapMover {
        Node node;
    }

    public void reverseDataRecursiveCorrect() {
        HeapMover left = new HeapMover(); // now this object is created in the heap and that is accessible by all
        left.node = head; // initially pointed to head ; means the address of head is stored here for now
                          // so now we can change the left in the function
        reverseDataRecursiveCorrect(left, head, 0);
    }

    private void reverseDataRecursiveCorrect(HeapMover left, Node right, int floor) {

        if (right == null) {
            return;
        }

        reverseDataRecursiveCorrect(left, right.next, floor + 1);
        // we will just swap half way
        if (floor >= size / 2) {
            // swaping of data
            int data = right.data;
            right.data = left.node.data;
            left.node.data = data;

            left.node = left.node.next;// now we update the address in the object created in the heap

            // so basically what is happening here that the parameter is pointing to the
            // address of heap object and the member in that object is actually pointing to
            // our required node
        }
    }

    // Palindrome -------

    public void isPalindrome() {
        HeapMover left = new HeapMover();
        left.node = this.head;
        boolean isPalindrome = isPalindrome(left, head, 0);
        System.out.println(isPalindrome);
    }

    public boolean isPalindrome(HeapMover left, Node right, int floor) {
        if (right == null) {
            return true;
        }
        boolean isPalindrome = isPalindrome(left, right.next, floor + 1);// iss line se hum ye chate h ki hum right most
                                                                         // tkk pohoch jaae

        if (floor >= this.size / 2) {
            if (isPalindrome == false) { // ek baar bhi false aate hi peeche false return hota jaaega
                return false;
            } else {
                if (left.node.data == right.data) {
                    left.node = left.node.next;
                    return true;

                } else {
                    return false;
                }

            }
        }
        return isPalindrome;
    }

    // Fold -----------------------------

    public void fold() {
        HeapMover left = new HeapMover();
        left.node = head;
        fold(left, this.head, 0);
    }

    private void fold(HeapMover left, Node right, int floor) {
        if (right == null) {
            return;
        }

        fold(left, right.next, floor + 1);

        if (floor > this.size / 2) {// jbb tk floor jada h size/2 se tbb tkk fold krte rho
            Node oln = left.node.next; // preserved the original next
            left.node.next = right; // started folding
            right.next = oln; // single fold ended

            left.node = oln;// updating left in the heap
        }

        // upr ke code ke baad
        // left update hua milega heap mei hi
        // aur right apni shi location hoga jo ki stack mei stored h
        // so doabar fold hoga

        // floor jbb size/2 ke equal ho jaae tbb hmari folding khtm ho chuki h
        // floor ke equal hote hi tail ko update krdo

        else if (floor == size / 2) { // jbb floor size/2 ho jaaega uss level ka right tail hoga 
            this.tail = right;
            this.tail.next = null;
        }
    }

    // Get last Kth node

    public int KthFromLast(int k) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public int midNode_() {
        Node slow = midNode();
        return slow.data;
    }

    public Node midNode() {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) { // jbb tkk ye dono condition true h
                                                              // fast ka next null ni hona chaie aur sath hi sath
                                                              // fast ka next ka next bhi null ni hona chaie
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted List

    public static LinkedListPractice merge(LinkedListPractice one, LinkedListPractice two) { // static function aise
                                                                                             // function hote h jinko
                                                                                             // bina object bnae call
                                                                                             // krr skte h
        LinkedListPractice res = new LinkedListPractice();
        Node oNode = one.head;
        Node tNode = two.head;

        while (oNode != null && tNode != null) {
            if (oNode.data < tNode.data) {
                res.addLast(oNode.data);
                oNode = oNode.next;
            } else {
                res.addLast(tNode.data);
                tNode = tNode.next;
            }
        }

        while (oNode != null) {
            res.addLast(oNode.data);
            oNode = oNode.next;
        }

        while (tNode != null) {
            res.addLast(tNode.data);
            tNode = tNode.next;
        }
        return res;
    }

    // Odd-Even-------------------------

    // constraints are : O(n) time and O(1) space

    public void oddEven() throws Exception {

        LinkedListPractice odd = new LinkedListPractice();
        LinkedListPractice even = new LinkedListPractice();// at this point we have 3 linked list
                                                           // so that means 3 diff. head,tail and size

        // time complexity is just O(n) because all other operations are of constant
        // time and only a while loop is running

        while (this.size != 0) { // "this" refers to the object made in client in our case
                                 // but in general this contains the context of object here our object is "ll2"
                                 // so when we say this.size we mean ll2's size
            int ele = this.removeFirst(); // O(1) complexity
            if (ele % 2 != 0) {
                odd.addLast(ele); // we are not using extra space here
                                  // after removing from our "this" list we just added it to odd list
                                  // so the space was reduced by 1 and then increased by 1 hence, constant space
            } else {
                even.addLast(ele);
            }
        }

        if (odd.size == 0) { // if there are no odd elements
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        }

        else if (even.size == 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        } else {
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;

            odd.tail.next = even.head;
        }
    }

    // Remove duplicates ------------

    // the linked list is already sorted

    public void removeDuplicates() throws Exception {
        LinkedListPractice list = new LinkedListPractice();

        while (this.size != 0) {

            int ele = this.removeFirst();

            if (list.isEmpty() || list.tail.data != ele) {
                list.addLast(ele);
            }
        }

        this.head = list.head;
        this.tail = list.tail;
        this.size = list.size;

    }

    // Kreverse ---------------

    public void kReverse(int k) throws Exception {
        LinkedListPractice newList = new LinkedListPractice(); // ye list apni reversedList contain krega
        LinkedListPractice temp = new LinkedListPractice(); // ye list to revers ekrne mei help krega

        // Let's say our original list size was 15 and k was 3
        // so the while loop will run not n(=15) times but n/k(=5) times
        // since we delete 3 items everytime in our for loop and for loop will run k
        // times
        // so total complexity is n/k*k=n => O(n)

        while (this.isEmpty() == false) {

            for (int i = 0; i < k; i++) {
                temp.addFirst(this.removeFirst()); // dry run krr
            }

            if (newList.size == 0) { // first time
                newList = temp;

                // or

                // newList.head = temp.head;
                // newList.tail = temp.tail;
                // newList.size = temp.size;

                temp = new LinkedListPractice(); // temp ko hrr baar khali krr dena
            } else {
                newList.tail.next = temp.head;
                newList.tail = temp.tail;
                newList.size += temp.size;

                temp = new LinkedListPractice();
            }
        }
        
        this.head = newList.head;
        this.tail = newList.tail;
        this.size = newList.size;
    }

    // Merge Sort ------------------

    public static LinkedListPractice mergeSort(LinkedListPractice list) {

        if (list.size == 1) {
            return list;
        }

        LinkedListPractice firstHalf = new LinkedListPractice();
        LinkedListPractice secondHalf = new LinkedListPractice();

        Node mid = list.midNode();

        firstHalf.head = list.head;
        firstHalf.tail = mid;
        firstHalf.size = (list.size + 1) / 2; // if the list contains odd members then size of firsthalf would be 9+1/2
                                              // = 5
                                              // and size of second half would be 9/2 = 4
                                              // if the list is even the first half = 8+1/2 = 4
                                              // and second half = 8/2;

        secondHalf.head = mid.next;
        secondHalf.tail = list.tail;
        secondHalf.size = list.size / 2;

        mid.next = null; // phele null islie ni kia quki mid ke aage ki list kho jaati

        firstHalf = mergeSort(firstHalf); // firstHalf ko sort krr dia
        secondHalf = mergeSort(secondHalf);// secondHalf ko sort dia

        LinkedListPractice ans = merge(firstHalf, secondHalf);

        return ans;

    }

}