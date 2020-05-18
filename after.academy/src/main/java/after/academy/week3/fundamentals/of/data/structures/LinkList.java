package after.academy.week3.fundamentals.of.data.structures;

public class LinkList<T> {

	private Node<T> header;
	
	static class Node<T>{
		
		private T data;
		private Node<T> next;
		
		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
		Node<T> getNext(){
			return this.next;
		}
		T getData() {
			return this.data;
		}
		
	}
	
	public Node<T> getHeader(){
		return header;
	}
	
	
	
	public Node<T> createLinkList(T data) {
		
	 Node<T> node = new Node<>();
	 node.data = data;
	 node.next = header;
	 header = node;
	 return header;
	 
	}
	
	public static void main(String[] args) {
		
		LinkList<Integer> link = new LinkList<Integer>();
		link.createLinkList(1);
		link.createLinkList(2);
		link.createLinkList(3);
		link.createLinkList(4);
		
		System.out.println(link);
		
		System.out.println(link.header.next);
		System.out.println(link.header);
		

	}

}
