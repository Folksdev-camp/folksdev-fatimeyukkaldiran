package com.folksdev.fatimeyuk.blogapp.model

import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany

@Entity
data class Author @JvmOverloads constructor(

        val firstName: String,
        val lastName: String,
        val bio: String,
        val email: String,

        @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
        val posts: Set<Post>,

        @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
        val comments: Set<Comment>

) : BaseEntity() {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as Author

                return id != null && id == other.id
        }

        override fun hashCode(): Int = javaClass.hashCode()
}

