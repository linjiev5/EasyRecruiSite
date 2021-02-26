package jp.easyrecrui.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.easyrecrui.entity.EasyRecruiUserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<EasyRecruiUserInfo, Integer>{
	List<EasyRecruiUserInfo> findByUserid(String userid);
}
