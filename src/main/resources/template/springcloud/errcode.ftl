package ${packagePath};


public class ErrCode {

	public final static String SUCCESS="0";
	//系统错误
	public final static String INSERT_ERROR="00002";
	public final static String UPDATE_ERROR="00003";
	public final static String DELETE_ERROR="00004";
	//USER
	public final static String USER_NOT_EXIST="";
	public final static String PWD_ERROR="";
	public final static String LOGINID_ALREADY_EXISTS="200001";
	//SMS
	public final static String SEND_ERROR=""; //发送失败
	public final static String TRY_AGAIN_LATER=""; //操作过于频繁，请稍后再试
	public final static String AUTHENTICATION_INVAILD="";//验证码无效

	//STU_LOGIN
	public final static String REGISTRATION_FAIL="";//注册失败

}