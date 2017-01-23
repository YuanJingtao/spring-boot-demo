package com.example.domain.dao;

import com.example.domain.dto.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * SeckillDao
 *
 * @author YuanJingtao
 * @version 1.0
 * @date 2016-08-30 10:05
 */
public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId  秒杀商品id
     * @param killTime   减库存时间
     * @return  如果影响行数>1 表示更新的记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据主键查询库存
     * @param seckillId  秒杀商品id
     * @return           返回秒杀商品实体对象
     */
    Seckill queryById(long seckillId);

    /**
     * 分页查询,根据偏移量查询商品列表
     * @param offset  分页偏移量
     * @param limit   分页每页大小
     * @return        返回秒杀商品实体对象列表
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     * @param paramMap 返回存储过程执行结果
     */
    void killByProcedure(Map<String, Object> paramMap);
}
