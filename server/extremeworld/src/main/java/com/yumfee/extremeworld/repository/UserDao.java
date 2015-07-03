package com.yumfee.extremeworld.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.yumfee.extremeworld.entity.User;


public interface UserDao extends PagingAndSortingRepository<User, Long>
{
	User findById(Long id);
	User findByLoginName(String loginName);
	User findByQqOpenId(String qqOpenId);
	
	Page<User> findByGeoHashLike(String geoHash, Pageable pageable);
}
