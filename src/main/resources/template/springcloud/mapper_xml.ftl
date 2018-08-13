<#include "assignlib.ftl">
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${group_artfactId}.dao.${Mapper}">

    <!--/ * @author ${author}    * @date ${sysDate?date}  */-->

    <sql id="Base_Column_List">
    <#list columns as c> ${c.name}<#sep >,</#list>
      <!-- id, loginId, password, status, org_id,school_id,email,name, deleted, createdtime, updatetime, createdUser, updateUser-->
    </sql>

    <#if (! isMappingTable)>
    <select id="selectByPrimaryKey"  resultType="${group_artfactId}.entity.${Entity}">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        where <#list primaryKeys as PrimaryKey>${PrimaryKey.name} = ${r"#"}{${PrimaryKey.nameJ}}<#sep >and</#list>
        <#if hasDeleted(columns)> and deleted=0 </#if>
    </select>
    </#if>



    <select id="selectByCondition" parameterType="${group_artfactId}.entity.${Entity}" resultType="${group_artfactId}.entity.${Entity}">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        <where>
        <#list columns as c >
            <#if c.name="deleted">
             deleted=0
             <#elseif c.type!="String">
            <if test="${c.nameJ} != null ">
                and ${c.name} = ${r"#"}{${c.nameJ}}
            </if>
             <#else >
            <if test="${c.nameJ} != null and ${c.nameJ}!=''">
                and ${c.name} like '% ${r"$"}{${c.nameJ}} %'
            </if>
            </#if>
        </#list>
        </where>
    </select>

    <#if (!isMappingTable)>
    <delete id="deleteByPrimaryKey">
        delete from ${tableName} where <#list primaryKeys as PrimaryKey>${PrimaryKey.name} = ${r"#"}{${PrimaryKey.nameJ}}<#sep >and</#list>
    </delete>
    <#else>
     <delete id="deleteByPrimaryKey" parameterType="${group_artfactId}.entity.${Entity}">
         delete from ${tableName}
         <where>
        <#list columns as c >
            <#if c.type!="String">
            <if test="${c.nameJ} != null ">
                and ${c.name} = ${r"#"}{${c.nameJ}}
            </if>
            <#else >
            <if test="${c.nameJ} != null and ${c.nameJ}!=''">
                and ${c.name} like '% ${r"$"}{${c.nameJ}} %'
            </if>
            </#if>
        </#list>
         </where>
     </delete>
    </#if>

    <insert id="insertSelective"  parameterType="${group_artfactId}.entity.${Entity}"
    useGeneratedKeys="true" keyProperty="id">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list columns as c >
            <if test="${c.nameJ} != null <#if c.type="String"> and ${c.nameJ} != ''</#if>">
                ${c.name} ,
            </if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list columns as c >
            <if test="${c.nameJ} != null <#if c.type="String"> and ${c.nameJ} != ''</#if>">
                ${r"#"}{${c.nameJ}},
            </if>
            </#list>
        </trim>
    </insert>

    <#if (! isMappingTable)>
    <update id="updateByPrimaryKeySelective" parameterType="${group_artfactId}.entity.${Entity}">
        update ${tableName}
        <set>
        <#list columns as c >
        <if test="${c.nameJ} != null <#if c.type="String"> and ${c.nameJ} != ''</#if>">
            ${c.name} =${r"#"}{${c.nameJ}},
        </if>
        </#list>
        </set>
        where <#list primaryKeys as PrimaryKey>${PrimaryKey.name} = ${r"#"}{${PrimaryKey.nameJ}}<#sep >and</#list>
    </update>
    </#if>
</mapper>