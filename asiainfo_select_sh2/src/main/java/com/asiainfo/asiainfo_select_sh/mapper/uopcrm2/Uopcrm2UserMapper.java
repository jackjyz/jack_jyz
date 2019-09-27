package com.asiainfo.asiainfo_select_sh.mapper.uopcrm2;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Uopcrm2UserMapper {

    List<Map<String,Object>> findUserByMap(Map<String, Object> map);

}
