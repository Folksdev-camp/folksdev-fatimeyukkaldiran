package com.folksdev.fatimeyuk.blogapp.model


import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import javax.persistence.*


@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    val id: String? = ""

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    @JsonIgnore
    val createdDate: Instant? = Instant.now()

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    val lastModifiedDate: Instant? = Instant.now()
}