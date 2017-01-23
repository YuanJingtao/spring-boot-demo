package com.example;

import com.example.domain.dao.SeckillDao;
import com.example.domain.dto.Seckill;
import com.example.util.FastJsonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * IndexController
 *
 * @author YuanJingtao
 * @version 1.0
 * @date 2017-01-23 14:28
 */
@RestController
public class IndexController {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate2;

    @Autowired
    private SeckillDao seckillDao;

    @RequestMapping("/")
    public String index() {
        return "hello there";
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public String getSessionId(HttpServletRequest request) {
        System.out.print(request.getSession().getId());
        return request.getSession().getId();
    }

    @RequestMapping(value = "/jdbc", method = RequestMethod.GET)
    public String getJdbc(HttpServletRequest request){
//        List<Seckill> list = jdbcTemplate.queryForList("select * from seckill", Seckill.class);
//        return FastJsonTool.serialize(list);

        int count = jdbcTemplate.queryForObject("select count(1) from seckill", Integer.class);
        return count+"";
    }

    @RequestMapping(value = "/jdbc2", method = RequestMethod.GET)
    public String getJdbc2(HttpServletRequest request){
//        List<Seckill> list = jdbcTemplate.queryForList("select * from seckill", Seckill.class);
//        return FastJsonTool.serialize(list);

        int count = jdbcTemplate2.queryForObject("select count(1) from ai_admin_info", Integer.class);
        return count+"";
    }

    @RequestMapping(value = "/seckill", method = RequestMethod.GET)
    public String getSeckill(HttpServletRequest request){
//        List<Seckill> list = jdbcTemplate.queryForList("select * from seckill", Seckill.class);
//        return FastJsonTool.serialize(list);

        List<Seckill> list = seckillDao.queryAll(1,10);
        return FastJsonTool.serialize(list);
    }

}
