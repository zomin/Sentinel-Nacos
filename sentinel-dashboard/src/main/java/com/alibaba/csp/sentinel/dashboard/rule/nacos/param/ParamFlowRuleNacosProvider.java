package com.alibaba.csp.sentinel.dashboard.rule.nacos.param;

import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Sentinel-1.8.1 - com.alibaba.csp.sentinel.dashboard.rule.nacos.authority
 * <p>
 * Created AuthorityRuleNacosProvider by zhan005 on 2021/6/8.
 *
 * @author zhan005
 * @date 2021/6/8 10:39
 * @description
 */
@Component("paramFlowRuleNacosProvider")
public class ParamFlowRuleNacosProvider implements DynamicRuleProvider<List<ParamFlowRuleEntity>> {
    @Autowired
    private ConfigService configService;
    @Override
    public List<ParamFlowRuleEntity> getRules(String appName) throws Exception {
        return NacosConfigUtil.getRuleEntitiesFromNacos(
            this.configService,
            appName,
            NacosConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX,
            ParamFlowRuleEntity.class);
    }
}
