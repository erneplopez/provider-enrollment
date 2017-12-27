package com.behavnotea.providerenrollment.repositories;

import com.behavnotea.providerenrollment.model.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document,Long> {
}
