package com.map.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.map.dto.InvoiceDto;
import com.map.dto.ProductDto;
import com.map.entity.Invoice;
import com.map.repository.InvoiceRepository;

@Service
public class SchedulerService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Scheduled(fixedDelay = 100)
	public void generateinvoice() throws Exception {

		List<Invoice> invoices = invoiceRepository.getallinvoicebystatus();

		Map<Object, List<Invoice>> InvoicesByCompany = invoices.stream()
				.collect(Collectors.groupingBy(invoice -> invoice.getCompany().getCompanyname()));

		for (Map.Entry<Object, List<Invoice>> entry : InvoicesByCompany.entrySet()) {
			List<Invoice> invoices1 = entry.getValue();

			for (Invoice finalInvoice : invoices1) {
				InvoiceDto invoiceDto = new InvoiceDto();
				invoiceDto.setUsername(finalInvoice.getUser().getUsername());
				invoiceDto.setTotal(finalInvoice.getTotal());
				invoiceDto.setCompanyid(finalInvoice.getCompany().getCompanyid());
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
				ProductDto product = objectMapper.readValue(finalInvoice.getProductJson(),ProductDto.class);
				System.out.println(product.toString());
				
			//	invoiceDto.setProduct(product);

				String url = "http://localhost:8081/invoice/invoicepdf";
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<InvoiceDto> request = new HttpEntity<>(invoiceDto, headers);
				ResponseEntity<InvoiceDto> response = restTemplate.postForEntity(url, request, InvoiceDto.class);
			//	InvoiceDto responseBody = response.getBody();
				
			}
		}

	}
}
