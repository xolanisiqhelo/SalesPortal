package com.telkom.salesportal.activiti.utils;

import java.io.IOException;

import java.security.cert.CertificateException;
//import java.util.HashMap;
//import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class HttpClient {
	private OkHttpClient client;	
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);
	private MediaType TYPE = MediaType.parse("application/json");

	public HttpClient() {
		this.client = getUnsafeOkHttpClient();
	}
	
	
	public Response post(String url, String json) {
		LOGGER.info("Post \n " + json);
		try {
			RequestBody body = RequestBody.create(this.TYPE, json);
			Request request = new Request.Builder().url(url).post(body).build();
			Response response = client.newCall(request).execute();
			String responseBody = response.body().string();
			LOGGER.info("Response from " + responseBody);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Response get(String url) {
//		LOGGER.info("Sending to " + this.participantName + ":\n ");
		try {
			Request request = new Request.Builder().url(url).build();
			Response response = client.newCall(request).execute();
			String responseBody = response.body().string();
			LOGGER.info("Response from " + responseBody);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String put(String url, String json) {
		LOGGER.info("Sending to " + json);
		try {
			RequestBody body = RequestBody.create(this.TYPE, json);
			Request request = new Request.Builder().url(url).put(body).build();
			Response response = client.newCall(request).execute();
			String responseBody = response.body().string();
			LOGGER.info("Response from " + responseBody);
			return responseBody;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String patch(String url, String json) {
		LOGGER.info("Sending to " + json);
		try {
			RequestBody body = RequestBody.create(this.TYPE, json);
			Request request = new Request.Builder().url(url).patch(body).build();
			Response response = client.newCall(request).execute();
			String responseBody = response.body().string();
			LOGGER.info("Response from " + responseBody);
			return responseBody;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

//	public String delete(String url) {
//		LOGGER.info("Sending to " + this.participantName);
//		try {
//			Request request = new Request.Builder().url(url).delete().build();
//			Response response = client.newCall(request).execute();
//			String responseBody = response.body().string();
//			LOGGER.error("Response from " + this.participantName + ":\n " + responseBody);
//			return responseBody;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	private static OkHttpClient getUnsafeOkHttpClient() {
		try {
			// Create a trust manager that does not validate certificate chains
			final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws CertificateException {
				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws CertificateException {
				}

				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			} };

			// Install the all-trusting trust manager
			final SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			// Create an ssl socket factory with our all-trusting manager
			final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

			OkHttpClient okHttpClient = new OkHttpClient();
			okHttpClient.setSslSocketFactory(sslSocketFactory);
			okHttpClient.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});

			okHttpClient.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});

			return okHttpClient;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
