public class CircularLinkedList {

    private ListNode last;
    private boolean empty=true;

    public static class ListNode<T>{
        private ListNode next;
        private T data;

        public ListNode(T data){
            this.data=data;
        }

        public T getData() {
            return data;
        }
    }
    public CircularLinkedList(){
        this.last=null;
    }

    private void addEmpty(ListNode node){
        this.empty=false;
        this.last=node;
        this.last.next=this.last;
    }

    public void add(ListNode node){
        if (this.empty){
            addEmpty(node);
            return;
        }
        node.next=this.last.next;
        this.last.next=node;
        this.last=node;
    }
}
