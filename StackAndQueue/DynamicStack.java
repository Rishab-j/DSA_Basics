package StackAndQueue;

public class DynamicStack extends Stack {
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public void push(int val) throws Exception {
        if (this.size == this.arr.length) {
            int[] temp = this.arr; // old data copy
            reassign(2 * temp.length);

            for (int ele : temp) {
                push_(ele);
            }
        }

        super.push(val);
    }

}