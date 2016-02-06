import java.util.*;
public class BullyAlgorithmImplement {
    public static void main(String[] args) {
    	Random r = new Random();
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter total Nodes: ");
    	int n = s.nextInt();
    	System.out.println ("Current Co-ordinator: "+n);
    	System.out.println ("Node "+n+" Crashed");
    	int x = r.nextInt(n-1);
    	int j=0;
    	for(j=x;j<n;j++){
    		System.out.println ("\nNode "+j+" starts Election");
    		for(int i=j+1;i<=n;i++){
    			System.out.println ("Election Message: "+j+"->"+i);
    		}
    		for(int i=j+1;i<n;i++){
    			System.out.println ("OK Message: "+i+"->"+j);
    		}
    	}
    	System.out.println ("Node: "+(j-1)+" Becomes the Co-ordinator");
    }
}
/*Output:
Enter total Nodes: 10
Current Co-ordinator: 10
Node 10 Crashed

Node 6 starts Election
Election Message: 6->7
Election Message: 6->8
Election Message: 6->9
Election Message: 6->10
OK Message: 7->6
OK Message: 8->6
OK Message: 9->6

Node 7 starts Election
Election Message: 7->8
Election Message: 7->9
Election Message: 7->10
OK Message: 8->7
OK Message: 9->7

Node 8 starts Election
Election Message: 8->9
Election Message: 8->10
OK Message: 9->8

Node 9 starts Election
Election Message: 9->10
Node: 9 Becomes the Co-ordinator
*/