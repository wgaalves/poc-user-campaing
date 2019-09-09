package com.willalves.campaignservice.service;

import com.willalves.campaignservice.exception.RecordNotFoundException;
import com.willalves.campaignservice.model.Campaign;
import com.willalves.campaignservice.model.Vigency;
import com.willalves.campaignservice.repository.CampaignRepository;
import com.willalves.campaignservice.repository.TeamRepository;
import com.willalves.campaignservice.repository.VigencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CampaignService {

    private CampaignRepository campaignRepository;

    private VigencyRepository vigencyRepository;

    private SequenceGeneratorService sequenceGeneratorService;

    private TeamService teamService;

    public Campaign save(Campaign campaign){
        List<Vigency> vingencyList =
                vigencyRepository.findAllByInitGreaterThanEqualAndAndEndIsLessThanEqual(
                        campaign.getVigency().getInit(),
                        campaign.getVigency().getEnd());

        for (Vigency vingency:vingencyList) {
            vingency.setEnd(vingency.getEnd().plusDays(1));
            vigencyRepository.save(vingency);

            while (vingencyList.stream().anyMatch(o -> o.getEnd().equals(vingency.getEnd()))){
                Optional<Vigency> result =
                        vingencyList.stream().filter(o -> o.getEnd().equals(vingency.getEnd())).findFirst();
                result.ifPresent(updated -> {
                    updated.setEnd(updated.getEnd().plusDays(1));
                    vigencyRepository.save(updated);
                });

            }


        }
        campaign.setId(sequenceGeneratorService.generateSequence(Campaign.SEQUENCE_NAME));
        campaign.setTeam(teamService.findById(campaign.getTeam().getId()).get());

        return campaignRepository.save(campaign);

    }

    public Campaign update(Campaign campaign) {
        if(campaignRepository.existsById(campaign.getId())){
            return campaignRepository.save(campaign);
        }
        throw new RecordNotFoundException("Campanha não encontrada");
    }

    public Optional<Campaign> findById(Long id){
        if(campaignRepository.existsById(id)){
            return campaignRepository.findById(id);
        }
        throw new RecordNotFoundException("Campanha não encontrada");

    }

    public void delete(Long id){
        campaignRepository.deleteById(id);

    }
}
