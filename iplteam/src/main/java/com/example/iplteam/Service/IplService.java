package com.example.iplteam.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.iplteam.domain.players;

import java.util.List;

import com.example.iplteam.Repository.IplTeamRepository;
 
@Service
public class IplService{
@Autowired
    private IplTeamRepository repo;
public List<players> listAll() {
        return repo.findAll();
    }
    
    public void save(players player) {
        repo.save(player);
    }
    
    public players get(int id) {
        return repo.findById(id).get();
    }
    
    public void delete(int id) {
        repo.deleteById(id);
    }
 
}
