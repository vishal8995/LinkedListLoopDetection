public class LoopDetection {

    Node head;

    public static void main(String[] args) {

        LoopDetection list = new LoopDetection();

        list.push(2);
        list.push(4);
        list.push(6);
        list.push(8);
        list.push(10);

        list.head.next.next.next.next = list.head;

        list.detectLoop(list.head);
    }

    private static void detectLoop(Node head) {
        if (head == null) System.out.println("Empty List !!");

        Node fast = head.next;
        Node slow = head;
        boolean flag = false;

        while(fast != null && fast.next != null && slow != null){
            if(fast == slow){
                flag = true;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if(flag)
            System.out.println("Loop Exists at "+fast.data+" !!");
        else
            System.out.println("Loop does not exist !!");
    }

    private void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

}
