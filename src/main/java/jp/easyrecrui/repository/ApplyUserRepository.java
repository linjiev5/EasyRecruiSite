package jp.easyrecrui.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.easyrecrui.entity.EasyRecruiApplyUser;

@Repository
public interface ApplyUserRepository extends JpaRepository<EasyRecruiApplyUser, Integer>{
	List<EasyRecruiApplyUser> findByUserId(String userId);
}
