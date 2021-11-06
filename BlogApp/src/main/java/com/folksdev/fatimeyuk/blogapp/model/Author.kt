package com.folksdev.fatimeyuk.blogapp.model

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
        val posts: Set<Post>

) : BaseEntity() {

}

