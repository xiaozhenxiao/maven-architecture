package com.hanyun.platform.member.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.hanyun.platform.member.api.domain.BrandMemberType;

@Repository
public interface BrandMemberTypeDao {

    void insert(BrandMemberType record);

    void insertSelective(BrandMemberType record);

    BrandMemberType selectById(Long id);
    
    List<BrandMemberType> selectByBrandId(String brandId);

    int updateByIdSelective(BrandMemberType record);
    
    Long selectCount();
}