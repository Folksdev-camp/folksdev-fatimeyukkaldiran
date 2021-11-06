package com.folksdev.fatimeyuk.blogapp.model

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Post @JvmOverloads constructor(

        val title: String,
        val content: String,
        val status: BlogStatus,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id", referencedColumnName = "id")
        val author: Author

) : BaseEntity(){

}

enum class BlogStatus {
    PUBLISHED,
    DRAFT,
    DELETED

}
