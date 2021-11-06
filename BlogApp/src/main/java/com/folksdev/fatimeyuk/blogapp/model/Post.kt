package com.folksdev.fatimeyuk.blogapp.model

import javax.persistence.*

@Entity
data class Post @JvmOverloads constructor(

        val title: String,
        val content: String,

        @field:Enumerated(EnumType.STRING)
        val status: BlogStatus,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id", referencedColumnName = "id")
        val author: Author,

        @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
        val comments: Set<Comment>,

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name = "post_tag",
                joinColumns = [JoinColumn(name = "post_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")]
        )
        val tags: Set<Tag>? = HashSet()

) : BaseEntity(){

}

enum class BlogStatus {
    PUBLISHED,
    DRAFT,
    DELETED

}
