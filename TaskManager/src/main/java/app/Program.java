package app;

import db.DBService;
import model.Task;
import model.TaskType;
import model.User;

public class Program {

	public static void main(String[] args) {
		
		DBService.deleteAllUsers();
		
		User utilizator = new User(1, "john@gmail.com", "1234");
		DBService.salveazaUser(utilizator);
		
		DBService.deleteSpecificUser(111);
		
		// DBService.afisareTaskuri();
		
		DBService.deleteTaskTypes();
		TaskType tt = new TaskType("shopping");
		DBService.saveTaskType(tt);
		
		DBService.afisareUseri();
		Task unTask = new Task();
		unTask.setCost(200.0);
		unTask.setDescriere("Cumpara apizza");
		unTask.setTitlu("Cumparaturi");
		unTask.setDurata(30);
		DBService.saveTask(unTask);
		System.out.println("END");
	}
	
}
