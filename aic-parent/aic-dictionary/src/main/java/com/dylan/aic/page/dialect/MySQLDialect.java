package com.dylan.aic.page.dialect;

import org.apache.ibatis.mapping.MappedStatement;

import com.dylan.aic.page.domain.PageBounds;


/**
  * mysql分页实现
  * @author Dylan
  * @date 2016年1月14日
  *
  */
public class MySQLDialect extends Dialect{

    public MySQLDialect(MappedStatement mappedStatement, Object parameterObject, PageBounds pageBounds) {
        super(mappedStatement, parameterObject, pageBounds);
    }
    
	protected String getLimitString(String sql, String offsetName,int offset, String limitName, int limit) {
        StringBuffer buffer = new StringBuffer( sql.length()+20 ).append(sql);
        if (offset > 0) {
            buffer.append(" limit ?, ?");
            setPageParameter(offsetName, offset, Integer.class);
            setPageParameter(limitName, limit, Integer.class);
        } else {
            buffer.append(" limit ?");
            setPageParameter(limitName, limit, Integer.class);
        }
        return buffer.toString();
	}   
  
}
