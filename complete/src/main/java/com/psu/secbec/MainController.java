package com.psu.secbec;

import com.psu.secbec.db.*;
import com.psu.secbec.model.front.*;
import com.psu.secbec.model.level1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController	// This means that this class is a Controller
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
		// This returns a JSON or XML with the users
		return mailCrud.findByLevel(1);
	}

	@GetMapping(path="/level2/mails")
	public Iterable<Mail> getLevel2Mails() {
		// This returns a JSON or XML with the users
		return mailCrud.findByLevel(2);
	}

	@PostMapping(path="/result")
	public void saveResult(@RequestBody FrontResult frontResult) {
		testResultCrud.save(frontResult.convert(mistakeCrud));
	}
}
