package com.example.iplteam.Repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.example.iplteam.domain.players;
 

@Repository
public interface IplTeamRepository extends JpaRepository<players, Integer> {
 
}
