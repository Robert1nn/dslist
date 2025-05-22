package com.projeto.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.dslist.DTO.GameListDTO;
import com.projeto.dslist.DTO.GameMinDTO;
import com.projeto.dslist.services.GameListService;
import com.projeto.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findALL() {
		List<GameListDTO> result = gameListService.findALL();
		return result;
	}

	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findAByList(listId);
		return result;
	}
	
}
