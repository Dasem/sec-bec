package com.example.accessingdatamysql;

import org.springframework.data.repository.*;

public interface MailCrud extends CrudRepository<Mail, Long> {
}
