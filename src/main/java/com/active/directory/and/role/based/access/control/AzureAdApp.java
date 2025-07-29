package com.active.directory.and.role.based.access.control;

import java.io.IOException;
import java.util.Properties;

public class AzureAdApp {

	public static void main(String[] args) throws IOException {

		Properties props = new Properties();
		props.load(AzureAdApp.class.getClassLoader().getResourceAsStream("application.properties"));

		String clientId = props.getProperty("azure.client-id");
		String clientSecret = props.getProperty("azure.client-secret");
		String tenantId = props.getProperty("azure.tenant-id");

		TokenProvider tokenProvider = new TokenProvider(tenantId, clientId, clientSecret);
		GraphClient graphClient = new GraphClient(tokenProvider.getCredential());

		graphClient.getUserDetails();
	}
}
