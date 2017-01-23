package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    private JdbcTemplate jdbcTemplate;

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

}
