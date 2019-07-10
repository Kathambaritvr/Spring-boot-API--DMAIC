package com.glabs.dmaic.dmaic_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glabs.dmaic.dmaic_app.DmaicRepository;


@RestController

public class DmaicController {
	
@Autowired
private DmaicRepository dmaicRepository;

@Autowired
//private UserRepository userRepository;


public DmaicRepository getRepository() 
{
	return dmaicRepository;
}
public void setRepository(DmaicRepository repository) {
	this.dmaicRepository = repository;
}

@GetMapping(value = "/dmaic")
public List<Dmaic> getAllDmaic() {
	return dmaicRepository.findAll();
}

@PostMapping("/dmaic")
Dmaic createOrSaveDmaic(@RequestBody Dmaic newDmaic) {
	return dmaicRepository.save(newDmaic);
}
 
@PutMapping("/dmaic/{id}")
Dmaic updateDmaic(@RequestBody Dmaic newDmaic, @PathVariable Long id) {
	 
    return dmaicRepository.findById(id).map(dmaic -> {
        dmaic.setDefine(newDmaic.getDefine());
        dmaic.setMeasure(newDmaic.getMeasure());
        dmaic.setAnalyse(newDmaic.getAnalyse());
        dmaic.setImplement(newDmaic.getImplement());
        dmaic.setControl(newDmaic.getControl());
        return dmaicRepository.save(dmaic);
    }).orElseGet(() -> {
        newDmaic.setId(id);
        return dmaicRepository.save(newDmaic);
    });
}

@DeleteMapping("/dmaic/{id}")
void deleteDmaic(@PathVariable Long id) {
	dmaicRepository.deleteById(id);
}
}