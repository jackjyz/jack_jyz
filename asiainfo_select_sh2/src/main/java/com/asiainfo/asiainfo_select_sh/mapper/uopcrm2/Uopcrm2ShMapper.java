package com.asiainfo.asiainfo_select_sh.mapper.uopcrm2;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Uopcrm2ShMapper {
    List<Map<String,Object>> findShByMap(Map<String, Object> map);
}
