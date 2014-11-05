package Model;

import java.util.LinkedList;

/*
 * Main model class containing the members. Based on a LinkedList
 */
public class RegisterList {

	private LinkedList<Member> list = new LinkedList<Member>();
	private int size=0;

	public void add(Member m) {
		list.add(m);
		size++;
	}
	
	public int size(){
		return list.size(); 
	}
	
	public Member get(int i){
		return list.get(i);
	}
	
	public void remove(int i){
		list.remove(i);
		
	}
	
	public LinkedList<Member> getList(){
		return list;
	}
	
	public int getCount(){
		return size;
	}
	
}
