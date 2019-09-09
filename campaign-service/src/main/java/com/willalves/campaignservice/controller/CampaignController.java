package com.willalves.campaignservice.controller;


import com.willalves.campaignservice.model.Campaign;
import com.willalves.campaignservice.service.CampaignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api")
@AllArgsConstructor
@Api(value = "Campaign" , description = "Campanhas")
@Controller
public class CampaignController {


    private CampaignService campaignService;

    @ApiOperation(value = "Get Campaign by Id")
    @RequestMapping(value = "/campaign/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<Optional<Campaign>> findCampaign(@Valid @PathVariable("id") Long id){
        Optional<Campaign> found = campaignService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(found);
    }


    @ApiOperation(value = "Create Campaign")
    @RequestMapping(value = "/campaign/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Campaign> saveProduct(@Valid @RequestBody Campaign values) {
        Campaign saved = campaignService.save(values);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @ApiOperation(value = "Update Campaign")
    @RequestMapping(value = "/campaign/",
            method = RequestMethod.PATCH,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Campaign> updateProduct(@Valid @RequestBody Campaign values) {
        Campaign saved = campaignService.update(values);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }


    @ApiOperation(value = "Delete Campaign")
    @RequestMapping(value = "/campaign/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        campaignService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }


}
