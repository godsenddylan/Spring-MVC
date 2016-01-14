package com.dylan.aic.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.dylan.aic.enums.ProcessCodeEnum;
import com.dylan.aic.exception.ProcessException;


/**
  * 对象序列化、反序列化
  * @author Dylan
  * @date 2016年1月14日
  *
  */
public class SerializeUtil {
	
	/**
	 * 对象序列化
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) throws ProcessException {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			if(null == object)
				return null;
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			throw ProcessCodeEnum.PROCESS_ERR.buildProcessException(e);
		}
	}

	/**
	 * 对象反序列化
	 * @param bytes
	 * @return
	 */
	public static Object unSerialize(byte[] bytes) throws ProcessException{
		ByteArrayInputStream bais = null;
		try {
			if(null == bytes)
				return null;
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			throw ProcessCodeEnum.PROCESS_ERR.buildProcessException(e);
		}
	}

}
