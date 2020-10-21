package test;

import dao.IRole;
import dao.IUser;
import dao.RoleImpl;
import dao.Userimpl;
import entities.Role;
import entities.User;

public class Test {

	public static void main(String[] args) {
		IRole roledao = new RoleImpl();
		Role r = new Role();
		r.setPoste("directeur");
		System.out.println(roledao.add(r));
		
		IUser userdao = new Userimpl();
		User u = new User();
		u.setNom("Sagna");
		u.setPrenom("Judith");
		u.setEmail("judith@simplon.co");
		u.setPassword("erty");
		System.out.println(userdao.add(u));
	}
	

}
