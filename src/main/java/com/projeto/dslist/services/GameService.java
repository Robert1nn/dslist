package com.projeto.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.dslist.DTO.GameDTO;
import com.projeto.dslist.DTO.GameMinDTO;
import com.projeto.dslist.entities.Game;
import com.projeto.dslist.projections.GameMinProjection;
import com.projeto.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findALL(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x ->new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x ->new GameMinDTO(x)).toList();
		return dto;
	}
}
