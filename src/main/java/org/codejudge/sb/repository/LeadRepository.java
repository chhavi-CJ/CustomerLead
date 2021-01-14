package org.codejudge.sb.repository;

import org.codejudge.sb.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository  extends JpaRepository<Lead, Integer>{

	Lead findById(Integer lead_id);

	//Status findStatusByid(Integer id);
	/*
	 * @Query("select c.email from customerLead c where c.id=:id") String
	 * findEmailById(@Param("id") Integer id);
	 * 
	 * @Modifying
	 * 
	 * @Query("update User u set u.firstname = ?1 where u.lastname = ?2") int
	 * setFixedFirstnameFor(String firstname, String lastname);
	
		@Query("select u.email from CustomerLead u where u.id = ?1")
		  String findEmailById(Integer id);

		Object findById(Integer lead_id);
	
	
	 * @Query("SELECT r.name FROM RuleVo r where r.id = :id") String
	 * findNameById(@Param("id") Long id);
	 * 
	 * public String findemailbyid(Integer id);
	 *  @Query("SELECT r.name FROM RuleVo r where r.id = :id") 
    String findNameById(@Param("id") Long id);
	 */
}
