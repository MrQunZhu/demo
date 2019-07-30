package com.example.demo.dao;

import com.example.demo.entity.UserES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: lixq
 * @date: 2019-07-30
 * @描述:
 */
public interface UserESRepository extends ElasticsearchRepository<UserES,Long> {

}
