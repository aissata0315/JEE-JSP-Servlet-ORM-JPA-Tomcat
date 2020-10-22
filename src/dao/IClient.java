package dao;

import java.util.List;

import entities.Client;
import entities.Village;


public interface IClient {
	public int add(Client client);
	public Client getClient(int idClient);
	public Village getVillage(int idVillage);
	public List<Village> village();
	public List<Client> listeClient();

	
	

}
