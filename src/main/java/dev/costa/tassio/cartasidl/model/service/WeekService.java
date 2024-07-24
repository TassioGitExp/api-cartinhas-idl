package dev.costa.tassio.cartasidl.model.service;

import dev.costa.tassio.cartasidl.model.entities.Week;
import dev.costa.tassio.cartasidl.model.entities.dto.response.WeekResponse;
import dev.costa.tassio.cartasidl.model.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeekService {

    @Autowired
    private final WeekRepository weekRepository;

    public WeekService(WeekRepository weekRepository){
        this.weekRepository = weekRepository;
    }

    public WeekResponse getWeekById(Long id){
        if (weekRepository.findById(id).isEmpty()){
            throw new RuntimeException("Week not found!");
        }

        final var week = weekRepository.findById(id).get();

        return new WeekResponse().responseOf(week);
    }

    public List<WeekResponse> getAllWeeks(){
        final var weekList = weekRepository.findAll();

        List<WeekResponse> weekResponseList = new ArrayList<>();

        for (Week week : weekList) {
            var weekResponse = new WeekResponse().responseOf(week);

            weekResponseList.add(weekResponse);
        }

        return weekResponseList;
    }
}
