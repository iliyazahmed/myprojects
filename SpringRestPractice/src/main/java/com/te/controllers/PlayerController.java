package com.te.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.dtolayer.PlayerInfo;
import com.te.dtolayer.PlayerInfoResponse;
import com.te.servicelayer.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping(path = "/addplayer", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public PlayerInfoResponse addPlayerController(@RequestBody PlayerInfo info) {
		PlayerInfoResponse infoResponse = new PlayerInfoResponse();
		if (playerService.addServicePlayer(info)) {
			infoResponse.setStatusCode(200);
			infoResponse.setMessage("Succesfull");
			infoResponse.setDescription("Player : " + info.getPlayerName() + " is added successfully !!!!!");
			infoResponse.setPlayerInfo(info);
		} else {
			infoResponse.setStatusCode(400);
			infoResponse.setMessage("Failed..");
			infoResponse.setDescription("Player : " + info.getPlayerName() + " is failed to add data plz try again...");
		}
		return infoResponse;
	}
	
	@PutMapping(path="/updateplayer",produces= {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public PlayerInfoResponse updatedPlayerController(@RequestBody PlayerInfo info) {
		PlayerInfoResponse infoResponse = new PlayerInfoResponse();
		if(playerService.updateServicePlayer(info)) {
			infoResponse.setStatusCode(200);
			infoResponse.setMessage("Sucessfull");
			infoResponse.setDescription("Player with jersey number "+info.getJerseryNo()+" is updated successfully");
			infoResponse.setPlayerInfo(info);

		}
		
		else {
			infoResponse.setStatusCode(400);
			infoResponse.setMessage("Unsuccesfull");
			infoResponse.setDescription("Player with jersery number "+info.getJerseryNo()+" is not updated succesfully");
			infoResponse.setPlayerInfo(info);
		}
		
		
		return infoResponse;
	}
	
	@GetMapping(path="/findplayer/{jerseyNumber}",produces= {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public PlayerInfoResponse findPlayerController(@PathVariable("jerseyNumber") int  jerseyNumber) {
		PlayerInfoResponse infoResponse = new PlayerInfoResponse();
		PlayerInfo  playerInfo = playerService.getServicePlayer(jerseyNumber);
		if(playerInfo!=null) {
			infoResponse.setStatusCode(400);
			infoResponse.setMessage("SuccessFull");
			infoResponse.setDescription("Player with jersey number "+playerInfo.getJerseryNo()+"and player "+playerInfo.getPlayerName()+" is shown");
			infoResponse.setPlayerInfo(playerInfo);
		}
		else {
			infoResponse.setStatusCode(400);
			infoResponse.setMessage("Unsuccesfull");
			infoResponse.setDescription("Player with jersery number is unable to find");
		}
		
		return infoResponse;
		
	}
	
	
	@DeleteMapping(path="/deleteplayer/{jerseyNumber}",produces= {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public PlayerInfoResponse deletePlayerController(@PathVariable("jerseyNumber") int jerseyNumber) {
		PlayerInfoResponse infoResponse = new PlayerInfoResponse();
		PlayerInfo  playerInfo = playerService.getServicePlayer(jerseyNumber);
		if(playerService.deleteServicePlayer(jerseyNumber)) {
			infoResponse.setStatusCode(200);
			infoResponse.setMessage("Deleted Successfully");
			infoResponse.setDescription("Player with jersey number "+jerseyNumber+" is deleted successfully");
			infoResponse.setPlayerInfo(playerInfo);
		}
		else {
			infoResponse.setStatusCode(400);
			infoResponse.setMessage("Failed to delete");
			infoResponse.setDescription("Player with jersey number"+jerseyNumber+" is not deleted try again");
			infoResponse.setPlayerInfo(playerInfo);
		}
		
		return infoResponse;
		
	}
}
