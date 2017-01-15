package app;

import db.DBService;
import model.Priority;

public class Program5 {

	public static void main(String[] args) {
		Priority pr = DBService.cautaPrioritateDupaId(4);
		Priority pr2 = DBService.cautaPrioritateDupaId(7);
		Priority pr3 = DBService.cautaPrioritateDupaId(1);
		
		System.out.println(pr.getId());
		System.out.println(pr2.getId());
		System.out.println(pr3.getId());
		
		System.out.println(pr.getPriorityName());
		System.out.println(pr2.getPriorityName());
		System.out.println(pr3.getPriorityName());
		
		pr.setPriorityName("putin_important");
		DBService.updatePriority(pr);

	}

}
