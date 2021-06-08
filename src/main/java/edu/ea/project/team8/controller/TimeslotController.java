package edu.ea.project.team8.controller;

import edu.ea.project.team8.domain.Timeslot;
import edu.ea.project.team8.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    @GetMapping("/timeslots")
    public List<Timeslot> getAll(){
        return timeslotService.findAll();
    }

    @GetMapping("/timeslots/{id}")
    public Timeslot getById(@PathVariable("id") Integer id){
        return timeslotService.findById(id);
    }

    @PostMapping("/timeslots")
    public Timeslot addTimeslot(@RequestBody Timeslot timeslot){
        return timeslotService.addTimeSlot(timeslot);
    }

    @PutMapping("/timeslots")
    public Timeslot updateTimeslot(@RequestBody Timeslot timeslot){
        return timeslotService.updateTimeslot(timeslot);
    }

    @DeleteMapping("/timeslots/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        timeslotService.deleteTimeSlotById(id);
    }
}
