package app;

import db.DBService;
import model.Priority;

public class Program2 {

	public static void main(String[] args) {
		
		Priority pro = new Priority();
		pro.setPriorityName("semi_urgent");
		Priority pro2 = new Priority();
		pro2.setPriorityName("deloc_important");
		Priority pro3 = new Priority();
		pro3.setPriorityName("cacat");
		
		DBService.savePriority(pro);
		DBService.savePriority(pro2);
		DBService.savePriority(pro3);
		
		System.out.println("NUME: " + pro.getPriorityName());
//		System.out.println("ID: " + );
		System.out.println("END");
	}
	
}
