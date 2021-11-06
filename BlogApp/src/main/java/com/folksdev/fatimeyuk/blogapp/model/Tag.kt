package com.folksdev.fatimeyuk.blogapp.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToMany

@Entity
data class Tag @JvmOverloads constructor(

        @Column(name = "tag_name")
        val name: String,

        @ManyToMany(mappedBy = "posts", fetch = FetchType.LAZY)
        val posts: Set<Post>

) : BaseEntity()
