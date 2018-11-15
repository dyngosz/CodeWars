import java.util.*;

public class StackWithTwo {

      int [] arr;
      int stackOneTop;
      int stackTwoTop;
      int size;

      StackWithTwo(int capacity){
        arr = new int[capacity];
        size = capacity;
        stackOneTop = 0;
        stackTwoTop = size;

      }


      public synchronized void push(int arg, boolean firstStack){
        if(firstStack){
            pushOne(arg);
        }
        else {
            pushTwo(arg);
        }
      }

      public synchronized int pop(boolean firstStack){
        if(firstStack){
            return popOne();
        }
        else {
            return popTwo();
        }
      }

      private void pushOne(int arg) {
        if(stackOneTop < stackTwoTop - 1){
          arr[stackOneTop] = arg;
          stackOneTop++;
        }
        else {
            System.out.println("Overflow");
        }
      }

      private int popOne() {
        if(stackOneTop > 0){
            int popped = arr[stackOneTop-1];
            stackOneTop--;
            return popped;
        }
        else {
            System.out.println("Underflow");
            return 0;
        }
      }


      private void pushTwo(int arg) {
        if(stackOneTop < stackTwoTop - 1){
          stackTwoTop--;
          arr[stackTwoTop] = arg;
        }
        else {
            System.out.println("Overflow");
        }
      }
      private int popTwo() {
        if(stackTwoTop < size) {
                int popped = arr[stackTwoTop];
                stackTwoTop++;
                return popped;
        }
        else {
            System.out.println("Underflow");
            return 0;
        }
      }

      public int[] getArray() {
        return arr;
    }



    public static void main(String[] args) {

      StackWithTwo s = new StackWithTwo(10);

      s.push(1, true);
      System.out.println(Arrays.toString(s.getArray()));
      s.push(2, true);
      System.out.println(Arrays.toString(s.getArray()));
      s.push(3, false);
      System.out.println(Arrays.toString(s.getArray()));

      System.out.println(s.pop(true)); // should return 2
      System.out.println(s.pop(false)); // should return 3
      System.out.println(s.pop(true)); // should return 1
    }
}
