package lameater.db.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import lameater.db.meat.Meat;
import lameater.db.repository.MeatRepository;

@RestController    // This means that this class is a Controller
@RequestMapping(value="/meat") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired MeatRepository meatRepository;

    @GetMapping(value="/all")
    public List<Meat> getall(){
        return meatRepository.findAll();
    }

    @PostMapping(value="/load")
    public List<Meat> persist(@RequestBody final Meat meat){
        meatRepository.save(meat);
        return meatRepository.findAll();
    }

}