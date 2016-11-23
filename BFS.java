package AI;

import java.util.*;
public class BFS {

	List<Nodes> queue=new ArrayList<Nodes>();
	int i;
	int cost=0,level=0;
	public BFS(Nodes n){
		n.visited=1;
		queue.add(n);
	}
	public Nodes createBFS(Nodes n, Nodes end){
		if(n.equals(end)){
			//System.out.println(n.name+" "+n.level);
			//System.out.println("Tree Complete");
			return n;
		}
			
		else{
			for(i=0;i<n.neighbours.size();i++){
				if(n.neighbours.get(i).visited==0){
					n.neighbours.get(i).visited=1;
					n.neighbours.get(i).level=n.level+1;
					n.neighbours.get(i).previous=n.name;
					queue.add(n.neighbours.get(i));
					//System.out.println(n.name+" is parent of "+n.neighbours.get(i).name);
					//System.out.println(n.neighbours.get(i).name+" is at "+n.neighbours.get(i).level);
					
				}	
			}
			
			queue.remove(0);
			return createBFS(queue.get(0), end);
		}	
		
	}	
}
