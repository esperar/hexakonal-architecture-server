package esperer.hexakonal.domain.post.adapter.persistence.entity

import esperer.hexakonal.domain.user.adapter.persistence.entity.UserEntity
import esperer.hexakonal.global.entity.BaseTimeEntity
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "post")
class PostEntity(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", nullable = false, name = "post_id")
    val id: UUID,

    var title: String,
    var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: UserEntity,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "post_tag", joinColumns = [JoinColumn(name = "post_id")])
    var tag: MutableList<String>
): BaseTimeEntity()

fun PostEntity.toUpdate(title: String, content: String, tag: MutableList<String>) {
    this.title = title
    this.content = content
    this.tag = tag
}