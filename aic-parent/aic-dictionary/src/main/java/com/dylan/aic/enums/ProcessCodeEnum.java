package com.dylan.aic.enums;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.dylan.aic.entity.ResultVO;
import com.dylan.aic.exception.ProcessException;
import com.dylan.aic.page.domain.PageList;

/**
 * 接口调用统一应答码（包括错误码）
 * @author Dylan
 *
 */
public enum ProcessCodeEnum {
	/**
	 * 全局应答码(resultVO返回给页面的信息)
	 */
	SUCCESS("0000", "成功"),
	FAIL("9999", "失败"),
	
	/**
	 * 数据库操作异常
	 */
	DATA_ERR("D999","系统数据处理异常"),
	
	/**
	 * 业务类异常
	 */
	PROCESS_ERR("P999","业务处理异常"),
	
	/**
	 * 参数校验
	 */
	PARAMETER_ERR("A999","参数异常"),
	
	/**
	 * 邮件发送异常
	 */
	MAIL_ERR("M999","邮件发送异常"),
	
	/**
	 * 内容管理类
	 */
	CMS_001("C001","广告信息不存在"),
	CMS_002("C002","轮播图信息不存在"),
	CMS_003("C003","友情链接信息不存在"),
	CMS_004("C004","公告|新闻|帮助信息不存在"),
	CMS_005("C005","区域服务定价信息不存在"),
	CMS_006("C006","学习中心帮助信息不存在"),
	
	/**
	 * 密码管理
	 */
	PWD_001("B001","手机号、密码、手机验证码不能为空"),
	PWD_002("B002","邮箱、验证码不能为空"),
	PWD_003("B003","邮箱尚未注册"),
	PWD_004("B004","短信验证码已失效或未获取"),
	PWD_005("B005","手机号码尚未注册"),
	PWD_006("B006","用户名不存在"),
	PWD_007("B007","短信验证码错误"),
	PWD_008("B008","图片验证码错误"),
	PWD_009("B009","图片验证码已失效或未生成"),
	PWD_010("B010","原始密码错误"),
	PWD_011("B011","原始密码与重置密码一致"),
	PWD_012("B012","手机号码注册异常，绑定多个账户"),
	PWD_013("B013","邮箱注册异常，绑定多个账户"),
	PWD_014("B014","密码重置链接非法或已失效"),
	
	/**
	 * 用户
	 */
	USR_001("U001","车童收藏信息不存在"),
	USR_002("U002","车童拉黑信息不存在"),
	USR_003("U003","用户信息不存在"),
	USR_004("U004","卖家信息不存在"),
	USR_005("U005","此车童已经收藏,不要重复收藏"),
	USR_006("U006","车童收藏状态异常，不能撤销收藏"),
	USR_007("U007","此车童未被收藏，不能撤销收藏"),
	USR_008("U008","当前用户未登录或登录失效"),
	USR_009("U008","用户名已存在"),
	USR_010("U010","用户未加盟服务"),
	
	/**
	 * 消息通知
	 */
	MSG_001("M001","消息、通知信息不存在"),
	
	/**
	 * 团队模块
	 */
	GRO_001("G001","用户ID不能为空"),
	GRO_002("G002","议价ID不能为空"),
	GRO_003("G003","管理费ID不能为空"),
	GRO_004("G004","更新管理费规则失败,无此规则"),
	GRO_005("G005","删除管理费规则失败,无此规则"),
	GRO_006("G006","查询团队出错"),
	GRO_007("G007","团队无此车童"),
	GRO_008("G008","机构或团队用户信息为空"),
	GRO_009("G009","脱离机构失败"),
	GRO_010("G010","脱离团队失败"),
	GRO_011("G010","未加入机构或者团队"),
	
	/**
	 * 订单
	 */
	FMO_001("F001", "存在未完成订单"),
	
	/**认证**/
	CER_001("X001","机构名已经提出申请或已经注册账号");
	
	
	
	//应答码
	private String code;
	
	//应答内容
	private String message;
	
	private ProcessCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	//构造处理异常信息
	public ProcessException buildProcessException() {
		return new ProcessException(code, message);
	}
	
	public ProcessException buildProcessException(String msgAppend) {
		return new ProcessException(code, message + " -> " + msgAppend);
	}
	
	public ProcessException buildProcessException(Throwable e) {
		return new ProcessException(code, message + " -> " + e.getMessage(), e);
	}
	
	public ProcessException buildProcessException(String msgAppend, Throwable e) {
		return new ProcessException(code, message + " -> " + msgAppend + " -> " + e.getMessage(), e);
	}
	
	@SafeVarargs
	@SuppressWarnings("unchecked")
	public final <T> void buildResultVO(ResultVO<T> resultVO, T... arg) {
		if(null == resultVO)
			throw PROCESS_ERR.buildProcessException("the target object is null");
		try {
			T result = ArrayUtils.isNotEmpty(arg) ? arg[0] : null;
			resultVO.setResultObject(result);
			resultVO.setResultCode(code);
			resultVO.setResultMsg(message);
			if(result instanceof PageList && null != result){
				resultVO.setPaginator(((PageList<T>)result).getPaginator());
			}
		} catch (Exception e) {
			throw PROCESS_ERR.buildProcessException(e);
		}
		
	}
	
	@SafeVarargs
	@SuppressWarnings("unchecked")
	public final <T> ResultVO<T> buildResultVOR(T... arg) {
		
		ResultVO<T> resultVO = new ResultVO<T>();
		
		try {
			T result = ArrayUtils.isNotEmpty(arg) ? arg[0] : null;
			resultVO.setResultObject(result);
			resultVO.setResultCode(code);
			resultVO.setResultMsg(message);
			if(result instanceof PageList && null != result){
				resultVO.setPaginator(((PageList<T>)result).getPaginator());
			}
		} catch (Exception e) {
			throw PROCESS_ERR.buildProcessException(e);
		}
		
		return resultVO;
		
	}
	
	//通过code获取message
	public static String getDescByCode(String code){
		if(StringUtils.isBlank(code))
			return null;
		for (ProcessCodeEnum processCodeEnum : ProcessCodeEnum.values()) {
			if(processCodeEnum.code.equalsIgnoreCase(code))
				return processCodeEnum.message;
		}
		return null;
	}
	
	//通过code获取enum
	public static ProcessCodeEnum getEnumByCode(String code){
		if(StringUtils.isBlank(code))
			return null;
		for (ProcessCodeEnum processCodeEnum : ProcessCodeEnum.values()) {
			if(processCodeEnum.code.equalsIgnoreCase(code))
				return processCodeEnum;
		}
		return null;
	}

}
