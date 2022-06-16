package pl.altkom.scah.ownerservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import com.github.tomakehurst.wiremock.core.Options;

@AutoConfigureWireMock(port = Options.DYNAMIC_PORT)
@SpringBootTest
class OwnerServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
