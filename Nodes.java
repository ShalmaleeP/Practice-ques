package AI;
import java.io.*;
import java.util.*;
public class Nodes {
	String name;
	int visited=0;
	int level=0;
	int pathcost=0;
	int heuristic=0;
	String previous="";
	ArrayList<Nodes> neighbours=new ArrayList<Nodes>();
	ArrayList<Integer> neighbourcost=new ArrayList<Integer>();
	public Nodes()
	{
		name="";
	}
	
}
