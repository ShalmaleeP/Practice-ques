package AI;

import java.util.ArrayList;
import java.util.List;

public class UCS {
	List<Nodes> open=new ArrayList<Nodes>();
	List<Nodes> close=new ArrayList<Nodes>();
	List<Integer> currentcost=new ArrayList<Integer>();
	int i,j,numofpaths,k,l,tmp,newcost;
	int cost[]=new int[30];
	
	public UCS(Nodes n){
		open.add(n);
	}

	public Nodes performUCS(Nodes n,Nodes e){
		
		Nodes rm;
		if(open.size()==0)
			return null;
		else{
			n=open.remove(0);
			if(n.equals(e))
				return e;
			for(i=0;i<n.neighbours.size();i++){
				
//				for(j=0;j<open.size();j++){						//check if current neighbor lies in open 
//					if(open.get(j).equals(n.neighbours.get(i)))
//						break;
//				}
//				for(k=0;k<close.size();k++){					//check if current neighbor lies in open
//					if(close.get(k).equals(n.neighbours.get(i)))
//						break;
//				}
				newcost=n.pathcost+n.neighbourcost.get(i);
				if(!(open.contains(n.neighbours.get(i)))&&!(close.contains(n.neighbours.get(i)))){
					n.neighbours.get(i).pathcost=n.pathcost+n.neighbourcost.get(i);
					n.neighbours.get(i).previous=n.name;
//					if(n.neighbours.get(i).name.equals("11")){
//						System.out.println(n.neighbours.get(i).name+" Added to open");
//						System.out.println("Pathcost for "+n.neighbours.get(i).name+"="+n.neighbours.get(i).pathcost);
//						System.out.println(n.neighbours.get(i).name+" parent="+n.name);
//					}	
					open.add(n.neighbours.get(i));
				}
				else if(open.contains(n.neighbours.get(i))){
					if(n.neighbours.get(i).pathcost>newcost){
						for(j=0;j<open.size();j++)
							if(open.get(j).equals(n.neighbours.get(i)))
								tmp=j;
						rm=open.remove(tmp);
						n.neighbours.get(i).previous=n.name;
						n.neighbours.get(i).pathcost=newcost;
						open.add(n.neighbours.get(i));
//						if(rm.name.equals("11")){
//							System.out.println(rm.name+" Removed from open");
//							System.out.println(n.neighbours.get(i).name+" Added to open");
//						}
						
					}	
				}
				else if(close.contains(n.neighbours.get(i))){
					if(n.neighbours.get(i).pathcost>newcost){
						for(j=0;j<close.size();j++)
							if(close.get(j).equals(n.neighbours.get(i)))
								tmp=j;
						rm=close.remove(tmp);
						n.neighbours.get(i).previous=n.name;
						n.neighbours.get(i).pathcost=newcost;
						open.add(n.neighbours.get(i));
//						if(rm.name.equals("11")){
//							System.out.println(rm.name+"Removed from close");
//							System.out.println(n.neighbours.get(i).name+" Added to open");
//						}
					}		
				}
//				if(j==open.size() && k==close.size()){
//					n.neighbours.get(i).pathcost=n.pathcost+n.neighbourcost.get(i);
//					System.out.println("Pathcost for "+n.neighbours.get(i).name+"="+n.neighbours.get(i).pathcost);
//					n.neighbours.get(i).previous=n.name;
//					System.out.println(n.neighbours.get(i).name+" parent="+n.name);
//					open.add(n.neighbours.get(i));
//					
//				}
//				else if(j!=open.size()){
//					if(n.neighbours.get(i).pathcost<n.pathcost){
//						open.remove(0);
//						open.add(n.neighbours.get(i));
//					}	
//				}
//				else if(k!=close.size()){
//					if(n.neighbours.get(i).pathcost<n.pathcost){
//						close.remove(0);
//						open.add(n.neighbours.get(i));
//					}		
//				}	
			}
			
			close.add(n);
//			if(n.name.equals("11"))
//				System.out.println(n.name+" Added to close");
//			rm=open.remove(0);
//			if(rm.name.equals("11")){
//				System.out.println(rm.name+ "Removed from open");
//			}
			for(j=0;j<open.size();j++){
				for(k=0;k<open.size()-j-1;k++){
					if(open.get(k).pathcost>open.get(k+1).pathcost){
						Nodes tmp=new Nodes();
						Nodes tmp2=new Nodes();
						tmp=open.get(k);
						tmp2=open.get(k+1);
						open.remove(k);
						open.add(k,tmp2);
						open.remove(k+1);
						open.add(k+1,tmp);
					}
						
				}
					
			}		
		}
		//open.remove(0);
		return performUCS(open.get(0),e);

	}
}

//public Nodes performUCS(Nodes n,Nodes e){
//while(open.size()!=0){
//	n=open.get(0);
//	if(n.equals(e))
//		return e;
//	for(i=0;i<n.neighbours.size();i++){
//		
//		for(j=0;j<open.size();j++){						//check if current neighbor lies in open 
//			if(open.get(j).equals(n.neighbours.get(i)))
//				break;
//		}
//		for(k=0;k<close.size();k++){					//check if current neighbor lies in open
//			if(close.get(k).equals(n.neighbours.get(i)))
//				break;
//		}
//		
//		if(j==open.size() && k==close.size()){
//			n.neighbours.get(i).pathcost=n.pathcost+n.neighbourcost.get(i);
//			System.out.println("Pathcost for"+n.neighbours.get(i).name+"="+n.neighbours.get(i).pathcost);
//			n.neighbours.get(i).previous=n.name;
//			System.out.println(n.neighbours.get(i).name+" parent="+n.name);
//			open.add(n.neighbours.get(i));
//			
//		}
//		else if(j!=open.size()){
//			if(n.neighbours.get(i).pathcost<n.pathcost){
//				open.remove(0);
//				open.add(n.neighbours.get(i));
//			}	
//		}
//		else if(k!=close.size()){
//			if(n.neighbours.get(i).pathcost<n.pathcost){					
//				close.remove(0);
//				open.add(n.neighbours.get(i));
//			}		
//		}	
//	}
//	
//	close.add(n);
//	open.remove(0);
//	for(j=0;j<open.size();j++){
//		for(k=0;k<open.size()-j-1;k++){
//			if(open.get(k).pathcost>open.get(k+1).pathcost){
//				Nodes tmp=new Nodes();
//				Nodes tmp2=new Nodes();
//				tmp=open.get(k);
//				tmp2=open.get(k+1);
//				open.remove(k);
//				open.add(k,tmp2);
//				open.remove(k+1);
//				open.add(k+1,tmp);
//			}	
//		}
//	}
//	
//	//open.remove(0);	
//}
////open.remove(0);
//return e;
//
//}





//public Nodes performUCS(Nodes n,Nodes e){
//	int i;
//	while(!n.equals(e)){
//		for(i=0;i<n.neighbours.size();i++){
//			if(n.neighbours.get(i).visited==0){
//				n.neighbours.get(i).visited=1;
//				n.neighbours.get(i).previous=n.name;
//				n.neighbours.get(i).pathcost=n.pathcost+n.neighbourcost.get(i);
//			}
//			else{
//				
//			}
//				
//		}
//	}
//	
//	return n;
//}