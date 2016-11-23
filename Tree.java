package AI;

import java.util.ArrayList;

public class Tree {
	ArrayList<Nodes> node=new ArrayList<Nodes>();
	String added="";
	//Nodes node[]=new Nodes[100];
	public void addedge(String start,String end, int cost)
	{
		Nodes n1=new Nodes();
		Nodes n2=new Nodes();
		if(added.indexOf(" "+start+" ")==-1){	
			n1.name=start;
			node.add(n1);
			added=added+" "+start+" ";
		}
		if(added.indexOf(" "+end+" ")==-1){
			n2.name=end;
			node.add(n2);
			added=added+" "+end+" ";
		}
		
		Nodes nd=new Nodes();
		for(int i=0;i<node.size();i++){
			 nd=node.get(i);
			if(nd.name.equals(start)){
				n1=nd;
				break;
			}		
		}
		
		for(int i=0;i<node.size();i++){
			 nd=node.get(i);
			if(nd.name.equals(end)){
				n2=nd;
				break;
			}		
		}
		
		//n1=getNodeByName(start);
		//n2=getNodeByName(end);
		n1.neighbours.add(n2);
		n1.neighbourcost.add(cost);
				
	}
	public Nodes getNodeByName(String str)
	{
		Nodes nd=new Nodes();
		for(int i=0;i<node.size();i++){
			 nd=node.get(i);
			if(nd.name.equals(str))
				return nd;
		}
		return nd;		
	}
//	public boolean nodeinneighbour(Nodes n1,String str){
//		for(int i=0;i<n1.neighbours.size();i++)
//			if(n1.neighbours.get(i).name.equals(str))
//				return true;
//		return false;
//	}
	
	public void printadjlist(){
		int i,j;
		for(i=0;i<node.size();i++){
			Nodes curr=node.get(i);
			System.out.println("Node:"+curr.name);
			System.out.println("Neighbours are");
			for(j=0;j<curr.neighbours.size();j++)
				System.out.println(curr.neighbours.get(j).name+" "+curr.neighbourcost.get(j));
		}
	
	}

}
