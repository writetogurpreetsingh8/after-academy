package after.academy.week3.fundamentals.of.data.structures;

import after.academy.week3.fundamentals.of.data.structures.LinkList.Node;

/**
 *	
 *Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here 
 *we are talking about the node number and not the value in the nodes 
 * TC = O(N), stack space O(1)
 * and aux space is O(1)
 * 
 */
public class OddNodeFollowedByEvenNodes {

	
	private static <T> Node<T> segregateOddAndEvenNodes(Node<T> header) {
		
		if(header == null || header.getNext() == null || header.getNext().getNext() == null) {
			
			return header; // either list is null , having 1 or 2 nodes only! that means already segregated!
		}
		
		Node<T> oddHeader = header,evenHeader = header.getNext(),oddTemp = oddHeader,evenTemp = evenHeader;
		
		while( (evenTemp != null && evenTemp.getNext() != null) ) {
			
			oddTemp.setNext(evenTemp.getNext());
			oddTemp = oddTemp.getNext();
			
			evenTemp.setNext(oddTemp.getNext());
			evenTemp = evenTemp.getNext();
		}
		oddTemp.setNext(evenHeader);
		
		return oddHeader;
	}
	
	
	
	
	public static void main(String[] args) {

		LinkList<Integer> link = new LinkList<Integer>();
		
		link.createLinkList(8);
		link.createLinkList(7);
		link.createLinkList(6);
		link.createLinkList(5);
		link.createLinkList(4);
		link.createLinkList(3);
		link.createLinkList(2);
		link.createLinkList(1);
		
		System.out.println(OddNodeFollowedByEvenNodes.segregateOddAndEvenNodes(link.getHeader()));
		
	}

}
