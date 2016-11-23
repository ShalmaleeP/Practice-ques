package AI;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	List<Nodes> stack=new ArrayList<Nodes>();
	int i,flag=0;
	int cost=0,level=0;
	public DFS(Nodes n){
		n.visited=1;
		stack.add(n);
		
	}
	public Nodes createDFS(Nodes n, Nodes end){	
		
		while(!n.equals(end)){
			flag=0;
			for(i=0;i<n.neighbours.size();i++){
				if(n.neighbours.get(i).visited==0){
					flag=1;
					n.neighbours.get(i).visited=1;
					n.neighbours.get(i).level=n.level+1;
					//n=n.neighbours.get(i);
					n.neighbours.get(i).previous=n.name;
					stack.add(0,n.neighbours.get(i));
					System.out.println(n.name+" is parent of "+n.neighbours.get(i).name);
					System.out.println(n.neighbours.get(i).name+" is at "+n.neighbours.get(i).level);
					n=stack.get(0);
					break;
				}
				//stack.remove(0);
				//n=stack.get(0);
			}
				
			if(n.equals(end))
				break;
			if((flag==0&&i==n.neighbours.size())||n.neighbours.size()==0){
				stack.remove(0);
				n=stack.get(0);
			}
			
		}
		
		return n;
//		if(n.equals(end)){
//			//System.out.println(n.name+" "+n.level);
//			//System.out.println("Tree Complete");
//			return n;
//		}
//			
//		else{
//			for(i=0;i<n.neighbours.size();i++){
//				if(n.neighbours.get(i).visited==0){
//					n.neighbours.get(i).visited=1;
//					n.neighbours.get(i).level=n.level+1;
//					n.neighbours.get(i).previous=n.name;
//					stack.add(0,n.neighbours.get(i));
//					n= createDFS(stack.get(0), end, i++);
//					System.out.println("i="+i+", n="+n.name);
//					
//				}	
//			}
//			//System.out.println(n.name+" "+n.level);
//			stack.remove(0);
//		}
//		return stack.get(0);
	
		
		}
}
