package com.udacity.pricing;

import com.udacity.pricing.service.PricingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest
public class PricingServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@MockBean
	PricingService pricingService;

	@Test
	public void testGetPrice() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/services/price?vehicleId=1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Assert.assertNotNull(PricingService.getPrice(1L));
	}

}