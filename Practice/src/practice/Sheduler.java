package practice;

import java.awt.List;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

class TimeSlot{
	
	int start;
	int end;
	
	public TimeSlot(int a,int b){
		start = a;
		end = b;
	}	
}

public class Sheduler{
	
	
	@SuppressWarnings({ "unchecked", "null" })
	public static ArrayList getTimeSlot(String Name,ArrayList prefTime,ArrayList<ArrayList> currentMeetings, int duration) {
		
		int prefStart = (int) prefTime.get(0);
		int PrefEnd = (int) prefTime.get(1);
		
		
		
		@SuppressWarnings("rawtypes")
		ArrayList set1;
		ArrayList set2;
		
		ArrayList result = new ArrayList<>();
		
		
		System.out.println(Name+",  Available time slots");
		for(int i=0;i<currentMeetings.size();i++) {
			
			set1 = currentMeetings.get(i);
			if(i+1 != currentMeetings.size()) {
				set2 = currentMeetings.get(i+1);
			}else {
				break;
			}
			
			
			int start = (int) set1.get(1);
			int end = (int) set2.get(0);
			
			
			
			if(end - start >= duration &&  prefStart <= start && PrefEnd >= end) {
	
				addToList(start,end,result);

				
				System.out.print("["+start+","+end+"]");

				
				if(i+2 == currentMeetings.size()) {
					
							
						int val1 = (int) set2.get(1);
						int val2 = (int) prefTime.get(1);
						
						if(val2 > val1) {
							
							if(val2 - val1 > duration) {
								
								int count = 1;
								
								int hold = val1;
								
								for(int k=0 ; ;k++) {
		
									addToList(val1,(val1+duration),result);
									System.out.print("  ["+val1+","+(val1+duration)+"]  ");
									
									val1 += duration;
									
									if(val1+duration > val2) {
										if(count == duration) {
											break;
										}else {
											val1 = hold+1;
											hold = val1;
											count+=1;
											continue;
										}
										
									}
		
								}
								
							}else if(val2-val1==duration){
								
								addToList(val1,val2,result);
								System.out.print("   ["+val1+","+(val2)+"]   ");
								
							}
								
							
						}
						
						System.out.println("");
						
						System.out.println("");
				
				return result;
					
			}
		}
			
		}


		return result;
		
	}
	
	public static void addToList(int a,int b,ArrayList<TimeSlot> slot){
		TimeSlot t = new TimeSlot(a,b);
		slot.add(t);
	}
	
	
	public static ArrayList<TimeSlot> isTimeSlotFree(ArrayList<ArrayList<TimeSlot>> usersList,int duration) {
		
		ArrayList<TimeSlot> slotList = new ArrayList<TimeSlot>();

		
		for(int i=0;i<usersList.size();i++) {
			
			ArrayList<TimeSlot> top = usersList.get(i);
			
			for(int j=0 ; j<usersList.size()&& i!=j ; j++) {
				
				ArrayList<TimeSlot> bot = usersList.get(j);
				
				for(TimeSlot s1: top) {
					for(TimeSlot s2: bot) {
						if(s1.start == s2.start && s1.end == s2.end) {
							slotList.add(s2);
						}
					}
					
				}
			}
			
		}
		
		System.out.println("Available time slots for all users to meet");
		
		for(int i=0; i< slotList.size();i++) {
			
			
			System.out.print("["+slotList.get(i).start+","+slotList.get(i).end+"]");
			
		}
		
		
		return null;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		
		
		ArrayList<ArrayList<TimeSlot>> finallist = new ArrayList<ArrayList<TimeSlot>>();
		ArrayList<ArrayList> currentMeetings = new ArrayList<>();
		
		int duration = 2;
		
		ArrayList pref = new ArrayList<>();
		
		pref.add(9);
		pref.add(18);
		
		ArrayList temp = new ArrayList<>();
		ArrayList temp1 = new ArrayList<>();
		ArrayList temp2 = new ArrayList<>();
		
		temp.add(10);
		temp.add(18);
		
		
		
		currentMeetings.add(temp);
		
		
		temp1.add(13);
		temp1.add(14);
		
		currentMeetings.add(temp1);
		
		temp2.add(16);
		temp2.add(18);
		
		currentMeetings.add(temp2);
		

		ArrayList result = new ArrayList<>();
		

		
		result =	getTimeSlot("suneel",pref,currentMeetings,duration);
		
		finallist.add(result);
		currentMeetings.clear();
		temp.clear();
		temp1.clear();
		temp2.clear();
		
		pref.clear();
		
		pref.add(8);
		pref.add(18);
		
		temp.add(8);
		temp.add(9);
		temp1.add(11);
		temp1.add(14);
		
		currentMeetings.clear();
		
		currentMeetings.add(temp);
		currentMeetings.add(temp1);
		
		
		result =	getTimeSlot("reddy",pref,currentMeetings,duration);
		
		finallist.add(result);
		
		isTimeSlotFree(finallist, duration);
		
		//System.out.println(finallist);
	
		
	}

}
