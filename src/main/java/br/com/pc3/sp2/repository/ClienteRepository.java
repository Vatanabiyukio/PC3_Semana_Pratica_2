package br.com.pc3.sp2.repository;

import br.com.pc3.sp2.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, String> {

}
