package com.glabs.dmaic.dmaic_app;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DmaicRepository extends JpaRepository<Dmaic, Long> 
{
	
}
