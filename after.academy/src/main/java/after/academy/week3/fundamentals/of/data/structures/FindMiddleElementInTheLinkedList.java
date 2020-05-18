package after.academy.week3.fundamentals.of.data.structures;

import after.academy.week3.fundamentals.of.data.structures.LinkList.Node;

public class FindMiddleElementInTheLinkedList {

/**
 * TC O(N) , Aux TC O(1) and Space TC O(1)
 *  	
 */
	private static <T> Node<T> findMiddleElement(Node<T> header) {
	
		if(header == null || header.getNext() == null || header.getNext().getNext() == null) {
			return header;
		}
		
		Node<T> slow = header , fast = header;
		
		while(fast != null && fast.getNext() != null ) {
			
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		return slow;
	}
	
	public static void main(String[] args) {

		LinkList<Integer> link = new LinkList<Integer>();
		
		link.createLinkList(1);
		link.createLinkList(2);
		link.createLinkList(3);
		link.createLinkList(4);
		link.createLinkList(5);
		link.createLinkList(6);
		link.createLinkList(7);
		link.createLinkList(8);
		
		System.out.println("middle element would be "+FindMiddleElementInTheLinkedList.findMiddleElement(link.getHeader()));

	}

}
