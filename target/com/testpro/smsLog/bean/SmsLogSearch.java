package com.testpro.smsLog.bean;




import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.PageModel;

/**
 * POJO Search:SmsLog
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings({ "rawtypes" })
@Alias("SmsLogSearch")
public class SmsLogSearch extends PageModel {
	
	private Integer	id;		
	private String	phone;		 /* 手机号 */ 
	private String	code;		 /* 验证码 */ 
	private Integer	sendtime;		 /* 发送时间，精确到毫秒 */ 
	private Integer	status;		 /* 验证码状态 0发送  1失效  2成功（用于注册和忘记密码） */ 
	private String	type;		 /* 验证码类型 templateRegister注册 templateResetPwd忘记密码 */ 

	// Constructor
	public SmsLogSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public SmsLogSearch(Integer id, String phone, String code, Integer sendtime, Integer status, String type) {
		this.id = id;
		this.phone = phone;
		this.code = code;
		this.sendtime = sendtime;
		this.status = status;
		this.type = type;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为SmsLog可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public SmsLogSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getPhone() {
		return phone;
	}

	public SmsLogSearch setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public String getCode() {
		return code;
	}

	public SmsLogSearch setCode(String code) {
		this.code = code;
		return this;
	}
	
	public Integer getSendtime() {
		return sendtime;
	}

	public SmsLogSearch setSendtime(Integer sendtime) {
		this.sendtime = sendtime;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public SmsLogSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public String getType() {
		return type;
	}

	public SmsLogSearch setType(String type) {
		this.type = type;
		return this;
	}
	
}