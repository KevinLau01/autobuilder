<#assign   Entity="${class_name}Entity"
            entity="${class_name?uncap_first}Entity"
            Dto="${class_name}Dto"
            Mapper="${class_name}Mapper"
            Service="${class_name}Service"
            service="${class_name?uncap_first}Service"
            mapper="${class_name?uncap_first}Mapper"
            Controller="${sub_table_name?cap_first}Controller"
            tableId="${sub_table_name}Id"
>

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