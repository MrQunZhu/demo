package com.example.demo.controller;

import com.example.demo.dao.UserESRepository;
import com.example.demo.entity.UserES;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lixq
 * @date: 2019-07-30
 * @描述:
 */
@RestController
public class UserController {
    @Autowired
    private UserESRepository userESRepository;

    @GetMapping("/create")
    @ApiOperation(value="创建人员", notes="es创建人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "long",paramType="query"),
            @ApiImplicitParam(name = "userName", value = "userName", required = true, dataType = "string",paramType="query"),
            @ApiImplicitParam(name = "userPhone", value = "userPhone", required = true, dataType = "string",paramType="query")
    })
    public String create(
            @RequestParam("id") Long id,
            @RequestParam("userName") String userName,
            @RequestParam("userPhone") String userPhone){
        UserES userES = new UserES();
        userES.setId(id);
        userES.setUserName(userName);
        userES.setUserPhone(userPhone);
        return userESRepository.save(userES).toString();
    }

    private String names;

    @GetMapping("/get")
    @ApiOperation(value="查询人员列表", notes="es检索人员")
    public String get() {
        names = "";
        Iterable<UserES> userES = userESRepository.findAll();
        userES.forEach(userES1 -> {
            names += userES1.toString() + "\n";
        });
        return names;
    }

    private String searchs = "";

    @GetMapping("/search")
    @ApiOperation(value="分页人员列表", notes="es分页检索人员")
    public String search(@RequestParam("searchKey") String searchKey) {
        searchs = "";
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("userName", searchKey));
        // 搜索，获取结果
        Page<UserES> items = userESRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        searchs += "总共数据数：" + total + "\n";
        items.forEach(userES -> {
            searchs += userES.toString() + "\n";
        });
        return searchs;
    }
}
