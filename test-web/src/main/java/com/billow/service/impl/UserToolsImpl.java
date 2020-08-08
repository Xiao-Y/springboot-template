package com.billow.service.impl;

import com.billow.mybatis.tools.UserTools;
import org.springframework.stereotype.Service;

@Service
public class UserToolsImpl implements UserTools {

    @Override
    public String getCurrentUserCode() {
        return "system";
    }
}
