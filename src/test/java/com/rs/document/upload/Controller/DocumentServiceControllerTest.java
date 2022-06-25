package com.rs.document.upload.Controller;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rs.document.upload.controller.DocumentServiceController;
import com.rs.document.upload.model.DocumentDetails;
import com.rs.document.upload.service.DocumentStorageService;

@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceControllerTest {

	private MockMvc mockMvc;
	private InputStream is;

	@Mock
	DocumentStorageService storageService;

	@Spy
	@InjectMocks
	private DocumentServiceController documentServiceController = new DocumentServiceController();

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(documentServiceController).build();
		is = documentServiceController.getClass().getClassLoader().getResourceAsStream("excel.xlsx");
	}

	@Test
	public void uploadFileTest() throws Exception {
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "excel.xlsx", "multipart/form-data", is);
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.multipart("/upload").file(mockMultipartFile)
						.contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
		Assert.assertEquals(200, result.getResponse().getStatus());
		Assert.assertNotNull(result.getResponse().getContentAsString());
		Assert.assertEquals("{\"message\":\"Document is successfully uploaded, Name: excel.xlsx\"}",
				result.getResponse().getContentAsString());
	}

	@Test
	public void getListFiles() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/files").contentType(MediaType.ALL_VALUE))
				.andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
		Assert.assertEquals(200, result.getResponse().getStatus());
		Assert.assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void testDownloadFile() throws Exception {
		DocumentDetails documentDetails = new DocumentDetails();
		byte[] data = new byte[] { 0x00, 0x21, 0x60, 0x1F };
		documentDetails.setData(data);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/files")
				.contentType(MediaType.APPLICATION_OCTET_STREAM).accept("application/json"))
				.andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
		Assert.assertEquals(200, result.getResponse().getStatus());
		Assert.assertEquals(2, result.getResponse().getContentAsByteArray().length);
		Assert.assertEquals("application/json", result.getResponse().getContentType());
	}
}
