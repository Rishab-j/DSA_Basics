package StackAndQueue;

public class Queue{
    
    protected int[] arr;
    protected int size=0;
    protected int front=0;
    protected int back=0;

    public Queue(){
        reassign(10);
    }

    public Queue(int size){
        reassign(size);
    }

    public void reassign(int size){
        this.arr=new int[size];
        this.size=0;
        this.front=0;
        this.back=0;
    }

    public int size(){
        return this.size();
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    //Steps: have to print data from front to back
    // run a loop from i = 0 to size 
    // add that i to front_idx and modulos by arr.length
    // that would be our true idx
    
    public void display(){
        for(int i=0;i<this.size;i++){
            int idx=(i+this.front)%this.arr.length;
            System.out.print(arr[idx]+ " ");
        }

        System.out.println();
    }

    // Steps: First of all check if the size is equal to size of array if true then it means queue is full
    // 1. add value at back pointer
    // 2. update back pointer by keeping in mind that queue could be empty at the beginning 
    //    so use (back+1)%arr.length
    // 3. increase size

    protected void push_(int val){
        this.arr[this.back]=val;
        this.back=(this.back+1)%this.arr.length;
        this.size++;
    
    }

    public void push(int val) throws Exception{
        if(this.size==this.arr.length){
            throw new Exception("QueueSizeFull");
        }
         push_(val);
     }


    // Steps:First of all check if the size is equal to 0 if true then it means queue is empty
    // 1. preserve the value to be deleted rv = arr[front]
    // 2. make the arr[front]=0
    // 3. update front by using (front+1)%arr.length
    // 4. size--

    public int pop() throws Exception{
        if(this.size==0){
            throw new Exception("QueueEmpty");
        }

        int rv=this.arr[this.front];
        this.arr[this.front]=0;
        this.front=(this.front+1)%this.arr.length;
        this.size--;

        return rv;
    }

    public int front() throws Exception{
        if(this.size==0){
            throw new Exception("QueueEmpty");
        }

        return this.arr[this.front];
    }
    
}