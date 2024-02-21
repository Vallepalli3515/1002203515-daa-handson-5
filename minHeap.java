import java.util.ArrayList;
import java.util.List;

class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) >> 1;
    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private int right(int i) {
        return (i << 1) + 2;
    }

    private void heapify(int i) {
        int smallest = i;
        int left = left(i);
        int right = right(i);
        int n = heap.size();
        if (left < n && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < n && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            heapify(smallest);
        }
    }

    public void buildMinHeap(List<Integer> arr) {
        heap = new ArrayList<>(arr);
        int n = heap.size();
        for (int i = (n >> 1) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public Integer getMin() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public Integer popMin() {
        if (heap.isEmpty()) {
            return null;
        }
        int minVal = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return minVal;
    }
    
    // Example usage
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        // Example 1
        heap.buildMinHeap(List.of(7, 15, 25, 30, 17, 20, 40, 50, 12));
        System.out.println("\nExample 2 - Initial min heap: " + heap.heap);
        System.out.println("Example 2 - Root node (min): " + heap.getMin());
        System.out.println("Example 2 - Popping min element: " + heap.popMin());
        System.out.println("Example 2 - Min heap after popping: " + heap.heap);
    }
}