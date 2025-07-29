package com.active.directory.and.role.based.access.control;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;

public class TokenProvider {

	private final ClientSecretCredential credential;

	public TokenProvider(String tenantId, String clientId, String clientSecret) {

		this.credential = new ClientSecretCredentialBuilder().tenantId(tenantId).clientId(clientId)
				.clientSecret(clientSecret).build();
	}

	public ClientSecretCredential getCredential() {
		return credential;
	}
}
