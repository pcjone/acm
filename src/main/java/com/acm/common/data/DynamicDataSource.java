package com.acm.common.data;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 
* @ClassName: DynamicDataSource 
* @Description: 重写determineCurrentLookupKey方法
* @author panlei 446756738@qq.com
* @date 2017年6月29日 下午5:01:49 
*
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// 从自定义的位置获取数据源标识
		return DynamicDataSourceHolder.getDataSource();
	}

}
