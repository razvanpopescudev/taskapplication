package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Priority;
import model.Task;
import model.TaskType;
import model.User;

public class DBService {

	public static Connection realizareConexiune() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // incarcare Driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager_taskuri", "root", "");
		} catch (Exception e) {
			System.out.println("OOPS");
			e.printStackTrace();
		}
		return con;
	}

	public static void afisareTaskuri() {
		Connection conexiune = realizareConexiune();
		String comanda = "SELECT * FROM tasks";

		try {
			Statement stmt = conexiune.createStatement();
			ResultSet rezultate = stmt.executeQuery(comanda);
			// System.out.println(rezultate.toString());
			while (rezultate.next()) { // merge rand cu rand
				System.out.println(rezultate.getInt("id") + " " + rezultate.getString("titlu") + " "
						+ rezultate.getString("descriere") + " " + rezultate.getDate("data_adaugare")); // luam
																										// coloana
			// TODO: preluare task-uri																				// cu
																										// colaoana
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// aceleasi operatii si pentru task-uri
	// deleteALlTasks
	// deleteSpecificTask(id)
	// saveTask
	public static void saveTask(Task t) {
		Connection con = realizareConexiune();
		String comanda = "INSERT INTO tasks(titlu, descriere, data_adaugare, data_terminare, durata, cost, tip, completata, prioritate) "
				+ "VALUES('" + t.getTitlu() + "', '" + t.getDescriere() + "', NULL, NULL, " + t.getDurata() + ", "
				+ t.getCost() + ", " + t.getTip() + ", NULL, " + t.getPrioritate() + ")";
		System.out.println("COMANDA: " + comanda);
	}

	public static List<User> afisareUseri() {
		Connection conexiune = realizareConexiune();
		List<User> utilizatori = new ArrayList<>();
		String command = "SELECT * FROM users";
		try {
			Statement stmt = conexiune.createStatement();
			ResultSet rezultate = stmt.executeQuery(command);
			while (rezultate.next()) {
				System.out.println(rezultate.getInt("id") + " " + rezultate.getString("email"));
				User u = new User();
				u.setEmail(rezultate.getString("email"));
				u.setId(rezultate.getInt("id"));
				u.setPassword(rezultate.getString("password"));
				utilizatori.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilizatori;
	}

	public static User afisareUserDupaID(int id) {
		Connection conexiune = realizareConexiune();
		String command = "SELECT * FROM users WHERE id = " + id;
		try {
			Statement stmt = conexiune.createStatement();
			ResultSet rezultate = stmt.executeQuery(command);
			while (rezultate.next()) {
				System.out.println(rezultate.getInt("id") + " " + rezultate.getString("email"));
				User u = new User();
				u.setEmail(rezultate.getString("email"));
				u.setId(rezultate.getInt("id"));
				u.setPassword(rezultate.getString("password"));
				u.setUserTasks(incarcaTaskuriPentruUser(id));
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Task> incarcaTaskuriPentruUser(int userId) {
		String query = "SELECT * FROM tasks WHERE user_id = " + userId;
		List<Task> taskuri = new ArrayList<>();

		Connection conexiune = realizareConexiune();
		try {
			Statement stmt = conexiune.createStatement();
			ResultSet rezultate = stmt.executeQuery(query);
			while (rezultate.next()) {
				Task task = new Task();
				task.setId(rezultate.getInt("id"));
				task.setTitlu(rezultate.getString("titlu"));
				task.setDescriere(rezultate.getString("descriere"));
				taskuri.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return taskuri;
	}

	public static void salveazaUser(User u) {

		String query = "INSERT INTO users(email, password) VALUES('" + u.getEmail() + "', '" + u.getPassword() + "')";
		System.out.println(query);

		Connection conexiune = realizareConexiune();
		try {
			Statement stmt = conexiune.createStatement();
			int rezultat = stmt.executeUpdate(query); // executeUpdate() ---
														// insert, delete,
														// update
			System.out.println("REZULTAT operatie executeUpdate = " + rezultat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateUser(User user) {
		String query = "UPDATE users SET password = '" + user.getPassword() + "', email = '" + user.getEmail()
				+ "' WHERE id = " + user.getId();
		Connection conexiune = realizareConexiune();
		try {
			Statement stmt = conexiune.createStatement();
			stmt.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteSpecificUser(int id) {
		String query = "DELETE FROM users WHERE id = " + id;
		Connection conexiune = realizareConexiune();
		try {
			Statement stmt = conexiune.createStatement();
			int rezultat = stmt.executeUpdate(query);
			System.out.println("Numar randuri afectate: " + rezultat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteSpecificUser(String email) {
		String query = "DELETE FROM users WHERE email = '" + email + "'";
		Connection conexiune = realizareConexiune();
		try {
			Statement stmt = conexiune.createStatement();
			int rezultat = stmt.executeUpdate(query);
			System.out.println("Numar randuri afectate: " + rezultat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteAllUsers() {
		String query = "DELETE FROM users";
		Connection conexiune = realizareConexiune();
		try {
			Statement stmt = conexiune.createStatement();
			int rezultat = stmt.executeUpdate(query);
			System.out.println("Numar randuri afectate: " + rezultat);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void saveTaskType(TaskType t) {
		Connection conn = realizareConexiune();
		String comanda = "INSERT INTO task_types(typename) VALUES('" + t.getTypeName() + "')";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(comanda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteTaskTypes() {
		Connection conn = realizareConexiune();
		String comanda = "Delete FROM task_types";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(comanda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteTaskTypeById(int id) {
		Connection conn = realizareConexiune();
		String comanda = "Delete FROM task_types WHERE id = " + id;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(comanda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO: metode pentru priority, tasktypes (afisare)
	//
	public static void savePriority(Priority p) {
		Connection conn = realizareConexiune();
		String comanda = "INSERT INTO priority(priority_name)VALUES ('" + p.getPriorityName() + "') ";

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(comanda);
		} catch (Exception e) {
			System.out.println("NU AM PUTUT INSERA, PROBABIL CA AI DEJA NUMELE RESPECTIV IN BD");
			e.printStackTrace();
		}
	}

	public static List<Priority> afisarePrioritati() {
		List<Priority> prioritatiDB = new ArrayList<>();
		String sql = "SELECT * from priority";
		Connection conn = realizareConexiune();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Priority proDB = new Priority();
				proDB.setId(rs.getInt("id"));
				proDB.setPriorityName(rs.getString("priority_name"));
				prioritatiDB.add(proDB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prioritatiDB;
	}

	public static void deletePriorities() {
		Connection con = realizareConexiune();
		String com = "Delete FROM priority";
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(com);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deletePriority(int id) {
		Connection con = realizareConexiune();
		String com = "Delete from priority WHERE id = " + id;
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(com);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Priority cautaPrioritateDupaId(int id) {
		Connection con = realizareConexiune();
		String comanda = "Select * FROM priority WHERE id = " + id;
		Priority prioritateGasita = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet cautare = stmt.executeQuery(comanda);
			while (cautare.next()) {
				// System.out.println("prioritatea cautata este " +
				// cautare.getInt("id") +" " + "si este o prioritate de tip" +"
				// "+ cautare.getString("priority_name"));
				prioritateGasita = new Priority();
				prioritateGasita.setId(cautare.getInt("id"));
				prioritateGasita.setPriorityName(cautare.getString("priority_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prioritateGasita;
	}

	public static void updatePriority(Priority pro) {
		String query = "UPDATE priority SET priority_name = '" + pro.getPriorityName() + "' WHERE id = " + pro.getId();
		System.out.println("QUERY ARATA ASA: " + query);
		Connection con = realizareConexiune();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Priority pr = cautaPrioritateDupaId(7);
		// System.out.println(pr.getPriorityName() + " este numele prioritatii
		// gasite in bd dupa id");
		// updatePriority(pr);

		List<Task> taskuriUser = incarcaTaskuriPentruUser(17);
		System.out.println("TASKURI GASITE: ");
		for(Task task : taskuriUser){
			System.out.println("\t\t" + task.getTitlu());
		}
		System.out.println("-------");
		User someUser = afisareUserDupaID(17);
		System.out.println("NUME USER: " + someUser.getEmail());
		System.out.println("TASKURILE LUI 17: " +  someUser.getUserTasks());
	}

}
