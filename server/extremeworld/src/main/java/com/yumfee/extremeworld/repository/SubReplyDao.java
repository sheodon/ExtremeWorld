package com.yumfee.extremeworld.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.yumfee.extremeworld.entity.SubReply;

public interface SubReplyDao extends PagingAndSortingRepository<SubReply, Long> {

	Page<SubReply> findByReplyId(Long id, Pageable pageRequest);
}
