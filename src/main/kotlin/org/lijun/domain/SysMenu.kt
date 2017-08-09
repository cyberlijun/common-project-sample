/*
 * Copyright 2006-2017 the original author or authors.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lijun.domain

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.*
import org.lijun.common.domain.BaseEntity
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Entity - SysMenu
 *
 * @author lijun
 * @constructor
 */
@Entity
@Table(name = "tb_sys_menu")
@DynamicInsert
@DynamicUpdate
class SysMenu : BaseEntity() {

    @JsonProperty
    var menuName: String? = null

    @JsonProperty
    var menuUrl: String? = null

    @JsonProperty
    var iconCls: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    var parent: SysMenu? = null

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @Fetch(FetchMode.SUBSELECT)
    var childMenus: List<SysMenu>? = null

}