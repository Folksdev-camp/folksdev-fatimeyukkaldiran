package com.folksdev.fatimeyuk.blogapp.model

import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Comment @JvmOverloads constructor(

        val comment: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id", referencedColumnName = "id")
        val author: Author,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_id", referencedColumnName = "id")
        val post: Post

) : BaseEntity() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Comment

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
}
