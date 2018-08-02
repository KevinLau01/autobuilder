<#include "assignlib.ftl">
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${groupId}.${artifactId}.dao.${Mapper}">
    <resultMap id="BaseResultMap" type="${groupId}.${artifactId}.entity.${Entity}">
        <#list table_column as c>
         <<#if c.nameJ=="id">id<#else >result</#if>  column="${c.nameJ}" jdbcType="${c.jdbcType}" property="id" />
        </#list>

        <id column="id" jdbcType="INTEGER" property="id" />
        <result column="loginId" jdbcType="VARCHAR" property="loginId" />
        <result column="password" jdbcType="VARCHAR" property="password" />
        <result column="status" jdbcType="TINYINT" property="status" />
        <result column="org_id" jdbcType="INTEGER" property="orgId" />
        <result column="school_id" jdbcType="INTEGER" property="schoolId" />
        <result column="email" jdbcType="VARCHAR" property="email" />
        <result column="name" jdbcType="VARCHAR" property="name" />

        <result column="deleted" jdbcType="TINYINT" property="deleted" />
        <result column="createdtime" jdbcType="BIGINT" property="createdtime" />
        <result column="updatetime" jdbcType="BIGINT" property="updatetime" />
        <result column="createdUser" jdbcType="VARCHAR" property="createdUser" />
        <result column="updateUser" jdbcType="VARCHAR" property="updateUser" />
    </resultMap>
    <sql id="Base_Column_List">
        id, loginId, password, status, org_id,school_id,email,name, deleted, createdtime, updatetime, createdUser, updateUser
    </sql>
    <select id="selectByCondition" parameterType="com.magic.basicdata.entity.SysUserEntity" resultType="com.magic.basicdata.dto.SysUserDto">
        select
        user.id as id,
        user.loginId as loginId,
        user.password as password,
        user.status as status,
        user.org_id as orgId,
        user.school_id as schoolId,
        user.email as email,
        user.name as name,
        user.deleted as deleted,
        user.createdtime as createdtime,
        user.updatetime as updatetime,

        org.name as orgName,
        role.id as roleId,
        role.name as roleName,
        role.code as roleCode
        from sys_user user
        left join sys_organization org on org.id = user.org_id
        left join sys_user_role userRole on userRole.user_id = user.id
        left join sys_role      role     on role.id = userRole.role_id
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
    <select id="selectByLoginId" parameterType="com.magic.basicdata.entity.SysUserEntity" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from sys_user
        where loginId = #{loginId,jdbcType=VARCHAR}
    </select>
    <select id="selectByPrimaryKey" parameterType="java.lang.Integer" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from sys_user where id = #{id,jdbcType=INTEGER}
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