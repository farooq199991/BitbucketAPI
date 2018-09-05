package com.connecture.bitbucket.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.connecture.bitbucket.service.BitbucketService;


@Service
public class ApplicationEventListener {
	private Logger log = LoggerFactory.getLogger(ApplicationEventListener.class);

	@Autowired
	private BitbucketService service;

	/**
	 * Startup initialize cache for required services.
	 * 
	 * @param event for which this will trigger
	 */
	@EventListener
	public void onStartup(ApplicationReadyEvent event) {
		log.info("ApplicationEventListener :Startup.");
		this.service.initialize();
		log.info("ApplicationEventListener :Initialization Completed.");
	}

}
