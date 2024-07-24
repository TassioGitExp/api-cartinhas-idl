package dev.costa.tassio.cartasidl.controller;

import dev.costa.tassio.cartasidl.model.entities.dto.response.WeekResponse;
import dev.costa.tassio.cartasidl.model.service.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/week")
public class WeekController {
    @Autowired
    private final WeekService weekService;

    public WeekController(WeekService weekService){
        this.weekService = weekService;
    }

    @GetMapping("/get/{weekId}")
    public WeekResponse getWeekById(@PathVariable Long weekId){
        return this.weekService.getWeekById(weekId);
    }

    @GetMapping("/get-all")
    public List<WeekResponse> getAllWeeks(){
        return this.weekService.getAllWeeks();
    }
}
