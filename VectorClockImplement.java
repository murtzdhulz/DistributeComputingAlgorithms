import java.util.*;
class Event{
	Event incoming;
	int clock[];
	int eid;
	int pid;
	public Event(int p,int e,int n){
		pid=p;
		eid=e;
		clock=new int[n];
	}
}
class Process{
	int pid;
	Event e[];
}
class VectorClock{
	Process p[];
	public void input(){
		Scanner s = new Scanner(System.in);
		System.out.print ("Enter no. of Process: ");
		int n = s.nextInt();
		p=new Process[n];
		for (int i = 0; i<n; i++){
			p[i]=new Process();
			System.out.print ("Enter no. of Events in Process "+i+": ");
			int en = s.nextInt();
			p[i].e = new Event[en];
			int x=1;
			for (int j = 0; j<en; j++) {
				p[i].e[j]=new Event(i,j,n);
				p[i].e[j].clock[i]=x++;
			}
		}
		do{
			System.out.print ("Enter Incoming Event ids: ");
			int p1=s.nextInt();
			int e1=s.nextInt();
			int p2=s.nextInt();
			int e2=s.nextInt();
			updateClock(p[p1].e[e1].clock,p[p2].e[e2].clock,p1);
			for(int i=e1+1;i<p[p1].e.length;i++){
				for(int j=0;j<p[p1].e[i].clock.length;j++){
					if(j!=p1){
						p[p1].e[i].clock[j]=p[p1].e[e1].clock[j];
					}
				}
			}
			System.out.print ("Press 0 to end");
		}while(s.nextByte()!=0);
		output();
	}
	void updateClock(int[] a,int[] b,int x){
		for(int i=0;i<a.length;i++){
			if(i!=x){
				a[i]=Math.max(a[i],b[i]);
			}
		}
	}
	void output(){
		for(int i=0;i<p.length;i++){
			System.out.println ("Process: "+i);
			for(int j=0;j<p[i].e.length;j++){
				System.out.print ("Event "+p[i].e[j].pid+", "+p[i].e[j].eid+": ");
				System.out.println (Arrays.toString(p[i].e[j].clock));
			}
		}
	}
}
public class VectorClockImplement {
    public static void main(String[] args) {
    	(new VectorClock()).input();
    }
}
/*Output:
Enter no. of Process: 3
Enter no. of Events in Process 0: 3
Enter no. of Events in Process 1: 4
Enter no. of Events in Process 2: 2
Enter Incoming Event ids: 1 1 0 1
Press 0 to end1
Enter Incoming Event ids: 1 2 2 0
Press 0 to end1
Enter Incoming Event ids: 0 2 1 3
Press 0 to end0
Process: 0
Event 0, 0: [1, 0, 0]
Event 0, 1: [2, 0, 0]
Event 0, 2: [3, 4, 1]
Process: 1
Event 1, 0: [0, 1, 0]
Event 1, 1: [2, 2, 0]
Event 1, 2: [2, 3, 1]
Event 1, 3: [2, 4, 1]
Process: 2
Event 2, 0: [0, 0, 1]
Event 2, 1: [0, 0, 2]
*/