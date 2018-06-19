package net.javabeat.spring.data.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.javabeat.spring.data.domain.Canoe;
import net.javabeat.spring.data.service.CanoeService;

import java.util.List;


@RestController
@RequestMapping(value = "/canoe")
public class CanoesController {
	
	@Autowired
    CanoeService canoeService;

    @RequestMapping(value="", method=RequestMethod.POST)
    public Canoe createCanoe(@RequestBody Canoe canoe){
        return canoeService.createCanoe(canoe);
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Canoe> getAllCanoes(){
        return canoeService.getAllCanoes();
    }

    @RequestMapping(value="/{id}")
    public Canoe getCanoeById(@PathVariable int id){
        return canoeService.getCanoeById(id);
    }

    @RequestMapping(value="/findbystatus/{status}")
    public List<Canoe> findByStats(@PathVariable int status){
        return canoeService.getCanoeByStatus(status);
    }
    
    @RequestMapping(value="/findbysize/{size}")
    public List<Canoe> getCanoeBySize(@PathVariable String size){
        return canoeService.getCanoeBySize(size);
    }

    @RequestMapping(value="/{id}/uploadImage/{href}", method=RequestMethod.PUT)
    public void uploadCanoeImage(@PathVariable int id, @PathVariable String href){
         canoeService.uploadCanoeImage(id, href);
    }

    @RequestMapping(value="/{id}/updateStatus/{status}", method=RequestMethod.PUT)
    public void updateCanoe(@PathVariable int id, @PathVariable int status){
        canoeService.updateStatus(id, status);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteCanoe(@PathVariable int id){
        canoeService.deleteCanoe(id);
    }
}
