package com.folksdev.fatimeyuk.blogapp.model

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

}
