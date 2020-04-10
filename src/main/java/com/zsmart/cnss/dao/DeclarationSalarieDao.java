package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.TypeDeclarationSalarie;
import com.zsmart.cnss.bean.Affilie;
import com.zsmart.cnss.bean.DeclarationSalarie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface DeclarationSalarieDao extends JpaRepository<DeclarationSalarie,Long> {


	 public DeclarationSalarie findByTypeDeclarationSalarie(TypeDeclarationSalarie typeDeclarationSalarie);
	 public DeclarationSalarie findByAffilie(Affilie affilie);

	 public int deleteByTypeDeclarationSalarie(TypeDeclarationSalarie typeDeclarationSalarie);
	 public int deleteByAffilie(Affilie affilie);

}
