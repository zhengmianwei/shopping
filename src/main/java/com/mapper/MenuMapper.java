package com.mapper;

import java.math.BigDecimal;
import java.util.Map;

public interface MenuMapper {
	public Map<String, BigDecimal> findMenuTotalByPid(String menuId);
}
