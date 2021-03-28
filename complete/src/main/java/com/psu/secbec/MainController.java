package com.psu.secbec;

import com.psu.secbec.db.*;
import com.psu.secbec.model.front.*;
import com.psu.secbec.model.level1.*;
import com.psu.secbec.model.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController	// This means that this class is a Controller
@CrossOrigin
@RequestMapping // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired
	private MailCrud mailCrud;
	@Autowired
	private MistakeCrud mistakeCrud;
	@Autowired
	private TestResultCrud testResultCrud;

	@GetMapping(path="/level1/mails")
	public Iterable<Mail> getLevel1Mails() {
		return mailCrud.findByLevel(1);
	}

	@GetMapping(path="/level2/mails")
	public Iterable<Mail> getLevel2Mails() {
		return mailCrud.findByLevel(2);
	}

	@GetMapping(path="/level3/mails")
	public Iterable<Mail> getLevel3Mails() {
		return mailCrud.findByLevel(3);
	}

	@PostMapping(path="/result")
	public List<String> saveResult(@RequestBody FrontResult frontResult) {
		TestResult result = frontResult.convert(mistakeCrud);
		testResultCrud.save(result);
		return result.getMistakes().stream().map(Mistake::getDescription).collect(Collectors.toList());
	}
}
