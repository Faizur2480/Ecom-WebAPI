package com.Webapp.miniproject.ServiceImpl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.Webapp.miniproject.Entity.Counter;
import com.Webapp.miniproject.Repository.CounterRepository;
import com.Webapp.miniproject.Service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CounterRepository counterRepository;

	@Override
	public long nextSequenceNumber() throws Exception {

		List<Counter> counterList = counterRepository.findAll();
		Counter counter = new Counter();
		long seqNumber = 1;

		if (counterList.size() > 0) {
			counter = counterList.get(0);
			seqNumber = counter.getSequenceNumber() + 1;
			counter.setSequenceNumber(seqNumber);
		} else {
			counter.setSequenceNumber(1);
		}

		counterRepository.save(counter);

		return seqNumber;
	}

	public String getMessage(String messageKey, String[] params, String language) throws Exception {

		Locale locale = language == null || language.isEmpty() || !language.contains("_") ? Locale.getDefault()
				: new Locale(language.split("_")[0], language.split("_")[1]);

		if (params == null || params.length == 0) {
			return messageSource.getMessage(messageKey, null, locale);
		} else {
			return messageSource.getMessage(messageKey, params, locale);
		}
	}
}
