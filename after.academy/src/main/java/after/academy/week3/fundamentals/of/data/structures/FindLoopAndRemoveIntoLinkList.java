package after.academy.week3.fundamentals.of.data.structures;

import after.academy.week3.fundamentals.of.data.structures.LinkList.Node;

public class FindLoopAndRemoveIntoLinkList {

	/**
	 * TC O(N) , aux O(1) and stack O(1)
	 * below solution will only work in case of sorted set of element 
	 * present in the linkedList either distinct or non-distinct
	 */
	
	private static <T> void findLoopAndRemoveOnSortedSetOfData(Node<T> header) {
		
		if(header == null || header.getNext() == null) {
			System.out.println("either list is empty or found no loop/cycle");
			return;
		}
		
		Node<T> mover = header , prev = null;

		while(mover != null && mover.getNext() != null) {
			
			prev = mover;
			mover = mover.getNext();
			
			if(((Integer)mover.getData() - (Integer)prev.getData()) <=0 ) {
				// find loop
				System.out.println("find loop here!");
				break;
			}
		}
		prev.setNext(null);
	}
	
	/**
	 * TC O(N) , stack space O(1) and aux O(1)
	 * we can also mention TC in term of O(fast + slow)
	 * becoz we uses fast and slow to traverse the list
	 *  Traversing senerio case A & B
	 *  
	 *  A) untill fast != slow 
	 *  fast has traverse = header to n approx. O(N)
	 *  slow has traverse = header to n/2 approx O(N/2)
	 *  
	 *  B) if fast == slow (To remove the loop)
	 *  fast has traverse = n to slow approx O(N)
	 *  slow has traverse = header to fast  approx O(N/2)
	 *  
	 */
	private static <T> void findLoopAndRemoveOnUnSortedSetOfData(Node<T> header) {
		
		if(header == null || header.getNext() == null) {
			System.out.println("either list is empty or found no loop/cycle");
			return;
		}

		Node<T> fast = header;
		Node<T> slow = header;
		
		while(fast != null && fast.getNext() != null) {
			
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow == fast) {
				break;
			}
		}
		
		if(fast == slow) {
			
			System.out.println("found cycle............");
			
			slow = header;
			while(slow.getNext() != fast.getNext()) {
				
				slow = slow.getNext();
				fast = fast.getNext();
			}
			fast.setNext(null);
			
		}
		
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
		
		System.out.println("display list before creating loop...........");
		// display list before creating loop
		System.out.println(link.getHeader());
		
		// creating loop where with last node and give node
		link.createLoopIntoLinkList(link.getHeader().getNext().getNext());
		
		
		System.out.println("after identify and remove the loop........");
		
		// find loop and remove if list having sorted data........
		//FindLoopAndRemoveIntoLinkList.findLoopAndRemoveOnSortedSetOfData(link.getHeader());
		
		//find loop and remove if list having sorted as well as un-sorted data........
		FindLoopAndRemoveIntoLinkList.findLoopAndRemoveOnUnSortedSetOfData(link.getHeader());
		System.out.println("list is "+link.getHeader());
		
		
		
		
	}

}
