package lameater.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lameater.db.meat.Meat;
import lameater.db.repository.MeatRepository;

public class MeatDAO {

	@Autowired MeatRepository meatRepository;
	
	public List<Meat> getAll(){
		return meatRepository.findAll();
	}
	
	public Meat getPlayerById(int playerid){
		return meatRepository.getOne(playerid);
	}
	
	public void deleteMeat(int id){
		meatRepository.deleteById(id);
	}
	
	public Meat savePlayer(Meat carne) {
		return meatRepository.save(carne);
	}
}
