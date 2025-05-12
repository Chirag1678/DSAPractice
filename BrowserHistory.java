class Node {
    String data;
    Node prev;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class BrowserHistory {
    private Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        current.next = null;
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
    }

    public String back(int steps) {
        while(steps>0 && current.prev!=null) {
            current = current.prev;
            steps--;
        }
        return current.data;
    }

    public String forward(int steps) {
        while(steps>0 && current.next!=null) {
            current = current.next;
            steps--;
        }
        return current.data;
    }
}
