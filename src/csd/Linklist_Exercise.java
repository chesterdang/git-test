/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csd;


     class Node {

        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
        @Override
        public String toString() {
            return this.data +" ";
        }

        
    }

 class LinkList {

        Node head;
        Node tail;

        public LinkList() {
            this.head = null;
            this.tail = null;
        }
        public LinkList(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
        public Node search(Node p) {
            Node tempt = head;
            while (tempt.next != null) {
                if (tempt.data == p.data) break; 
                tempt = tempt.next;
            }
            return tempt;
        }
        public Node searchBefore(Node p) {
            Node tempt = head;
            while (tempt.next.next != null) {
                if (tempt.next.data == p.data) break;
                tempt = tempt.next;
            }
            return tempt;
        }
        public void addToHead(int x) {
            Node t = new Node(x);
            t.next = head;
            head = t;
            if (tail == null) tail = t;
        }
        public void addAfter(Node p, int x) {
            Node t = new Node(x);
            Node tempt = search(p);
            if (tempt.next != null) {
                t.next = tempt.next;
                tempt.next = t; 
            } else {
                tail.next = t;
                tail = t;
            }
            
        }
        public int deleteFromHead() {
            if (head != null) {
                int res = head.data;
                head = head.next;
                return res;
            } else {
                return 0;
            }
        }
        public int deleteFromTail() {
            if (tail != null) {
                int res = tail.data;
                Node tempt = head;
                while (tempt.next.next != null) {
                    tempt = tempt.next;
                }
                tempt.next = null;
                tail = tempt;
                return res;
            }
            else {
                return 0;
            }
        }
        
        public int deleteAfter(Node p) {
            Node tempt = search(p);
            int res = tempt.next.data;
            tempt.next = tempt.next.next;
            tail = tempt;
            return res;
        }
        public void delete(int x) {
            Node p = new Node(x);
            if (head.data == p.data) {
                deleteFromHead();
            } else {
                Node t = searchBefore(p);
                t.next = t.next.next;
            }
            
        }
        public int count() {
            int count = 0;
            for (Node t=head; t!=null; t=t.next) {
                count++;
            }
            return count;
        }
        public void dele(int x) {
            if (count() < x) {
                System.out.println("Not found");
            } else {
                if (x == 1) {deleteFromHead();} else {
                    int i = 0;
                    Node t = head;
                    while ((i)<(x-2) && t!= null){
                        t = t.next;
                        i++;
                    }
                    t.next = t.next.next;
                }
                
            }
        }
    @Override
    public String toString() {
        String res="";
        for (Node t=head; t!=null; t=t.next) {
            res+=t+" ";
        }
        return res;
    }

   
        
}
public class Linklist_Exercise {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addToHead(4);
        list.addToHead(3);
        list.addToHead(1);
        list.addAfter(new Node(3), 5);
        list.dele(1);
        System.out.println(list.toString());
        
    }
}
    


