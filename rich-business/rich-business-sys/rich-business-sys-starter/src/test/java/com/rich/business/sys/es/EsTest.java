package com.rich.business.sys.es;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.cluster.ClusterHealth;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xepxe
 * @date 2022/9/15 17:03
 * @desc
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class EsTest {
    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Test
    public void t1() throws InterruptedException {
        ClusterHealth health = elasticsearchOperations.cluster().health();
        log.info("{}", JSON.toJSONString(health));
        Thread.sleep(10000);
    }
}
