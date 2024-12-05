
public class stack {
    King[] KingStack;
    int top;

    public stack(int size) {
        KingStack = new King[size];
        top = -1;
    }

    public void push(King Kings) {
        if (top >= KingStack.length - 1) {
            System.out.println("Stack overflow");
            return;
        }
        KingStack[++top] = Kings;
    }

    public King peek(King Kings) {
        return KingStack[top];
    }

    public void printStack(King[] Kings) {
        if (top == -1) {
            System.out.println("No defeated kings.");
        } else {
            System.out.println("Defeated Kings:");
            for (int i = top; i >= 0; i--) {
                KingStack[i].printKing(Kings);
                System.out.println();
            }
        }
    }
}
