package com.dc.jjjc.ws.exception;

public interface ExceptionConstant {

	public static final String LOCAL_CALL_EXCEPTION_CODE_001 = "LOCAL_CALL_EXCEPTION_001";
	public static final String LOCAL_CALL_EXCEPTION_001 = "本地客户端调用，传入的消息中包含业务对象名称为空的节点";
	public static final String LOCAL_CALL_EXCEPTION_CODE_002 = "LOCAL_CALL_EXCEPTION_002";
	public static final String LOCAL_CALL_EXCEPTION_002 = "本地客户端调用，传入的消息中包含业务对象属性名称为空的节点";
	public static final String LOCAL_CALL_EXCEPTION_CODE_003 = "LOCAL_CALL_EXCEPTION_003";
	public static final String LOCAL_CALL_EXCEPTION_003 = "本地客户端调用，传入的消息中包含数据组名称为空的节点";
	public static final String LOCAL_CALL_EXCEPTION_CODE_004 = "LOCAL_CALL_EXCEPTION_004";
	public static final String LOCAL_CALL_EXCEPTION_004 = "本地客户端调用，传入的消息中包含数据组属性名称为空的节点";
	public static final String LOCAL_CALL_EXCEPTION_CODE_005 = "LOCAL_CALL_EXCEPTION_005";
	public static final String LOCAL_CALL_EXCEPTION_005 = "本地客户端调用，传入的消息中包含数据项名称为空的节点";
	public static final String LOCAL_CALL_EXCEPTION_CODE_006 = "LOCAL_CALL_EXCEPTION_006";
	public static final String LOCAL_CALL_EXCEPTION_006 = "本地客户端调用，传入的消息中包含数据项属性名称为空的节点";
	public static final String LOCAL_CALL_EXCEPTION_CODE_007 = "LOCAL_CALL_EXCEPTION_007";
	public static final String LOCAL_CALL_EXCEPTION_007 = "本地客户端调用，远程服务无法正常访问";
	public static final String LOCAL_CALL_EXCEPTION_CODE_008 = "REMOTE_CALL_EXCEPTION_008";
	public static final String LOCAL_CALL_EXCEPTION_008 = "本地客户端调用，返回的消息报文不是一个标准的XML报文";
	public static final String LOCAL_CALL_EXCEPTION_CODE_009 = "REMOTE_CALL_EXCEPTION_009";
	public static final String LOCAL_CALL_EXCEPTION_009 = "本地客户端调用，返回的消息报文中缺少业务服务代码SERVICE_ID";
	public static final String LOCAL_CALL_EXCEPTION_CODE_010 = "REMOTE_CALL_EXCEPTION_010";
	public static final String LOCAL_CALL_EXCEPTION_010 = "本地客户端调用，返回的消息报文中缺少业务服务代码OPERATION";
	public static final String LOCAL_CALL_EXCEPTION_CODE_011 = "REMOTE_CALL_EXCEPTION_011";
	public static final String LOCAL_CALL_EXCEPTION_011 = "本地客户端调用，返回的消息报文中缺少业务服务代码systemCode";
	public static final String LOCAL_CALL_EXCEPTION_CODE_012 = "REMOTE_CALL_EXCEPTION_012";
	public static final String LOCAL_CALL_EXCEPTION_012 = "本地客户端调用，返回的消息报文中缺少业务服务代码TRAN_ID";

	public static final String REMOTE_CALL_EXCEPTION_CODE_001 = "REMOTE_CALL_EXCEPTION_001";
	public static final String REMOTE_CALL_EXCEPTION_001 = "远程客户端调用，传入的消息报文不是一个标准的XML报文";
	public static final String REMOTE_CALL_EXCEPTION_CODE_002 = "REMOTE_CALL_EXCEPTION_002";
	public static final String REMOTE_CALL_EXCEPTION_002 = "远程客户端调用，传入的消息报文中缺少业务服务代码SERVICE_ID";
	public static final String REMOTE_CALL_EXCEPTION_CODE_003 = "REMOTE_CALL_EXCEPTION_003";
	public static final String REMOTE_CALL_EXCEPTION_003 = "远程客户端调用，传入的消息报文中缺少业务服务代码OPERATION";
	public static final String REMOTE_CALL_EXCEPTION_CODE_004 = "REMOTE_CALL_EXCEPTION_004";
	public static final String REMOTE_CALL_EXCEPTION_004 = "远程客户端调用，传入的消息报文中缺少业务服务代码systemCode";
	public static final String REMOTE_CALL_EXCEPTION_CODE_005 = "REMOTE_CALL_EXCEPTION_005";
	public static final String REMOTE_CALL_EXCEPTION_005 = "远程客户端调用，传入的消息报文中缺少业务服务代码TRAN_ID";

	public static final String LOCAL_SERVER_EXCEPTION_CODE_001 = "LOCAL_SERVER_EXCEPTION_001";
	public static final String LOCAL_SERVER_EXCEPTION_001 = "本地服务器异常，无法获取服务Bean实例";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_002 = "LOCAL_SERVER_EXCEPTION_002";
	public static final String LOCAL_SERVER_EXCEPTION_002 = "本地服务器异常，获取数据库资源出错，请检查数据库配置";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_003 = "LOCAL_SERVER_EXCEPTION_003";
	public static final String LOCAL_SERVER_EXCEPTION_003 = "本地服务器异常，执行数据库操作出错，可能使用了错误的SQL语句或者参数";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_004 = "LOCAL_SERVER_EXCEPTION_004";
	public static final String LOCAL_SERVER_EXCEPTION_004 = "本地服务器异常，事务提交出错，可能事务不存在或者其他原因";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_005 = "LOCAL_SERVER_EXCEPTION_005";
	public static final String LOCAL_SERVER_EXCEPTION_005 = "本地服务器异常，事务回滚出错，可能事务已经提交或者其他原因";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_006 = "LOCAL_SERVER_EXCEPTION_006";
	public static final String LOCAL_SERVER_EXCEPTION_006 = "本地服务器异常，关闭数据库资源出错，可能该资源正在使用中或者已经销毁";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_007 = "LOCAL_SERVER_EXCEPTION_007";
	public static final String LOCAL_SERVER_EXCEPTION_007 = "本地服务器异常，传入的消息中包含业务对象名称为空的节点";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_008 = "LOCAL_SERVER_EXCEPTION_008";
	public static final String LOCAL_SERVER_EXCEPTION_008 = "本地服务器异常，传入的消息中包含业务对象属性名称为空的节点";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_009 = "LOCAL_SERVER_EXCEPTION_009";
	public static final String LOCAL_SERVER_EXCEPTION_009 = "本地服务器异常，传入的消息中包含数据组名称为空的节点";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_010 = "LOCAL_SERVER_EXCEPTION_010";
	public static final String LOCAL_SERVER_EXCEPTION_010 = "本地服务器异常，传入的消息中包含数据组属性名称为空的节点";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_011 = "LOCAL_SERVER_EXCEPTION_011";
	public static final String LOCAL_SERVER_EXCEPTION_011 = "本地服务器异常，传入的消息中包含数据项名称为空的节点";
	public static final String LOCAL_SERVER_EXCEPTION_CODE_012 = "LOCAL_SERVER_EXCEPTION_012";
	public static final String LOCAL_SERVER_EXCEPTION_012 = "本地服务器异常，传入的消息中包含数据项属性名称为空的节点";

}
