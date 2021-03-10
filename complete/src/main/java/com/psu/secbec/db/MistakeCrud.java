package com.psu.secbec.db;

import com.psu.secbec.model.*;
import org.springframework.data.repository.*;

public interface MistakeCrud extends CrudRepository<Mistake, Integer> {
    Mistake findByName(String name);
}
