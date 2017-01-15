package app;

import java.util.List;

import db.DBService;
import model.Priority;

public class Program4 {

	public static void main(String[] args) {
		
		List<Priority> prios = DBService.afisarePrioritati();
		for(Priority p : prios){
			System.out.println(p.getPriorityName() + " " + p.getId());
		}
		
	}
	
}
