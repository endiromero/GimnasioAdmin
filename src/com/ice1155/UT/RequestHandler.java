package com.ice1155.UT;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class RequestHandler {
	private int responseCode = -1;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	// GET method
	public String GET(String url) {
		HttpURLConnection connection = null;
		BufferedReader rd = null;
		StringBuilder sb = null;
		String line;
		URL serverAddress = null;
		String response = "";
		
		try {
			serverAddress = new URL(url);
			connection = (HttpURLConnection) serverAddress.openConnection();
			connection.setRequestMethod("GET");

			connection.setReadTimeout(120000);

			connection.connect();

			rd = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			sb = new StringBuilder();

			while ((line = rd.readLine()) != null) {
				sb.append(line + '\n');
			}
			response = sb.toString();
			this.setResponseCode(connection.getResponseCode());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Cierra la conexion
			connection.disconnect();
			rd = null;
			sb = null;
			connection = null;
		}
		return response.toString();
	}

	public String POST(String targetURL, String urlParameters) {
		URL url;

		HttpURLConnection connection = null;
		try {
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Bearer "
					+ Constantes.user.getToken());
			connection.setRequestProperty("Content-Type", "plain/text");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setReadTimeout(120000); // Send
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			this.setResponseCode(connection.getResponseCode());
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public String PUT(String targetURL, String urlParameters) {
		URL url;

		HttpURLConnection connection = null;
		try {
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Authorization", "Bearer "
					+ Constantes.user.getToken());
			connection.setRequestProperty("Content-Type", "plain/text");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setReadTimeout(120000); // Send
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			this.setResponseCode(connection.getResponseCode());
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
