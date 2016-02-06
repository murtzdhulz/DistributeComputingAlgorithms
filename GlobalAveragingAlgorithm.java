import java.util.*;
class Node{
	int no;
	Date date;
	boolean changed;
	long skew=0;
	public Node(int n, Date d){
		no = n;
		date = d;
	}
	public String toString(){
		return no+": "+date.toString().split(" ")[3];
	}
}
class TimeComparator implements Comparator<Node>{
	public int compare(Node a, Node b){
		return b.date.compareTo(a.date);
	}
}
public class GlobalAveragingAlgorithm {
    public GlobalAveragingAlgorithm() {
    }
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	System.out.print ("Enter no. of Nodes: ");
    	int n = s.nextInt();
    	System.out.print ("Enter Fixed Time (Hour Minute): ");
    	Calendar c = Calendar.getInstance();
    	Date ft = new Date(c.YEAR, c.MONTH, c.DAY_OF_MONTH, s.nextInt(), s.nextInt());
    	System.out.println ("Enter Time for each Node (Hour Minute): ");
    	PriorityQueue<Node> p = new PriorityQueue<Node>(n, new TimeComparator());
    	for(int i=0;i<n;i++){
    		System.out.print ("Node "+i+": ");
    		Date nt = new Date(c.YEAR, c.MONTH, c.DAY_OF_MONTH, s.nextInt(), s.nextInt());
    		p.add(new Node(i,nt));
    	}
    	Node[] nodes = new Node[n];
    	
    	p.toArray(nodes);
    	System.out.println (Arrays.toString(nodes));
    	
    	for(int i=0;i<nodes.length;i++){
    		long diff=0;
    		if(nodes[i].date.compareTo(ft)<0){
    			diff = ft.getTime()-nodes[i].date.getTime();
    			for(int j=0;j<nodes.length;j++){
    				nodes[j].date.setTime(nodes[j].date.getTime()+diff);
    			}
    		}
    		System.out.println ("\nTime after "+diff+" Milliseconds (Node: Time)");
    		System.out.println (Arrays.toString(nodes));
    		for(int j=0;j<nodes.length;j++){
    			nodes[j].skew+=nodes[j].date.getTime()-ft.getTime();
    			System.out.println ("Skew of Node "+nodes[j].no+": "+ nodes[j].skew);
    		}
    	}
    	System.out.println ();
    	for(int i=0;i<nodes.length;i++){
    		long skew = (nodes[i].skew/n);
    		System.out.println ("Average Skew of Node "+nodes[i].no+" :"+skew);
    		nodes[i].date.setTime(nodes[i].date.getTime()-skew);
    	}
    	System.out.println ("\nSynchronized Time After Adjusting (Node: Time): ");
    	System.out.println (Arrays.toString(nodes));
    }
}
/*Output:
Enter no. of Nodes: 4
Enter Fixed Time (Hour Minute): 10 15
Enter Time for each Node (Hour Minute): 
Node 0: 10 00
Node 1: 10 05
Node 2: 10 10
Node 3: 10 15
[3: 10:15:00, 2: 10:10:00, 1: 10:05:00, 0: 10:00:00]

Time after 0 Milliseconds (Node: Time)
[3: 10:15:00, 2: 10:10:00, 1: 10:05:00, 0: 10:00:00]
Skew of Node 3: 0
Skew of Node 2: -300000
Skew of Node 1: -600000
Skew of Node 0: -900000

Time after 300000 Milliseconds (Node: Time)
[3: 10:20:00, 2: 10:15:00, 1: 10:10:00, 0: 10:05:00]
Skew of Node 3: 300000
Skew of Node 2: -300000
Skew of Node 1: -900000
Skew of Node 0: -1500000

Time after 300000 Milliseconds (Node: Time)
[3: 10:25:00, 2: 10:20:00, 1: 10:15:00, 0: 10:10:00]
Skew of Node 3: 900000
Skew of Node 2: 0
Skew of Node 1: -900000
Skew of Node 0: -1800000

Time after 300000 Milliseconds (Node: Time)
[3: 10:30:00, 2: 10:25:00, 1: 10:20:00, 0: 10:15:00]
Skew of Node 3: 1800000
Skew of Node 2: 600000
Skew of Node 1: -600000
Skew of Node 0: -1800000

Average Skew of Node 3 :450000
Average Skew of Node 2 :150000
Average Skew of Node 1 :-150000
Average Skew of Node 0 :-450000

Synchronized Time After Adjusting (Node: Time): 
[3: 10:22:30, 2: 10:22:30, 1: 10:22:30, 0: 10:22:30]
*/