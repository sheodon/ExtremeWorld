package com.yumfee.extremeworld.service.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yumfee.extremeworld.entity.biz.Goods;
import com.yumfee.extremeworld.repository.biz.GoodsDao;

//Spring Bean的标识.
@Component
//类中所有public函数都纳入事务管理的标识.
@Transactional
public class GoodsService {

	@Autowired
	GoodsDao goodsDao;
	
	public Page<Goods> getAll(int pageNumber, int pageSize,String sortType){
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		return goodsDao.findAll(pageRequest);
	}
	
	public Page<Goods> getByShoopId(long shopId, int pageNumber, int pageSize,String sortType){
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		return goodsDao.findByShopId(shopId,pageRequest);
	}
	
	public Page<Goods> getByCategoryId(Long categoryId, int pageNumber, int pageSize, String sortType){
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		return goodsDao.findByCategoryId(categoryId, pageRequest);
	}
	
	public Goods save(Goods goods){
		return goodsDao.save(goods);
	}
	
	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "weight");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}else if("id".equals(sortType)){
			sort = new Sort(Direction.DESC, "id");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}
}
