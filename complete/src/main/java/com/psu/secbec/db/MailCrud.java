package com.psu.secbec.db;

import com.psu.secbec.model.level1.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface MailCrud extends JpaRepository<Mail, Long> {
    List<Mail> findByLevel(int level);
}
