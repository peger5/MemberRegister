package Model;

import java.util.LinkedList;
import Model.Boat.Type;

/*
 * Model class representing a member from the yacht club
 */
public class Member {

	private String name;
	private String personalNumber;
	private int memberNumber;
	private final int startNumber = 10000; 
	private LinkedList<Boat> boats = new LinkedList<Boat>();

	public Member(String a_name, String a_personalNumber, RegisterList a_list) {

		this.name = a_name;
		this.personalNumber = a_personalNumber;
		this.memberNumber = startNumber + a_list.getCount();

	}

	public void editName(String m_name) {
		this.name = m_name;
	}

	public void editPersonalNumber(String m_number) {
		this.personalNumber = m_number;
	}

	public String getName() {
		return name;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public int getBoatsNumber() {
		return boats.size();
	}

	public void addBoat(Type m_type, double m_lenght) {
		Boat b = new Boat(m_type, m_lenght);
		this.boats.add(b);
	}

	public String getBoatListStr(){
		StringBuilder buff = new StringBuilder();
		for (int i = 0; i < getBoatList().size(); i++) {
			buff.append(getBoatList().get(i).getBoatType());
			buff.append(",");
			buff.append(getBoatList().get(i).getBoatLength());
			buff.append(",");
			
		}
		buff.deleteCharAt(buff.length()-1);
		return buff.toString();
	}

	public void deleteBoat(int i) {
		boats.remove(i);
	}
	
	public Boat getBoat(int i){
		return boats.get(i);
	}
	
	public LinkedList<Boat> getBoatList(){
		return boats;
	}
	
	public void setMemberNumber(int num){
		memberNumber = num;
	}
}
