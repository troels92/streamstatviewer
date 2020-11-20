package com.ts.streamstatviewer.repository;

import com.ts.streamstatviewer.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface AlienRepo extends JpaRepository<Alien, Integer>
{
//can add more complex codes here, which the crud doesnt provide


}
