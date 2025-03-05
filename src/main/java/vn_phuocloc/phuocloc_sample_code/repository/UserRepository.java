package vn_phuocloc.phuocloc_sample_code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn_phuocloc.phuocloc_sample_code.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    
}
