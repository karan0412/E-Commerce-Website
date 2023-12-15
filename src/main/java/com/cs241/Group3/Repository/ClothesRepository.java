package com.cs241.Group3.Repository;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cs241.Group3.SellClothes;
import com.cs241.Group3.User;


@Repository
public interface ClothesRepository extends JpaRepository<SellClothes, Long>{
	
	
	@Query(value = "select * from Clothes s where s.category like :category ", nativeQuery=true)
	List<SellClothes> findByKeyword(String category);
	public SellClothes findByClothId(Long id);
	@Query("delete from SellClothes b where b.clothId=:id")
	void deleteClothes(Long id);
}
