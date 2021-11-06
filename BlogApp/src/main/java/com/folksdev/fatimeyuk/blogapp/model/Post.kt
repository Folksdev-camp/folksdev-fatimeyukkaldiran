package com.folksdev.fatimeyuk.blogapp.model

import javax.persistence.*

@Entity
data class Post @JvmOverloads constructor(

        val title: String,
        val content: String,
        val status: BlogStatus,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id", referencedColumnName = "id")
        val author: Author,

        @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
        val comments: Set<Comment>

) : BaseEntity(){

}

enum class BlogStatus {
    PUBLISHED,
    DRAFT,
    DELETED

}
