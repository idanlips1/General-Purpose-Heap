
import java.util.Arrays;
@SuppressWarnings("unchecked")
public class GeneralPurposeHeap<T extends Comparable<T>> {
    private T[] heapArray;
    private int capacity;
    private int size;

    public GeneralPurposeHeap() {
        this.capacity = 10; // default
        this.heapArray = (T[]) new Comparable[capacity];
        this.size = 0; // current number of element in the heap
    }

    public GeneralPurposeHeap(int initalCapacity) {
        this.capacity = initalCapacity; // maximum number of elements a heap can hold
        this.size = 0; // current number of elements in the heap
        this.heapArray = (T[]) new Comparable[capacity];
    }

    public GeneralPurposeHeap(T[] initialData) {
        this.capacity = initialData.length * 2; // maximum number of elements a heap can hold
        this.size = initialData.length; // current number of elements in the heap
        this.heapArray = Arrays.copyOf(initialData, capacity);
        sortArray();

    }

    private void sortArray() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            PercolateDown(i);
        }

    }

    public void PercolateDown(int index) {
        if (index < (size / 2)) {

            while (index < (size / 2)) {
                int leftChild = 2 * index + 1;
                int rightChild = 2 * index + 2;
                int minChild = 0;
                if (leftChild == this.size - 1) {
                    minChild = leftChild;

                } else if (heapArray[leftChild].compareTo(heapArray[rightChild]) < 0) {
                    minChild = leftChild;
                } else if (heapArray[leftChild].compareTo(heapArray[rightChild]) > 0) {
                    minChild = rightChild;
                } else {
                    minChild = leftChild;
                }
                if (heapArray[index].compareTo(heapArray[minChild]) > 0) {
                    swap(index, minChild);
                    index = minChild;

                } else {
                    return;
                }
            }

        } else {
            System.out.println("Already at the lowest possible position.");
        }

    }

    public void PercolateUp(int index) {
        if (index == 0) {
            System.out.println("Already at the root");
        } else {
            int parent = (index - 1) / 2; // Array starts at 0
            while (index > 0 && heapArray[index].compareTo(heapArray[parent]) < 0) {
                swap(index, parent);
                index = parent;
                parent = (index - 1) / 2;

            }

        }
    }

    private void swap(int i, int j) {
        T temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    public void insert(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (heapArray[0] == null) {
            heapArray[0] = element;
            size++;
            return;
        }
        if (size >= capacity) {
            ResizeArray();
        }
        heapArray[size] = element;
        size++;
        PercolateUp(size - 1);
    }

    private void ResizeArray() {
        capacity *= 2; // double the capacity
        T[] newHeapArray = (T[]) new Comparable[capacity];
        System.arraycopy(heapArray, 0, newHeapArray, 0, size);
        heapArray = newHeapArray;
    }

    public T findMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        } else {
            return this.heapArray[0];
        }

    }

    public int getSize() {
        return this.size;
    }

    public T deleteMin() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is empty");
        }
        T min = heapArray[0];
        heapArray[0] = heapArray[size - 1];
        size--;
        PercolateDown(0);
        return min;
    }

    public void mergeHeap(GeneralPurposeHeap<T> otherHeap) {
        T[] newArray = (T[]) new Comparable[otherHeap.size + this.size];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.heapArray[i];
        }
        for (int i = 0; i < otherHeap.size; i++) {
            newArray[i + this.size] = otherHeap.heapArray[i];
        }
        this.heapArray = newArray;
        this.size += otherHeap.size;
        this.sortArray();
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += heapArray[i].toString() + ", ";

        }
        return str;
    }


      public static void main(String[] args) {
      // Test for insert + toString + findmin
      GeneralPurposeHeap<MoltDriver> moltDriver = new GeneralPurposeHeap<>();

      }


}
