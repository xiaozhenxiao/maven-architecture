package com.hanyun.platform.member.api.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hanyun.platform.member.api.domain.Orders;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * ━━━━━━神兽出没━━━━━━
 * �??�?��┓�?�??┏┓
 * �??┏┛┻━━━┛┻┓\n * �??┃�?�??�??�??┃\n * �??┃�?�??━�?�??┃\n * �??┃�?┳┛�?��┳�?┃\n * �??┃�?�??�??�??┃\n * �??┃�?�??┻�?�??┃\n * �??┃�?�??�??�??┃\n * �??┗━┓�?�??┏━┛\n * �??�??┃�?�??┃神兽保�? 永无BUG!
 * �??�??┃�?�??┃Code is far away from bug with the animal protecting
 * �??�??┃�?�??┗━━━┓\n * �??�??┃�?�??�??�??┣┓
 * �??�??┃�?�??�??�??┏┛
 * �??�??┗┓┓┏━┳┓┏┛\n * �??�??�?��┫┫�?��┫┫
 * �??�??�?��┻┛�?��┻┛
 * ━━━━━━感觉萌萌哒━━━━━━\n * </pre>
 */
@Repository
public interface OrdersDao {

    public int deleteByPrimaryKey(Long id);

    public int insert(Orders record);

    public int insertSelective(Orders record);

    public Orders selectByPrimaryKey(Long id);
    
    List<Orders> selectByUserId(@Param("userId") String userId,@Param("brandId")String brandId,
			@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
    
    Long selectUserCount(@Param("userId") String userId,@Param("brandId")String brandId);
    
    List<Map<String, Object>> selectStatistics(String brandId);
    
    Long selectConsumTimes(@Param("brandId") String brandId,
			@Param("userId") String userId, @Param("startTime") Date startTime,
			@Param("endTime") Date endTime);

	Long selectBrandConsumTimes(@Param("brandId") String brandId,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime);

	Long selectConsumSum(@Param("brandId") String brandId,
			@Param("userId") String userId, @Param("startTime") Date startTime,
			@Param("endTime") Date endTime);

	Long selectBrandConsumSum(@Param("brandId") String brandId,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    public int updateByPrimaryKeySelective(Orders record);

    public int updateByPrimaryKey(Orders record);
}