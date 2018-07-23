package com.testpro.smsLog.bean;



import org.apache.ibatis.type.Alias;
import com.testpro.common.beans.BaseEntity;

/**
 * POJO:SmsLog
 * 
 * @author lubo
 * @date 2018-7-23
 */
@SuppressWarnings("serial")
@Alias("SmsLog")
public class SmsLog extends BaseEntity {
	
	
	private String	phone;		 /* 手机号 */ 
	private String	code;		 /* 验证码 */ 
	private Integer	sendtime;		 /* 发送时间，精确到毫秒 */ 
	private Integer	status;		 /* 验证码状态 0发送  1失效  2成功（用于注册和忘记密码） */ 
	private String	type;		 /* 验证码类型 templateRegister注册 templateResetPwd忘记密码 */ 

	// Constructor
	public SmsLog() {
	}
	
	/**
	 * full Constructor
	 */
	public SmsLog(Integer id, String phone, String code, Integer sendtime, Integer status, String type) {
		setId(id);
		this.phone = phone;
		this.code = code;
		this.sendtime = sendtime;
		this.status = status;
		this.type = type;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为SmsLog可以实现连缀设置属性
	
	public String getPhone() {
		return phone;
	}

	public SmsLog setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	
	public String getCode() {
		return code;
	}

	public SmsLog setCode(String code) {
		this.code = code;
		return this;
	}
	
	
	public Integer getSendtime() {
		return sendtime;
	}

	public SmsLog setSendtime(Integer sendtime) {
		this.sendtime = sendtime;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public SmsLog setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	
	public String getType() {
		return type;
	}

	public SmsLog setType(String type) {
		this.type = type;
		return this;
	}
	
	@Override
	public String toString() {
		return "SmsLog [" + "id=" + getId() + ", phone=" + phone + ", code=" + code + ", sendtime=" + sendtime + ", status=" + status + ", type=" + type +  "]";
	}
}
