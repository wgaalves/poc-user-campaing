package com.willalves.campaignservice.service;


import com.willalves.campaignservice.exception.RecordNotFoundException;
import com.willalves.campaignservice.model.Team;
import com.willalves.campaignservice.repository.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log
@AllArgsConstructor
@Service
public class TeamService {

    private TeamRepository teamRepository;

    private SequenceGeneratorService sequenceGeneratorService;

    public Team save(Team team) throws Exception {
        if(!teamRepository.existsByTeam(team.getTeam())){
            team.setId(sequenceGeneratorService.generateSequence(Team.SEQUENCE_NAME));
            return teamRepository.save(team);
        }

        throw new Exception("Time já consta em nossa base de dados");
    }

    public Team update(Team team) {
        if(teamRepository.existsById(team.getId())){
            return teamRepository.save(team);
        }
        throw new RecordNotFoundException("Time não encontrado");
    }

    public Optional<Team> findById(Long id){
        if(teamRepository.existsById(id)){
            return teamRepository.findById(id);
        }
        throw new RecordNotFoundException("Time não encontrado");

    }

    public void delete(Long id){
        teamRepository.deleteById(id);

    }
}
