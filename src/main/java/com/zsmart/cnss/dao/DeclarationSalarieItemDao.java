package com.zsmart.cnss.dao;
import com.zsmart.cnss.bean.Salarie;
import com.zsmart.cnss.bean.DeclarationSalarie;
import com.zsmart.cnss.bean.DeclarationSalarieItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface DeclarationSalarieItemDao extends JpaRepository<DeclarationSalarieItem,Long> {


	 public DeclarationSalarieItem findBySalarie(Salarie salarie);
	 public DeclarationSalarieItem findByDeclarationSalarie(DeclarationSalarie declarationSalarie);

	 public int deleteBySalarie(Salarie salarie);
	 public int deleteByDeclarationSalarie(DeclarationSalarie declarationSalarie);

}
