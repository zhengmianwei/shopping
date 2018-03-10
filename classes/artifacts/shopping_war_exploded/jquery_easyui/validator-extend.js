$.extend($.fn.validatebox.defaults.rules, { 
    minLength : { // �ж���С���� 
        validator : function(value, param) { 
            value = $.trim(value);	//ȥ�ո� 
            return value.length >= param[0]; 
        }, 
        message : '�������� {0} ���ַ���' 
    }, 
    length:{validator:function(value,param){ 
        var len=$.trim(value).length; 
            return len>=param[0]&&len<=param[1]; 
        }, 
            message:"�������ݳ��ȱ������{0}��{1}֮��." 
        }, 
    phone : {// ��֤�绰���� 
        validator : function(value) { 
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value); 
        }, 
        message : '��ʽ����ȷ,��ʹ�������ʽ:020-88888888' 
    }, 
    mobile : {// ��֤�ֻ����� 
        validator : function(value) { 
            return /^(13|15|18)\d{9}$/i.test(value); 
        }, 
        message : '�ֻ������ʽ����ȷ' 
    }, 
    idcard : {// ��֤���֤ 
        validator : function(value) { 
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value); 
        }, 
        message : '���֤�����ʽ����ȷ' 
    }, 
    intOrFloat : {// ��֤������С�� 
        validator : function(value) { 
            return /^\d+(\.\d+)?$/i.test(value); 
        }, 
        message : '���������֣���ȷ����ʽ��ȷ' 
    }, 
    currency : {// ��֤���� 
        validator : function(value) { 
            return /^\d+(\.\d+)?$/i.test(value); 
        }, 
        message : '���Ҹ�ʽ����ȷ' 
    }, 
    qq : {// ��֤QQ,��10000��ʼ 
        validator : function(value) { 
            return /^[1-9]\d{4,9}$/i.test(value); 
        }, 
        message : 'QQ�����ʽ����ȷ' 
    }, 
    integer : {// ��֤���� 
        validator : function(value) { 
            return /^[+]?[1-9]+\d*$/i.test(value); 
        }, 
        message : '����������' 
    }, 
    chinese : {// ��֤���� 
        validator : function(value) { 
            return /^[\u0391-\uFFE5]+$/i.test(value); 
        }, 
        message : '����������' 
    }, 
    english : {// ��֤Ӣ�� 
        validator : function(value) { 
            return /^[A-Za-z]+$/i.test(value); 
        }, 
        message : '������Ӣ��' 
    }, 
    unnormal : {// ��֤�Ƿ�����ո�ͷǷ��ַ� 
        validator : function(value) { 
            return /.+/i.test(value); 
        }, 
        message : '����ֵ����Ϊ�պͰ��������Ƿ��ַ�' 
    }, 
    username : {// ��֤�û��� 
        validator : function(value) { 
            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value); 
        }, 
        message : '�û������Ϸ�����ĸ��ͷ������6-16�ֽڣ�������ĸ�����»��ߣ�' 
    }, 
    faxno : {// ��֤���� 
        validator : function(value) { 
//            return /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/i.test(value); 
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value); 
        }, 
        message : '������벻��ȷ' 
    }, 
    zip : {// ��֤�������� 
        validator : function(value) { 
            return /^[1-9]\d{5}$/i.test(value); 
        }, 
        message : '���������ʽ����ȷ' 
    }, 
    ip : {// ��֤IP��ַ 
        validator : function(value) { 
            return /d+.d+.d+.d+/i.test(value); 
        }, 
        message : 'IP��ַ��ʽ����ȷ' 
    }, 
    name : {// ��֤���������������Ļ�Ӣ�� 
            validator : function(value) { 
                return /^[\u0391-\uFFE5]+$/i.test(value)|/^\w+[\w\s]+\w+$/i.test(value); 
            }, 
            message : '����������' 
    }, 
    carNo:{ 
        validator : function(value){ 
            return /^[\u4E00-\u9FA5][\da-zA-Z]{6}$/.test(value); 
        }, 
        message : '���ƺ�����Ч��������J12350��' 
    }, 
    carenergin:{ 
        validator : function(value){ 
            return /^[a-zA-Z0-9]{16}$/.test(value); 
        }, 
        message : '�������ͺ���Ч(����FG6H012345654584)' 
    }, 
    email:{ 
        validator : function(value){ 
        return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value); 
    }, 
    message : '��������Ч�ĵ����ʼ��˺�(����abc@126.com)'    
    }, 
    msn:{ 
        validator : function(value){ 
        return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value); 
    }, 
    message : '��������Ч��msn�˺�(����abc@hotnail(msn/live).com)' 
    },same:{ 
        validator : function(value, param){ 
            if($("#"+param[0]).val() != "" && value != ""){ 
                return $("#"+param[0]).val() == value; 
            }else{ 
                return true; 
            } 
        }, 
        message : '������������벻һ�£�'    
    } 
}); 