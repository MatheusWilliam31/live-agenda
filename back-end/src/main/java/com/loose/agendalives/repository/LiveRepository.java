package com.loose.agendalives.repository;

import com.loose.agendalives.document.LiveDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

public interface LiveRepository extends MongoRepository <LiveDocument, String> {

    Page<LiveDocument> findByLiveDateAfterOrderByLiveDateAsc(LocalDateTime date, Pageable pageable);
    Page<LiveDocument> findByLiveDateAfterOrderByLiveDateDesc(LocalDateTime date, Pageable pageable);
}
