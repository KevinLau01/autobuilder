<#assign   Entity="${class_name?cap_first}Entity"
            entity="${class_name}Entity"
            Dto="${class_name?cap_first}Dto"
            Mapper="${class_name?cap_first}Mapper"
            mapper="${class_name}Mapper"
            Service="${class_name?cap_first}Service"
            service="${class_name}Service"
            Controller="${sub_class_name?cap_first}Controller"
            controller="${sub_class_name}"
            tableId="${sub_class_name}Id"
            group_artfactId="${groupId}.${artifactId}"
            Class="${class_name?cap_first}"
            packagePath=package_path
            columns=table_column
            primaryKeys=primaryKeys
>

<#macro priname keys preffix>
    <#list keys as key> ${preffix}${key?cap_first} </#list>
</#macro>

<#--可使用的数据模型如下：-->
<#--package_path //包路径-->
<#--table_name  //数据库原始表名-->
<#--sub_class_name //去除前缀后的表名，驼峰-->
<#--class_name   //表名，驼峰-->
<#--isMappingTable //是否mapping表-->
<#--table_column //表中列的集合，List<Column.>-->
<#--hasDateColumn //是否有类型为Date的列-->
<#--poImportList  //？？-->
<#--artifactId    //工程名称-->
<#--groupId       //组名-->
<#--author        //作者-->
<#--sysDate       //生成时的系统时间-->
<#--template      //当前所使用模板信息，不包含模板内容，对应实体类TemplateMapping-->
<#--自定义函数：!!有问题无法使用，参数传递出错？？-->
<#--getPrimaryKey（columns） //获取表中所有主键字段，返回类型List<String>-->