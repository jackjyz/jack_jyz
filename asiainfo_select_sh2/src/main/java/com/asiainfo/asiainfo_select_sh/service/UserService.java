package com.asiainfo.asiainfo_select_sh.service;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<Map<String,Object>> getUser(Map<String,Object> map);

    String findString (Map<String,Object> map);
}
