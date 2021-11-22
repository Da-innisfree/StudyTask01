package org.zerock.crizen.batch;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.crizen.controller.BoardController;
import org.zerock.crizen.service.BoardService;
import org.zerock.crizen.service.BoardServiceImpl;


public class Job1 implements Job {
	
//	private static Logger LOGGER = LoggerFactory.getLogger(Job1.class);
//	
//	private BoardService boardService;
//	
//	@Autowired
//	public void setBoardServiceImpl(BoardService boardService) {
//		this.boardService = boardService;
//	}
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		
//		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
//		BoardService service = (BoardService) jobDataMap.get("boardService");
//		Date date = new Date();
//		System.out.println(date);
//		service.test();

	}

}
