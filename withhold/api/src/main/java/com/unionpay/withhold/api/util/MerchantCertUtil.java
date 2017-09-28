package com.unionpay.withhold.api.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.unionpay.withhold.api.bean.DownloadRequest;
import com.unionpay.withhold.api.bean.DownloadResponse;
import com.unionpay.withhold.api.bean.DwnReqRoot;
import com.unionpay.withhold.api.bean.DwnRspRoot;
import com.unionpay.withhold.api.bean.MerchantRequest;
import com.unionpay.withhold.api.bean.MerchantResponse;
import com.unionpay.withhold.api.bean.QReqRoot;
import com.unionpay.withhold.api.bean.QRspRoot;
import com.unionpay.withhold.api.bean.QueryRequest;
import com.unionpay.withhold.api.bean.QueryResponse;
import com.unionpay.withhold.api.bean.ReqRoot;
import com.unionpay.withhold.api.bean.RspRoot;
import com.unionpay.withhold.api.bean.TRspRoot;
import com.unionpay.withhold.api.bean.ThreadResponse;
import com.unionpay.withhold.api.exception.AbstractBusiException;
import com.unionpay.withhold.api.exception.TransFlowException;
import com.unionpay.withhold.api.helper.MechantCertCacheHelper;
import com.unionpay.withhold.api.helper.PlateformCertCacheHelper;
import com.unionpay.withhold.api.helper.PlateformCertInfo;
import com.unionpay.withhold.api.signaturn.util.SecureUtil;


/**
 * 平台商户密钥处理工具类
 * 
 * @author Luke
 *
 */
public class MerchantCertUtil {
	private static final Logger logger = LoggerFactory.getLogger(MerchantCertUtil.class);
	/**
	 * 验证签名
	 *
	 * @param resData 验签源数据
	 * @param signature 签名数据
	 * @param certPath 证书路径
	 * @param encoding 编码
	 * @return
	 */
	public static boolean validate(MerchantRequest merchantRequest, String mchntKeyPath) throws AbstractBusiException {
		try {
			ReqRoot root = merchantRequest.getRoot();
			String signature = merchantRequest.getSignature().trim();
			
			String certId = root.getCertId();
			String encoding = merchantRequest.getRoot().getEncoding();
			String xmlString = XMLUtils.convertToXmlWithoutHead(root);
			
			return validateSignature(signature, xmlString, mchntKeyPath, encoding, certId);
		} 
		catch (AbstractBusiException e) {
			throw e;
		}
		catch (Exception e) {
			logger.error("validate signature failure! ", e);
		}
		return false;
	}

	/**
	 * 验证签名
	 *
	 * @param resData
	 *            验签源数据
	 * @param signature
	 *            签名数据
	 * @param certPath
	 *            证书路径
	 * @param encoding
	 *            编码
	 * @return
	 */
	public static boolean validateQuery(QueryRequest merchantRequest, String mchntKeyPath) throws AbstractBusiException {
		try {
			QReqRoot root = merchantRequest.getRoot();
			String signature = merchantRequest.getSignature().trim();
			
			String certId = root.getCertId();
			String encoding = merchantRequest.getRoot().getEncoding();
			String xmlString = XMLUtils.convertToXmlWithoutHead(root);
			
			return validateSignature(signature, xmlString, mchntKeyPath, encoding, certId);
		} 
		catch (AbstractBusiException e) {
			throw e;
		}
		catch (Exception e) {
			logger.error("validate signature failure! ", e);
		}
		return false;
	}

	/**
	 * 添加signature到应答报文
	 *
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static void addSignature(MerchantResponse response,String path ,String pwd) throws AbstractBusiException {
		RspRoot root = response.getRoot();
		PlateformCertCacheHelper certHelper =(PlateformCertCacheHelper)ApplicationContextUtil.getBeanByClass(PlateformCertCacheHelper.class);
		PlateformCertInfo plateformCertInfo =null;
		String signature = null;
		try {
			plateformCertInfo=certHelper.getPlatFormCertInfo(path, pwd);
			String xmlString = XMLUtils.convertToXmlWithoutHead(root);
			signature = makeSignature(xmlString, root.getEncoding(),plateformCertInfo);
		} 
		catch(TransFlowException e) {
			throw e;
		}
		catch (AbstractBusiException e) {
			logger.error("生成返回签名数据失败" , e.getCause());
		}
		catch (Exception e) {
			logger.error("生成返回签名数据失败" , e);
		}
		root.setCertId(plateformCertInfo.getCertId());
		response.setSignature(signature);
	}

	/**
	 * 添加signature到应答报文
	 *
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static void addSignatureQuery(QueryResponse response,String certPath,String dkPrivateKeyPwd) throws AbstractBusiException {
		QRspRoot root = response.getRoot();
		PlateformCertCacheHelper certHelper =(PlateformCertCacheHelper)ApplicationContextUtil.getBeanByClass(PlateformCertCacheHelper.class);
		PlateformCertInfo plateformCertInfo =null;
		String signature = null;
		try {
			plateformCertInfo=certHelper.getPlatFormCertInfo(certPath, dkPrivateKeyPwd);
			String xmlString = XMLUtils.convertToXmlWithoutHead(root);
			signature = makeSignature(xmlString, root.getEncoding(),plateformCertInfo);
		} 
		catch(TransFlowException e) {
			throw e;
		}
		catch (AbstractBusiException e) {
			logger.error("生成返回签名数据失败" , e.getCause());
		}
		catch (Exception e) {
			logger.error("生成返回签名数据失败" , e);
		}
		root.setCertId(plateformCertInfo.getCertId());
		response.setSignature(signature);
	}
	
	/**
	 * 添加signature到应答报文
	 *
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static void addSignatureDown(DownloadResponse response,String certPath,String dkPrivateKeyPwd) throws AbstractBusiException {
		DwnRspRoot root = response.getRoot();
		PlateformCertCacheHelper certHelper =(PlateformCertCacheHelper)ApplicationContextUtil.getBeanByClass(PlateformCertCacheHelper.class);
		PlateformCertInfo plateformCertInfo =null;
		String signature = null;
		try {
			plateformCertInfo=certHelper.getPlatFormCertInfo(certPath, dkPrivateKeyPwd);
			String xmlString = XMLUtils.convertToXmlWithoutHead(root);
			signature = makeSignature(xmlString, root.getEncoding(),plateformCertInfo);
		} 
		catch(TransFlowException e) {
			throw e;
		}
		catch (AbstractBusiException e) {
			logger.error("生成返回签名数据失败" , e.getCause());
		}
		catch (Exception e) {
			logger.error("生成返回签名数据失败" , e);
		}
		root.setCertId(plateformCertInfo.getCertId());
		response.setSignature(signature);
	}
	
	
	

	/**
	 * 添加signature到应答报文
	 *
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static void addSignature(ThreadResponse response,String path,String pwd) throws AbstractBusiException {
		TRspRoot root = response.getRoot();
		PlateformCertCacheHelper certHelper =(PlateformCertCacheHelper)ApplicationContextUtil.getBeanByClass(PlateformCertCacheHelper.class);
		PlateformCertInfo plateformCertInfo =null;
		String signature=null;
		try {
			plateformCertInfo=certHelper.getPlatFormCertInfo(path, pwd);
			String xmlString = XMLUtils.convertToXmlWithoutHead(root);
			signature = makeSignature(xmlString, root.getEncoding(),plateformCertInfo);
		} 
		catch(TransFlowException e) {
			throw e;
		}
		catch (AbstractBusiException e) {
			logger.error("生成返回签名数据失败" , e.getCause());
		}
		catch (Exception e) {
			logger.error("生成返回签名数据失败" , e);
		}
		root.setCertId(plateformCertInfo.getCertId());
		response.setSignature(signature);
	}
	
	/**
	 * 使用平台私钥生成签名数据
	 * 
	 * @param data 待签名数据
	 * @param encoding
	 * @return
	 * @throws AbstractBusiException
	 */
	private static String makeSignature(String data, String encoding,PlateformCertInfo plateformCertInfo) throws AbstractBusiException {
		try {
			PrivateKey privateKey = plateformCertInfo.getPrivateKey();
			X509Certificate cert = plateformCertInfo.getCertificate();
			
			Signature signAlg = Signature.getInstance(cert.getSigAlgName());
			signAlg.initSign(privateKey);
			
			data = data.replaceAll("[\\r\\n\\t]", "").replaceAll(" ", "");
			byte[] lastData = convertByte(data, "sha1X16", encoding);
			
			signAlg.update(lastData);
			byte[] signatureByte = signAlg.sign();
			return new String(SecureUtil.base64Encode(signatureByte));
		}
		catch(Exception e) {
			throw new AbstractBusiException(e);
		}
	} 
	
	/**
	 * 根据商户公钥验证上送的签名数据是否一致
	 * 
	 * @param signature
	 * @param data
	 * @param mchntKeyPath
	 * @param encoding
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	private static boolean validateSignature(String signature, String data, String mchntKeyPath, String encoding, String verifyCertId) throws AbstractBusiException {
		try {

			X509Certificate pubCert =((MechantCertCacheHelper)ApplicationContextUtil.getBeanByClass(MechantCertCacheHelper.class)).getCertByFileName(mchntKeyPath);
			
			if(verifyCertId != null && !verifyCertId.equals(pubCert.getSerialNumber().toString())) {
				throw new TransFlowException("0038", "商户请求报文证书id不正确");
			}
			Signature verify = Signature.getInstance(pubCert.getSigAlgName());
			verify.initVerify(pubCert.getPublicKey());
			
			data = data.replaceAll("[\\r\\n\\t]", "").replaceAll(" ", "");
			
			byte[] lastData = convertByte(data, "sha1X16", encoding);
			verify.update(lastData);
			
			byte[] result = SecureUtil.base64Decode(signature.getBytes(encoding));
			
			return verify.verify(result);
		}
		catch (AbstractBusiException e) {
			throw e;
		}
		catch(Exception e) {
			throw new AbstractBusiException(e);
		}
	}
	
	/**
	 * 对信息进行加密转换
	 *
	 * @param data
	 * @param method
	 * @param encoding
	 * @return
	 * @throws Exception
	 * 
	 */
	private static byte[] convertByte(String data, String method, String encoding) {
		if ("MD5".equalsIgnoreCase(method.trim())) {
			return SecureUtil.md5(data.getBytes());
		}
		if ("SHA-1".equalsIgnoreCase(method.trim()) || "SHA1".equalsIgnoreCase(method.trim())) {
			return SecureUtil.sha1(data.getBytes());
		}
		if ("md5X16".equalsIgnoreCase(method.trim())) {
			return SecureUtil.md5X16(data, encoding);
		}
		if ("sha1X16".equalsIgnoreCase(method.trim())) {
			return SecureUtil.sha1X16(data, encoding);
		}
		return data.getBytes();
	}

	public static boolean validateDown(DownloadRequest request, String certFilename) {
		try {
			DwnReqRoot root = request.getRoot();
			String signature = request.getSignature().trim();
			
			String certId = root.getCertId();
			String encoding = request.getRoot().getEncoding();
			String xmlString = XMLUtils.convertToXmlWithoutHead(root);
			
			return validateSignature(signature, xmlString, certFilename, encoding, certId);
		} 
		catch (Exception e) {
			logger.error("validate signature failure! ", e);
		}
		return false;
	}
	

}
