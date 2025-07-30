package Leetcode.Neetcode150.LinkedList;

import java.util.LinkedHashMap;

public class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data){
        this.data = data;
        this.next = null;
    }
    /*
     * Find the length of a linked list
     */
    public static int getLength(SinglyLinkedListNode head) {
        if(head == null)
            return 0;

        return 1 + getLength(head.next);
    }

    /*
     * Insertion; at head of linkedlist
     */

     public static SinglyLinkedListNode insertAtBeg(SinglyLinkedListNode head, int val) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(val);

        node.next = head;
        head = node;

        return head;
     }

     /*
      * Insertion; at end
      */
      public static SinglyLinkedListNode insertAtEnd(SinglyLinkedListNode head, int val) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(val);

        if (head == null) {
            head = node;
        }

        SinglyLinkedListNode curr = head;

        while(curr.next != null)
            curr = curr.next;

        curr.next = node;
        return head;
        
      }

      /*
       * Insertion at position
       */
      public static SinglyLinkedListNode insertAtPos(SinglyLinkedListNode head, int pos, int val) {
        
        // This condition to check whether the
        // position given is valid or not.
        if (pos<1) {
            System.out.println("Invalid position");
            return head;
        }
            
        SinglyLinkedListNode node = new SinglyLinkedListNode(val);

        if(pos == 1) {
            node.next = head;
            head = node;
            return head;
        }

        SinglyLinkedListNode curr = head;

        while(curr != null && --pos > 1)
            curr = curr.next;
        
        if(curr == null && pos > 1){
            System.out.println("Invalid position");
            return head;
        }

        // update the next pointers
        node.next = curr.next;
        curr.next = node;
         
        return head;

      }

      /*
       * Reverse a singly linked list O(n) time, O(1) space
       */
      public static SinglyLinkedListNode reverseList(SinglyLinkedListNode head) {

        LinkedHashMap<String, String> lm = new LinkedHashMap<>(2);
        
        
        
            
            
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = head;

        while(curr != null) {
            SinglyLinkedListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head = prev;
        return head;
      }


    
}
