package com.map.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.map.dto.InvoiceDto;

public interface InvoiceService {

	Object saveinvoiceinformation(InvoiceDto invoiceDto)throws JsonProcessingException;

}
