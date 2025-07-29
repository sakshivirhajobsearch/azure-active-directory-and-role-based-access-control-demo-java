package com.active.directory.and.role.based.access.control;

import java.util.Collections;

import com.azure.identity.ClientSecretCredential;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.User;
import com.microsoft.graph.requests.GraphServiceClient;

public class GraphClient {

	private final GraphServiceClient<?> graphClient;

	public GraphClient(ClientSecretCredential credential) {

		TokenCredentialAuthProvider authProvider = new TokenCredentialAuthProvider(
				Collections.singletonList("https://graph.microsoft.com/.default"), credential);

		this.graphClient = GraphServiceClient.builder().authenticationProvider(authProvider).buildClient();
	}

	public void getUserDetails() {

		User me = graphClient.me().buildRequest().get();
		System.out.println("Display Name: " + me.displayName);
		System.out.println("User Principal Name: " + me.userPrincipalName);
		System.out.println("ID: " + me.id);
	}
}
