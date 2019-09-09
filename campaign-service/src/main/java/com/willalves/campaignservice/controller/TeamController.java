package com.willalves.campaignservice.controller;

import com.willalves.campaignservice.model.Team;
import com.willalves.campaignservice.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Log
@RequestMapping("/api")
@AllArgsConstructor
@Api(value = "Team" , description = "Times")
@Controller
public class TeamController {

    private TeamService teamService;

    @ApiOperation(value = "Get Team by Id")
    @RequestMapping(value = "/team/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<Optional<Team>> findCampaign(@Valid @PathVariable("id") Long id) {
        Optional<Team> found = teamService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(found);
    }


    @ApiOperation(value = "Create Team")
    @RequestMapping(value = "/team/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Team> saveProduct(@Valid @RequestBody Team values) throws Exception {
        log.info(values.toString());
        Team saved = teamService.save(values);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @ApiOperation(value = "Update Team")
    @RequestMapping(value = "/team/",
            method = RequestMethod.PATCH,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Team> updateProduct(@Valid @RequestBody Team values) {
        Team saved = teamService.update(values);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }


    @ApiOperation(value = "Delete Team")
    @RequestMapping(value = "/team/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        teamService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

}