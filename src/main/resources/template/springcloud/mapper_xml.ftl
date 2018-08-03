<#include "assignlib.ftl">
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${group_artfactId}.dao.${Mapper}">

    <sql id="Base_Column_List">
    <#list columns as c> ${c.name}<#sep >,</#list>
      <!-- id, loginId, password, status, org_id,school_id,email,name, deleted, createdtime, updatetime, createdUser, updateUser-->
    </sql>

    <select id="selectByPrimaryKey" parameterType="java.lang.Integer" resultType="${group_artfactId}.entity.${Entity}">
        select
        <include refid="Base_Column_List" />
        from ${tablename}
        where id = #{id,jdbcType=INTEGER}
    </select>

    <select id="selectByCondition" parameterType="${group_artfactId}.entity.${Entity}" resultType="${group_artfactId}.dto.SysUserDto">
        select
        <where>
            user.deleted = 0
            <if test="schoolId != null">
                and teacher.school_id = #{schoolId,jdbcType=INTEGER}
            </if>
            <if test="roleId != null">
                and userRole.rule_role_id = #{roleId,jdbcType=INTEGER}
            </if>
            <if test="loginId != null and loginId!= ''">
                and user.loginId = #{loginId,jdbcType=VARCHAR}
            </if>
            <if test="organizationId != null">
                and user.organization_id = #{organizationId,jdbcType=INTEGER}
            </if>
            <if test="status != null">
                and user.status = #{status,jdbcType=INTEGER}
            </if>
            <if test="email != null and name!= '' ">
                and user.email  like '%${email}%'
            </if>
            <if test="name != null and name!= '' ">
                and user.name  like '%${name}%'
            </if>
            <if test="id != null">
                and user.id = #{id,jdbcType=INTEGER}
            </if>
        </where>
    </select>

    <delete id="deleteByPrimaryKey" parameterType="java.lang.Integer">
        delete from sys_user where id = #{id,jdbcType=INTEGER}
    </delete>
    <insert id="insertSelective"  parameterType="com.magic.basicdata.dto.SysUserDto">
        <selectKey keyProperty="id" order="AFTER" resultType="java.lang.Integer">
            select LAST_INSERT_ID()
        </selectKey>
        insert into sys_user
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="id != null">
                id,
            </if>
            <if test="loginId != null">
                loginId,
            </if>
            <if test="password != null">
                password,
            </if>
            <if test="status != null">
                status,
            </if>
            <if test="orgId != null">
                org_id,
            </if>
            <if test="schoolId != null">
                school_id,
            </if>
            <if test="email != null">
                email,
            </if>
            <if test="name != null">
                name,
            </if>

            <if test="deleted != null">
                deleted,
            </if>
            <if test="createdtime != null">
                createdtime,
            </if>
            <if test="createdUser != null">
                createdUser,
            </if>
            <if test="updatetime != null">
                updatetime,
            </if>
            <if test="updateUser != null">
                updateUser,
            </if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <if test="id != null">
            #{id,jdbcType=INTEGER},
            </if>
            <if test="loginId != null">
            #{loginId,jdbcType=VARCHAR},
            </if>
            <if test="password != null">
            #{password,jdbcType=VARCHAR},
            </if>
            <if test="status != null">
            #{status,jdbcType=TINYINT},
            </if>
            <if test="orgId != null">
            #{orgId,jdbcType=INTEGER},
            </if>
            <if test="schoolId != null">
            #{schoolId,jdbcType=INTEGER},
            </if>
            <if test="email != null">
            #{email,jdbcType=VARCHAR},
            </if>
            <if test="name != null">
            #{name,jdbcType=VARCHAR},
            </if>

            <if test="deleted != null">
            #{deleted,jdbcType=TINYINT},
            </if>
            <if test="createdtime != null">
            #{createdtime,jdbcType=BIGINT},
            </if>
            <if test="createdUser != null">
            #{createdUser,jdbcType=VARCHAR},
            </if>
            <if test="updatetime != null">
            #{updatetime,jdbcType=BIGINT},
            </if>
            <if test="updateUser != null">
            #{updateUser,jdbcType=VARCHAR},
            </if>
        </trim>
    </insert>
    <update id="updateByPrimaryKeySelective" parameterType="com.magic.basicdata.dto.SysUserDto">
        update sys_user
        <set>
            <if test="loginId != null">
                loginId = #{loginId,jdbcType=VARCHAR},
            </if>
            <if test="password != null">
                password = #{password,jdbcType=VARCHAR},
            </if>
            <if test="status != null">
                status = #{status,jdbcType=TINYINT},
            </if>
            <if test="orgId != null">
                org_id = #{orgId,jdbcType=INTEGER},
            </if>
            <if test="schoolId != null">
                school_id = #{schoolId,jdbcType=INTEGER},
            </if>
            <if test="email != null">
                email = #{email,jdbcType=INTEGER},
            </if>
            <if test="name != null">
                name = #{name,jdbcType=INTEGER},
            </if>
            <if test="deleted != null">
                deleted = #{deleted,jdbcType=TINYINT},
            </if>
            <if test="updatetime != null">
                updatetime = #{updatetime,jdbcType=BIGINT},
            </if>
            <if test="updateUser != null">
                updateUser = #{updateUser,jdbcType=VARCHAR},
            </if>
        </set>
        where id = #{id,jdbcType=INTEGER}
    </update>
</mapper>