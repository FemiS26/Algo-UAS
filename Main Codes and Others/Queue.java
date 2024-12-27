public class Queue {
    Enemy[] queue;
    int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new Enemy[capacity];
        front = 0;
        
    }
    
}
