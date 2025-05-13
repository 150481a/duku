/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.duku.mall.framework.starter.database.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.duku.mall.framework.starter.distributedid.toolkit.SnowflakeIdUtil;
import org.duku.mall.framework.starter.user.core.UserContext;
import org.duku.mall.framework.starter.user.core.UserInfoDTO;

import java.util.Date;

/**
 * 元数据处理器
 */
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        UserInfoDTO authUser = UserContext.getCurrentUser();
        if (authUser != null) {
            this.setFieldValByName("createBy", authUser.getUsername(), metaObject);
        } else {

            this.setFieldValByName("createBy", "SYSTEM", metaObject);
        }
        //有创建时间字段，切字段值为空
        if (metaObject.hasGetter("createTime")) {
            this.setFieldValByName("createTime", new Date(), metaObject);
        }
        //有值，则写入
        if (metaObject.hasGetter("deleteFlag")) {
            if (metaObject.getValue("deleteFlag") == null) {
                this.setFieldValByName("deleteFlag", false, metaObject);
            }
        }
        if (metaObject.hasGetter("id")) {
            //如果已经配置id，则不再写入
            if (metaObject.getValue("id") == null) {
                this.setFieldValByName("id", String.valueOf(SnowflakeIdUtil.nextId()), metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        UserInfoDTO authUser = UserContext.getCurrentUser();
        if (authUser != null) {
            this.setFieldValByName("updateBy", authUser.getUsername(), metaObject);
        }
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
