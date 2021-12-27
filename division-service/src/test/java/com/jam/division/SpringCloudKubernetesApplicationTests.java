package com.jam.division;

import com.jam.division.model.Division;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes={DivisionApplication.class})
@EnableKubernetesMockClient(crud = true)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class SpringCloudKubernetesApplicationTests {

	static KubernetesClient client;

	@Autowired
	TestRestTemplate restTemplate;

	@BeforeAll
	static void init() {
		System.setProperty(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY,
				client.getConfiguration().getMasterUrl());
		System.setProperty(Config.KUBERNETES_TRUST_CERT_SYSTEM_PROPERTY,
				"true");
		System.setProperty(
				Config.KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY, "false");
		System.setProperty(
				Config.KUBERNETES_AUTH_TRYSERVICEACCOUNT_SYSTEM_PROPERTY, "false");
		System.setProperty(Config.KUBERNETES_HTTP2_DISABLE, "true");
		System.setProperty(Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY,
				"default");

	}

	@Test
	void addDivision() {
		Division division = new Division("1", "1");
		division = restTemplate.postForObject("/", division, Division.class);
		Assertions.assertNotNull(division);
		Assertions.assertNotNull(division.getId());
	}



}
