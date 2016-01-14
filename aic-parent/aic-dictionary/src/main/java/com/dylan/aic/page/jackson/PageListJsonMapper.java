package com.dylan.aic.page.jackson;

import com.dylan.aic.page.domain.PageList;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;


/**
  * @author Dylan
  * @date 2016年1月14日
  *
  */
public class PageListJsonMapper extends ObjectMapper{

	private static final long serialVersionUID = -2406763029582741514L;

	public PageListJsonMapper() {
        SimpleModule module = new SimpleModule("PageListJSONModule", new Version(1, 0, 0, null, null, null));
        module.addSerializer(PageList.class, new PageListJsonSerializer(this));
        registerModule(module);
    }
}
