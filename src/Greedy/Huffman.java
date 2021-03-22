import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Huffman {

	public static void main(String[] args) {		
		new Huffman("AABCADE");
	}
	
	public Huffman(String s) {
		PriorityQueue<Node> pq = new  PriorityQueue<Node>( new NodeComparator()); 
		
		HashMap<String, Node> mp = new HashMap<String, Node>();
		
		for(int i = 0; i < s.length(); i++) {
			String ch = s.charAt(i) + "";
			if(mp.containsKey(ch)) {
				Node n =mp.get(ch);	
				n.setCh(ch);
				n.setFrequency(n.getFrequency()+1);
			}else {
				Node n = new Node();
				n.setFrequency(1);
				n.setCh(ch);
				mp.put(ch, n);
			}
		}
		
		
		Iterator it = mp.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Node> node = (Entry<String, Node>) it.next();
			pq.add(node.getValue());
		}
		
		
		while(pq.size() > 1) {
			Node z = new Node();
			
			Node left = pq.poll();
			Node right = pq.poll();
			
			z.setLeftNode(left);
			z.setRightNode(right);
			
			z.setCh(left.getCh() + right.getCh());
			z.frequency = left.getFrequency() + right.getFrequency();
			
			pq.add(z);
		}
		
		Node n = pq.poll();
		System.out.println("Huffman tree root : " + n.getFrequency() + " :: " + n.getCh());
	
	}
	
	class NodeComparator implements Comparator<Node>{ 
        
        // Overriding compare()method of Comparator  
                    // for descending order of cgpa 
        public int compare(Node n1, Node n2) { 
            if (n1.getFrequency() < n2.getFrequency()) 
                return -1; 
        	else
                return 1; 
        } 
    } 
	
	private Node minNode(List<Node> data) {
		Node minNode = data.get(0);
		
		for(int i = 1; i < data.size(); i++) {
			if(data.get(i).getFrequency() < minNode.getFrequency() )
				minNode = data.get(i);
		}
		data.remove(minNode);
		return minNode;
	}
	
	
	private class Node
	{
		private Node leftNode;
		private Node rightNode;
		
		private String ch;
		private int frequency;

		public Node getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}

		public int getFrequency() {
			return frequency;
		}

		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}

		public String getCh() {
			return ch;
		}

		public void setCh(String ch) {
			this.ch = ch;
		}
	}
}
