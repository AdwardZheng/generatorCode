export default class ${className} {

    public static getConfigName(): string {
        return "${className}";
    }

    constructor() {
    }
<#list fields as field>
    <#if (filed.comment)??>
     <#else>
    /**
     *  ${field.comment}
     */
    </#if>
    private ${field.name}: ${field.type};
</#list>

<#list fields as field>
    public get${field.name?cap_first}(): ${field.type} {
        return this.${field.name};
    }
    public set${field.name?cap_first}(${field.name}: ${field.type}) {
        this.${field.name} = ${field.name};
    }

</#list>

}