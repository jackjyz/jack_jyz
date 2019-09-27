package com.asiainfo.asiainfo_select_sh.mapper.uopcrm4;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Uopcrm4ShMapper {
    List<Map<String,Object>> findShByMap(Map<String, Object> map);
}
