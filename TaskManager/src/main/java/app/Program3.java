package app;

import db.DBService;
import model.Priority;

public class Program3 {

	public static void main(String[] args) {
		
		Priority pro = new Priority();
		pro.setPriorityName("lol2");
		DBService.savePriority(pro);
		System.out.println("Prioritatea salvata: NUME: " + pro.getPriorityName() + " ID: " + pro.getId());
		
	}
	
}
